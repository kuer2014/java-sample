package com.wang.basic.exchange_direct;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.wang.basic.MqUtils;

/**
 * Description:路由选择Routing
 *   原文：https://blog.csdn.net/vbirdbest/article/details/78629168
 * All Rights Reserved.
 *本节主要演示使用直连接类型，将多个路由键绑定到同一个队列上。
 * 也可以将同一个键绑定到多个队列上(多重绑定multiple bindings)，此时满足键的队列都能收到消息，不满足的直接被丢弃。
 * @version 1.0  2019-04-02 09:45  by  王帅（wangshuai@cloud-young.com）创建
 */
public class Producer {
    public static void main(String[] args) {
        ConnectionFactory factory=   MqUtils.getConnectionFactory();
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            // Routing 的路由规则使用直连接
            String EXCHANGE_NAME = "exchange.direct.routing";
            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
            //channel.queueBind()
            String[] routingKeys = {"debug", "info", "warning", "error"};
            for (int i = 0; i < 20; i++){
                int random = (int)(Math.random() * 4);
                String routingKey = routingKeys[random];
                String message = "Hello RabbitMQ - " + routingKey + " - " + i;
                channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes("UTF-8"));
                Thread.sleep(2000);
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
