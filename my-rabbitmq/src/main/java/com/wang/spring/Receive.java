package com.wang.spring;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2019-04-29 01:28  by  王帅（wangshuai@cloud-young.com）创建
 */
public class Receive {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("rabbitmq-context.xml");
        AmqpTemplate template = context.getBean(AmqpTemplate.class);
        String foo = (String) template.receiveAndConvert("myqueue");

        System.out.println("foo = "+foo);

        //template.receiveAndReply()
    }
}
