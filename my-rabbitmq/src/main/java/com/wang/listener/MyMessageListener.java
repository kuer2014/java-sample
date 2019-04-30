package com.wang.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2019-04-30 15:37  by  王帅（wangshuai@cloud-young.com）创建
 */
@Component
public class MyMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println("received: " + new String ( message.getBody()));
    }

//    public void onMessage(Message message, Channel channel) throws Exception {
//        System.out.println("received: " + message);
//    }
}
