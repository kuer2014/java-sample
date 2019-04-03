package com.wang.basic.exchange_topic;

import com.rabbitmq.client.*;
import com.wang.basic.MqUtils;

import java.io.IOException;

/**
 * Description:
 * 原文：https://blog.csdn.net/vbirdbest/article/details/78631035
 * All Rights Reserved.
 *
 * @version 1.0  2019-04-02 09:51  by  王帅（wangshuai@cloud-young.com）创建
 */
public class Consumer1 {
    //先启动消费者，再启动生产者
    public static void main(String[] args) {
        ConnectionFactory factory=   MqUtils.getConnectionFactory();
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            String EXCHANGE_NAME = "exchange.topic.x";
            String QUEUE_NAME = "queue.topic.q1";
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);

            String[] routingKeys = {"*.orange.*"};
            for (int i = 0; i < routingKeys.length; i++) {
                channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, routingKeys[i]);
            }

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

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
