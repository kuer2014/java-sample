package com.wang.basic.exchange_direct;

import com.rabbitmq.client.*;
import com.wang.basic.MqUtils;

import java.io.IOException;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2019-04-02 09:51  by  王帅（wangshuai@cloud-young.com）创建
 */
public class Consumer1 {
    public static void main(String[] args) {
        ConnectionFactory factory=   MqUtils.getConnectionFactory();
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            String EXCHANGE_NAME = "exchange.direct.routing";

            // channel.queueDeclare();//不传递任何参数，来创建一个非持久的、唯一的、自动删除的队列且队列名称由服务器随机产生。
            // 生成一个随机的名称，queueDeclare()方法没有任何参数，当最后一个消费者断开时就会删除掉该队列，当消费者结束后可以看到队列就删除了
           String QUEUE_NAME = channel.queueDeclare().getQueue();
            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
            // 在消费者端队列绑定
            // 将一个对列绑定多个路由键
            String[] routingKeys = {"debug", "info"};
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
