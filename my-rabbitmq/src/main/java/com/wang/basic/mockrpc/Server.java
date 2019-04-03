package com.wang.basic.mockrpc;

import com.rabbitmq.client.*;
import com.wang.basic.MqUtils;

import java.io.IOException;

/**
 * Description:
 * All Rights Reserved.
 * 原文：https://blog.csdn.net/vbirdbest/article/details/78634188
 * @version 1.0  2019-04-03 09:02  by  王帅（wangshuai@cloud-young.com）创建
 */
public class Server {
    //先运行服务端，再运行客户端
    public static void main(String[] args) {
        ConnectionFactory factory = MqUtils.getConnectionFactory();
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            String rpc_queuqu = "rpc_queue";
            channel.queueDeclare(rpc_queuqu, false, false, false, null);
            channel.basicQos(1);

            Consumer consumer = new DefaultConsumer(channel){
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println("服务端：已接收到请求消息：" + message);
                    // 服务器端接收到消息并处理消息
                    String response = "{'code': 200, 'data': '" + message+ "'}";

                    // 将消息发布到reply_to响应队列中
                    AMQP.BasicProperties replyProperties = new AMQP.BasicProperties.Builder().
                            correlationId(properties.getCorrelationId()).build();//关联id(correlationId), 发消息的时候会带上这个值，该值在客户端接收响应时用于判断接收到的响应消息是否是自己发出请求对应的响应； 客户端在发送请求时需要带上replyTo和correlationId两个属性。
                    String replyTo = properties.getReplyTo();//得到响应队列对应的routingKey名字
                    channel.basicPublish("", replyTo, replyProperties, response.getBytes("UTF-8"));
                    System.out.println("服务端：请求已处理完毕，响应结果" + response + "已发送到响应队列中");
                    // 手动应答
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
            };

            // 手动应答模式
            channel.basicConsume(rpc_queuqu, false, consumer);

            System.out.println("服务端：已订阅请求队列(rpc_queue), 开始等待接收请求消息...");
            Thread.sleep(100000);

        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }
}
