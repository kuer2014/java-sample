package com.wang.basic.exchange_direct.default_exchange;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.wang.basic.MqUtils;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2019-03-27 08:53  by  王帅（wangshuai@cloud-young.com）创建
 */
public class SendApp {
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) {
        ConnectionFactory factory = MqUtils.getConnectionFactory();
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
           /*当不指定交换机信息时，系统会为每个队列都隐式的绑定一个默认的交换机，交换机的名称为“(AMQP default)”,  类型为直连接direct，
            等同： channel.exchangeDeclare(“(AMQP default)”, BuiltinExchangeType.DIRECT);*/
           /*当你手动创建一个队列时，后台会自动将这个队列绑定到一个名称为“(AMQP default)”的Direct类型交换机上，绑定路由名称与队列名称相同，
           等同：  channel.queueBind(queue:”QUEUE_NAME”, exchange:”(AMQP default)”, routingKey:”QUEUE_NAME”); */
            for (int i = 0; i < 1000; i++) {
                String message = "Hello World!" + i;
                channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
                System.out.println(" [x] Sent '" + message + "'");
                Thread.sleep(10);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
