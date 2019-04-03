package com.wang.basic.exchange_fanout;

import com.rabbitmq.client.*;
import com.wang.basic.MqUtils;

import java.io.IOException;

/**
 * Description:消费者1
 * All Rights Reserved.
 *
 * @version 1.0  2019-04-01 17:42  by  王帅（wangshuai@cloud-young.com）创建
 */
public class Consumer1 {
    public static void main(String[] args) {
        ConnectionFactory factory = MqUtils.getConnectionFactory();
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.basicQos(1);
            String QUEUE_NAME = "queue.fanout.q1";
            String EXCHANGE_NAME = "exchange.fanout";
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            // 声明交换机：指定交换机的名称和类型(广播：fanout)
            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);
            // 在消费者端队列绑定
            channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "");
            System.out.println("Consumer Wating Receive Message");

            Consumer consumer = new DefaultConsumer(channel){
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println(" [C] Received '" + message + "', 处理业务中...");
                }
            };
            channel.basicConsume(QUEUE_NAME, true, consumer);
            Thread.sleep(1000000);
        } catch (Exception ex) {

        }
    }
}
