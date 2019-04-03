package com.wang.basic;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * Description:消费者
 * All Rights Reserved.
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
                    //消息处理（自己实现的方法）
                    System.out.println(message);
                    //消息手动确认，配合 channel.basicConsume()方法的参数
                   // channel.basicAck(envelope.getDeliveryTag(), false);

                }
            };
            //第二个参数值为false时代表关闭RabbitMQ的自动应答机制，改为手动应答。
            channel.basicConsume(QUEUE_NAME, false, consumer);

            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
            Thread.sleep(2000000);
        } catch (Exception ex) {
            //出现异常，置为true，重新入队。
            // channel.basicAck(envelope.getDeliveryTag(), true);
            //出现异常，不重新入队，而是reject入死信队列。
            //channel.basicReject(envelope.getDeliveryTag(), false);

        }
    }
}
