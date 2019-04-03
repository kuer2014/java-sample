package com.wang.basic.exchange_fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.wang.basic.MqUtils;

/**
 * Description:扇形交换机发布/订阅(Publish/Subscribe
 * 原文：https://blog.csdn.net/vbirdbest/article/details/78628659
 * All Rights Reserved.
 *  本节主要演示交换机的广播类型fanout，广播类型不需要routingKey，交换机会将所有的消息都发送到每个绑定的队列中去。
 *
 * 在发布消息时可以只先指定交换机的名称，交换机的声明的代码可以放到消费者端进行声明，队列的声明也放在消费者端来声明。
 *
 * 发布订阅类似观察者模式设计模式，一般适用于当接收到某条消息时同时做多种类似的任务的处理，如一个发短信，另一个一个发邮件；一个插入数据库，另一个保存在文件等类似操作，扇形交换机将消息传送给不同的队列，不同的队列对同一种消息采取不同的行为。
 *
 * 扇形交换机是最基本的交换机类型，它所能做的事情非常简单———广播消息。扇形交换机会把能接收到的消息全部发送给绑定在自己身上的队列。因为广播不需要“思考”，所以扇形交换机处理消息的速度也是所有的交换机类型里面最快的。
 * ---------------------
 * @version 1.0  2019-04-01 17:35  by  王帅（wangshuai@cloud-young.com）创建
 */
public class Producer {
    public static void main(String[] args) {
        ConnectionFactory factory = MqUtils.getConnectionFactory();
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            String EXCHANGE_NAME = "exchange.fanout";
            // 生产者不需要队列声明，也不需要声明交换机，只需要指定交换机的名称即可，队列和交换机的声明可以在消费者中声明
            // 循环发布多条消息, 注意广播模式不需要routingKey, 可以写成""， 也可以随意写个名字，在消费者也随便写一个，生产者和消费者的routingKey的不一样看看可以不
            for (int i = 0; i < 10; i++) {
                String message = "Hello RabbitMQ " + i;
                // 广播类型不需要routingKey，但是不能写成null，可以写成空字符串""
                channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes("UTF-8"));
                Thread.sleep(3000);
            }
        } catch (Exception ex) {

        }

    }
}
