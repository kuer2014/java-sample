package com.wang.basic;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * Description:消费者
 * All Rights Reserved.
 * RabbitMQ中消费消息有两种模式，推模式（Push）和拉模式（Pull），
 * 在我们平时的开发过程中采取的模式多为推模式（channel.basicConsume(QUEUE_NAME, false, consumer），
 * 因为这种推模式为RabbitMQ主动推给消费者进行消费，从而很好的避免了消息的积压，同时也可以减少消息瞬间增多多内存的消耗。
 * 但是当需要对消息进行批量处理时，则拉模式更为方便，（channel.basicGet(QUEUE_NAME, false);）
 * 同时，当由于某些限制，消费者在某个条件成立时才能消费消息时也采取这种拉的模式。
 *
 * @version 1.0  2019-03-27 09:01  by  王帅（wangshuai@cloud-young.com）创建
 */
public class RecvApp {
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = MqUtils.getConnectionFactory();
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            //channel.basicQos(1);//告诉消费者一次只能从队列中预先获取一条(预提取数量prefetchCount)，处理完了再获取另一条，
//       channel.messageCount(QUEUE_NAME)
//         channel.basicGet(QUEUE_NAME, true);

            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    // 捕获消息内容
                    String message = new String(body, "UTF-8");
                    //消息处理（业务代码）
                    System.out.println(message);
                    //1,确认消费
                    //消息手动确认，配合 channel.basicConsume()方法的参数（当basicConsume（）的autoAck为false时需要手动确认）
                    channel.basicAck(envelope.getDeliveryTag(), false);
                    //2,拒绝消费
                    //第二个参数requeue说明：false时直接丢弃，相当于告诉队列可以直接删除掉;true时重新放入队列
                    channel.basicReject(envelope.getDeliveryTag(), false);
                    //3,重新投递,参数可选：true时，重新投递时会投给所有消费者；false时，消息将重新投递给相同的使用者。
                    //不传参时相当于true
                    channel.basicRecover(true);
                }
            };

            //第二个参数值为false时代表关闭RabbitMQ的自动应答机制，改为手动应答。
            channel.basicConsume(QUEUE_NAME, false, consumer); //推模式（生产者推送过来）

            // channel.basicGet(QUEUE_NAME,true);//拉模式（消费者拉取过来）

            //web管理面中Messages状态列说明： Total代表队列中的消息总条数，Ready代表消费者还可以读到的条数，Unacked:代表还有多少条没有被应答
            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
            Thread.sleep(200000);
        } catch (Exception ex) {
            //出现异常，置为true，重新入队。
            // channel.basicAck(envelope.getDeliveryTag(), true);
            //出现异常，不重新入队，而是reject入死信队列。
            //channel.basicReject(envelope.getDeliveryTag(), false);

        }
    }
}
