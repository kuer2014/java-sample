package com.wang.basic;

import com.rabbitmq.client.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 生产者
 * All Rights Reserved.
 *
 * @version 1.0  2019-03-27 08:53  by  王帅（wangshuai@cloud-young.com）创建
 */
public class SendApp {
    private final static String QUEUE_NAME = "hello";
    private final static String EXCHANGE_NAME = "myExchange";

    public static void main(String[] args) {
        ConnectionFactory factory = MqUtils.getConnectionFactory();
        //0.创建连接和通道
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            //1.声明一个交换机
            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);

            //region 2.创建队列的参数(非必须，不设置使用默认)
            /*
            Map<String, Object> queueArgs = new HashMap<String, Object>();
            queueArgs.put("x-dead-letter-exchange", "refreshDispatcherDeadExchange");  //死信队列
            queueArgs.put("x-message-ttl", 10000);     // 消息超时：让发布的message在队列中可以存活多长时间，以毫秒为单位。
            queueArgs.put("x-expires", 1000);          // 队列超时：当前的queue在指定的时间内，没有消费者订阅就会被删除，以毫秒为单位。
            queueArgs.put("x-max-length", 100);        // 队列最大长度：当超过了这个大小的时候，会删除之前最早插入的消息为本次的留出空间。
            queueArgs.put("x-queue-mode", "lazy");     //延迟加载：queue的信息尽可能的都保存在磁盘上，仅在有消费者订阅的时候才会加载到RAM中。
            //更多
            queueArgs.put("x-max-length-bytes", 1024);//限定队列最大占用的空间大小， 一般受限于内存、磁盘的大小
            queueArgs.put("x-dead-letter-exchange", 100);//当队列消息长度大于最大长度、或者过期的等，将从队列中删除的消息推送到指定的交换机中去而不是丢弃掉
            queueArgs.put("x-dead-letter-routing-key", "routing-key"); //将删除的消息推送到指定交换机的指定路由键的队列中去
            queueArgs.put("x-max-priority", 5); //优先级队列，声明队列时先定义最大优先级值(定义最大值一般不要太大)，在发布消息的时候指定该消息的优先级， 优先级更高（数值更大的）的消息先被消费,
            queueArgs.put("x-queue-master-locator", "");// 配置镜像队列
           */
            //endregion
            //3.声明队列。-将队列参数传到队列 （队列名字，是否持久化，是否排外，是否自动清理，参数）
            //channel.queueDeclare(QUEUE_NAME, true, false, false, queueArgs);
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            //4.队列绑定交换机。   绑定键的意义依赖于转发器的类型，对于fanout类型，忽略此参数（第三个参数为binding key）。
            channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "");

            for (int i = 0; i < 2; i++) {
                String message = "Hello World!" + i;
                channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
                System.out.println(" [x] Sent '" + message + "'");
                Thread.sleep(1000);
            }
//            //设置单条消息的过期时间 Properties 的 expiration()方法
//            AMQP.BasicProperties.Builder properties = new AMQP.BasicProperties()
//                    .builder().expiration("1000");
//            channel.basicPublish(EXCHANGE_NAME, "", properties.build(), ("message hello").getBytes("UTF-8"));
//            //原文：https://blog.csdn.net/vbirdbest/article/details/78670550

            //region Properties 的全部属性：
          /*   Delivery mode: 是否持久化，1 - Non-persistent，2 - Persistent
            Headers：Headers can have any name. Only long string headers can be set here.
                    Properties: You can set other message properties here (delivery mode and headers are pulled out as the most common cases). Invalid properties will be ignored. Valid properties are:
            content_type ： 消息内容的类型
            content_encoding： 消息内容的编码格式
            priority： 消息的优先级
            correlation_id：关联id
            reply_to: 用于指定回复的队列的名称
            expiration： 消息的失效时间
            message_id： 消息id
            timestamp：消息的时间戳
            type： 类型
            user_id: 用户id
            app_id： 应用程序id
            cluster_id: 集群id
            Payload: 消息内容
                    */
            //endregion

            //region 消息持久化
/*
//消息持久化  设置消息持久化必须先设置队列持久化
            // 队列持久化
            boolean durable = true;
            channel.queueDeclare("hello", durable, false, false, null);
            ---------------------
// 消息持久化 方式一   MessageProperties.PERSISTENT_TEXT_PLAIN 参数
            channel.basicPublish("", "key", MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes("UTF-8"));
            ---------------------
// 消息持久化 方式二   properties.deliveryMode(2)设置
            AMQP.BasicProperties.Builder properties = new AMQP.BasicProperties().builder();
            properties.deliveryMode(2);  // 设置消息是否持久化，1： 非持久化 2：持久化
            channel.basicPublish("", "key", properties.build(), message.getBytes("UTF-8"));
            ---------------------
*/
//endregion
        } catch (Exception ex) {

        }
    }
}
