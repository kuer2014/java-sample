package com.wang.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

/**
 * Description:
 * All Rights Reserved.
 *如果您的回调逻辑出于任何原因依赖于AMQP Channel实例，您可以改为使用ChannelAwareMessageListener。
 * 它看起来很相似，但有一个额外的参数。
 * @version 1.0  2019-04-30 15:37  by  王帅（wangshuai@cloud-young.com）创建
 */
@Component
public class MyChannelAwareMessageListener implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) {
        System.out.println("received: " + new String ( message.getBody()));
    }


}
