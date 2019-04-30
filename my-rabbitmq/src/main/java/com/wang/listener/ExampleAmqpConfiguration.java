package com.wang.listener;


import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.DirectMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2019-04-29 15:23  by  王帅（wangshuai@cloud-young.com）创建
 */
@Configuration
public class ExampleAmqpConfiguration {
    @Bean
    public SimpleMessageListenerContainer messageListenerContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(rabbitConnectionFactory());
        container.setQueueNames("myqueue");
        //container.setMessageListener(exampleListener());
        //container.setMessageListener(new MyMessageListener());
        //如果您的回调逻辑出于任何原因依赖于AMQP Channel实例，您可以改为使用ChannelAwareMessageListener。
        container.setMessageListener(new MyChannelAwareMessageListener());
        return container;
    }
    /**
     * @Descpription: 在2.0版之前，有一个监听器容器，即SimpleMessageListenerContainer。
     * 现在有第二个容器，DirectMessageListenerContainer。
     * @version 1.0  2019-04-30 17:46   by  王帅（wangshuai@cloud-young.com）创建
     */
    @Bean
    public DirectMessageListenerContainer directMessageListenerContainer() {
        DirectMessageListenerContainer container = new DirectMessageListenerContainer();
        container.setConnectionFactory(rabbitConnectionFactory());
        container.setQueueNames("myqueue");
        container.setMessageListener(new MyMessageListener());
        return container;
    }
    @Bean
    public ConnectionFactory rabbitConnectionFactory() {
        CachingConnectionFactory connectionFactory =
                new CachingConnectionFactory("localhost");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("n0cxvlfWsRpx");
        //connectionFactory.setVirtualHost("");
        return connectionFactory;
    }

//    @Bean
//    public MessageListener exampleListener() {
//        return new MessageListener() {
//            public void onMessage(Message message) {
//                System.out.println("received: " + message);
//            }
//        };
//    }
}
