package com.wang.basic.exchange_headers;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.wang.basic.MqUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Description:
 * 首部交换机和扇形交换机都不需要路由键routingKey,交换机时通过Headers头部来将消息映射到队列的，有点像HTTP的Headers，
 * Hash结构中要求携带一个键“x-match”，这个键的Value可以是any或者all，
 * 这代表消息携带的Hash是需要全部匹配(all)（生产者多发送一个head没关系），
 * 还是仅匹配一个键值对(any)就可以了（键值对的完全匹配，只匹配到键了，值却不一样是不行的；）。
 * 相比直连交换机，首部交换机的优势是匹配的规则不被限定为字符串(string)而是Object类型。

 * All Rights Reserved.
 * 原文：https://blog.csdn.net/vbirdbest/article/details/78638988
 * @version 1.0  2019-04-03 10:40  by  王帅（wangshuai@cloud-young.com）创建
 */
public class Producer {
    public static void main(String[] args) {
        ConnectionFactory factory = MqUtils.getConnectionFactory();
        //0.创建连接和通道
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            Map<String, Object> heardersMap = new HashMap<String, Object>();
            heardersMap.put("api", "login");
            heardersMap.put("version", 1.0);
            heardersMap.put("radom", UUID.randomUUID().toString());
            AMQP.BasicProperties.Builder properties = new AMQP.BasicProperties().builder().headers(heardersMap);

            String message = "Hello RabbitMQ!";
            String EXCHANGE_NAME = "exchange.hearders";
            channel.basicPublish(EXCHANGE_NAME, "", properties.build(), message.getBytes("UTF-8"));

        } catch (Exception ex) {

        }
    }
}
