package com.wang.basic.exchange_headers;

import com.rabbitmq.client.*;
import com.wang.basic.MqUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * All Rights Reserved.
 * 原文：https://blog.csdn.net/vbirdbest/article/details/78638988
 * @version 1.0  2019-04-03 10:46  by  王帅（wangshuai@cloud-young.com）创建
 */
public class Consumer1 {
    public static void main(String[] args) {
        ConnectionFactory factory = MqUtils.getConnectionFactory();
        //0.创建连接和通道
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            String EXCHANGE_NAME = "exchange.hearders";
            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.HEADERS);

            String queueName = channel.queueDeclare().getQueue();
            Map<String, Object> arguments = new HashMap<String, Object>();
            arguments.put("x-match", "any");
            arguments.put("api", "login");
            arguments.put("version", 1.0);
            arguments.put("dataType", "json");


            // 队列绑定时需要指定参数,注意虽然不需要路由键但仍旧不能写成null，需要写成空字符串""
            channel.queueBind(queueName, EXCHANGE_NAME, "", arguments);
            Consumer consumer = new DefaultConsumer(channel){
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println(message);
                }
            };

            channel.basicConsume(queueName, true, consumer);
            Thread.sleep(200000);
        } catch (Exception ex) {

        }
    }
}
