package com.wang.basic.mockrpc;

import com.rabbitmq.client.*;
import com.wang.basic.MqUtils;

import java.io.IOException;
import java.util.UUID;

/**
 * Description:
 * All Rights Reserved.
 *原文：https://blog.csdn.net/vbirdbest/article/details/78634188
 * @version 1.0  2019-04-03 08:55  by  王帅（wangshuai@cloud-young.com）创建
 */
public class Client {
    //先运行服务端，再运行客户端
    public static void main(String[] args) {
        ConnectionFactory factory = MqUtils.getConnectionFactory();
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            // 预先定义响应的结果，即预先订阅响应结果的队列，先订阅响应队列，再发送消息到请求队列
            String reyply_to_queue = channel.queueDeclare().getQueue();//队列的名字是随机生成的字符串
            final String correlationId = UUID.randomUUID().toString();
            Consumer consumer = new DefaultConsumer(channel){
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    if (properties.getCorrelationId().equals(correlationId)) {
                        String message = new String(body, "UTF-8");
                        System.out.println("已接收到服务器的响应结果：" + message);
                    }
                }
            };
            channel.basicConsume(reyply_to_queue, true, consumer);

            // 将消息发送到请求队列中
            String rpc_queuqu = "rpc_queue";
            String message = "Hello RabbitMQ";
            //将请求消息发送到请求队列，在发送请求时需要指定replyTo和correlationId两个值；
            AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder().correlationId(correlationId).replyTo(reyply_to_queue).build();
            channel.basicPublish("", rpc_queuqu, properties, message.getBytes("UTF-8"));
            System.out.println("已发出请求请求消息：" + message);
            Thread.sleep(100000);
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }
}
