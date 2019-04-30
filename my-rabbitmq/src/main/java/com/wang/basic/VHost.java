package com.wang.basic;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Description:虚拟主机vhost
 * 每一个RabbitMQ服务器都能创建虚拟消息服务器，我们称之为虚拟主机。
 * 每一个vhost本质上是一个mini版的RabbitMQ服务器，拥有自己的交换机、队列、绑定等，拥有自己的权限机制。
 * vhost之于Rabbit就像虚拟机之于物理机一样。他们通过在各个实例间提供逻辑上分离，允许为不同的应用程序安全保密的运行数据，这很有用，它既能将同一个Rabbit的众多客户区分开来，又可以避免队列和交换器的命名冲突。
 * RabbitMQ提供了开箱即用的默认的虚拟主机“/”，如果不需要多个vhost可以直接使用这个默认的vhost，通过使用缺省的guest用户名和guest密码来访问默认的vhost。
 * vhost之间是相互独立的，这避免了各种命名的冲突，就像App中的沙盒的概念一样，每个沙盒是相互独立的，且只能访问自己的沙盒，以保证非法访问别的沙盒带来的安全隐患。

 * All Rights Reserved.
 *原文：https://blog.csdn.net/vbirdbest/article/details/78702685
 * @version 1.0  2019-04-05 09:54  by  王帅（wangshuai@cloud-young.com）创建
 */
public class VHost {
    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setVirtualHost("my_vhost");
        factory.setHost("localhost");
        //factory.setPort(15672);
        factory.setUsername("wang");
        factory.setPassword("123");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            String EXCHANGE_NAME = "v.exchange.direct";
            String QUEUE_NAME = "v.queue_name";
            String ROUTING_KEY = "v.key";
            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);
            channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY);

            String message = "V Host Hello RabbitMQ:";
            try {
                channel.txSelect();
                for (int i = 0; i < 5; i++) {
                    channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, null, (message + i).getBytes("UTF-8"));
                }
                channel.txCommit();
            } catch (Exception e) {
                e.printStackTrace();
                channel.txRollback();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
