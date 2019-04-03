package com.wang.basic;

import com.rabbitmq.client.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:  Dead letter exchange(死亡交换机) 和 Dead letter routing key(死亡路由键)
 * 当队列中的消息过期，或者达到最大长度而被删除，或者达到最大空间时而被删除时，
 * 可以将这些被删除的信息推送到其他交换机中，让其他消费者订阅这些被删除的消息，处理这些消息
 * All Rights Reserved.
 * 原文：https://blog.csdn.net/vbirdbest/article/details/78670550
 *
 * @version 1.0  2019-04-03 18:12  by  王帅（wangshuai@cloud-young.com）创建
 */
public class DeadLetter {
    public static void main(String[] args) {
        ConnectionFactory factory = MqUtils.getConnectionFactory();
        //0.创建连接和通道
        try (
                Connection connection = factory.newConnection();
                Channel channel = connection.createChannel()) {
            // 声明一个接收被删除的消息的交换机和队列
            String EXCHANGE_DEAD_NAME = "exchange.dead";
            String ROUTINGKEY_DEAD_NAME = "routingkey.dead";
            String QUEUE_DEAD_NAME = "queue_dead";
            channel.exchangeDeclare(EXCHANGE_DEAD_NAME, BuiltinExchangeType.DIRECT);
            channel.queueDeclare(QUEUE_DEAD_NAME, false, false, false, null);
            channel.queueBind(QUEUE_DEAD_NAME, EXCHANGE_DEAD_NAME, ROUTINGKEY_DEAD_NAME);

            String EXCHANGE_NAME = "exchange.dead.fanout";
            String QUEUE_NAME = "queue_name";
            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);
            Map<String, Object> arguments = new HashMap<String, Object>();
            // 统一设置队列中的所有消息的过期时间
            arguments.put("x-message-ttl", 30000);
            // 设置超过多少毫秒没有消费者来访问队列，就删除队列的时间
            arguments.put("x-expires", 20000);
            // 设置队列的最新的N条消息，如果超过N条，前面的消息将从队列中移除掉
            arguments.put("x-max-length", 4);
            // 设置队列的内容的最大空间，超过该阈值就删除之前的消息
            arguments.put("x-max-length-bytes", 1024);
            // 将删除的消息推送到指定的交换机，一般x-dead-letter-exchange和x-dead-letter-routing-key需要同时设置
            arguments.put("x-dead-letter-exchange", EXCHANGE_DEAD_NAME);
            // 将删除的消息推送到指定的交换机对应的路由键
            arguments.put("x-dead-letter-routing-key", ROUTINGKEY_DEAD_NAME);
            // 设置消息的优先级，优先级大的优先被消费
           // arguments.put("x-max-priority", 10);
            channel.queueDeclare(QUEUE_NAME, false, false, false, arguments);
            channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "");//为什么路由键是""？扇型交换机（funout exchange）将消息路由给绑定到它身上的所有队列，而不理会绑定的路由键。


            String message = "Hello RabbitMQ: ";
            for (int i = 1; i <= 5; i++) {
                // expiration: 设置单条消息的过期时间
                AMQP.BasicProperties.Builder properties = new AMQP.BasicProperties().builder().priority(i).expiration(i * 1000 + "");
                channel.basicPublish(EXCHANGE_NAME, "", properties.build(), (message + i).getBytes("UTF-8"));
            }
            Thread.sleep(200000);
        } catch (Exception ex) {

        }
    }
}
