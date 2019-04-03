package com.wang.basic.exchange_direct.default_exchange;

import com.rabbitmq.client.*;
import com.wang.basic.MqUtils;

import java.io.IOException;

/**
 * Description:侦听来自RabbitMQ的消息
 * All Rights Reserved.
 *
 * @version 1.0  2019-03-27 09:01  by  王帅（wangshuai@cloud-young.com）创建
 */
public class RecvApp {
    private final static String QUEUE_NAME = "hello";
    public static void main(String[] argv) {
        ConnectionFactory factory = MqUtils.getConnectionFactory();
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println(message);
                }
            };
            channel.basicConsume(QUEUE_NAME, true, consumer);
            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
