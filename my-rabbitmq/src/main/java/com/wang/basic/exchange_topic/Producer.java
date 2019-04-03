package com.wang.basic.exchange_topic;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.wang.basic.MqUtils;

/**
 * Description:
 * 主题类型topic，直连接类型direct必须是生产者发布消息指定的routingKey和消费者在队列绑定时指定的routingKey完全相等时才能匹配到队列上，
 * 与direct不同,topic可以进行模糊匹配，可以使用星号*和井号#这两个通配符来进行模糊匹配，其中星号可以代替一个单词；
 * 主题类型的转发器的消息不能随意的设置选择键（routing_key），必须是由点隔开的一系列的标识符组成。
 * 标识符可以是任何东西，但是一般都与消息的某些特性相关。
 * 一些合法的选择键的例子：”quick.orange.rabbit”,你可以定义任何数量的标识符，上限为255个字节。
 * #井号可以替代零个或更多的单词，只要能模糊匹配上就能将消息映射到队列中。
 * 当一个队列的绑定键为#的时候，这个队列将会无视消息的路由键，接收所有的消息
 * All Rights Reserved.
 *   原文：https://blog.csdn.net/vbirdbest/article/details/78631035
 * @version 1.0   2019-04-02 19:57   by  王帅（wangshuai@cloud-young.com）创建
 */
public class Producer {
    //先启动消费者，再启动生产者
    public static void main(String[] args) {
        ConnectionFactory factory=   MqUtils.getConnectionFactory();
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            // Routing 的路由规则使用直连接
            String EXCHANGE_NAME = "exchange.topic.x";
            String[] routingKeys = {"quick.orange.rabbit", "lazy.orange.elephant", "mq.erlang.rabbit", "lazy.brown.fox", "lazy."};
            for (String routingKey : routingKeys){
                String message = "Hello RabbitMQ - " + routingKey;

                channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes("UTF-8"));
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
