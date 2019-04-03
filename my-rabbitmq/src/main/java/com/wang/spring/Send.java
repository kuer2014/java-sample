package com.wang.spring;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Collections;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2019-03-27 16:34  by  王帅（wangshuai@cloud-young.com）创建
 */
public class Send {
    public static void main(String[] args) {
        ApplicationContext context =
            //    new GenericXmlApplicationContext("classpath:rabbitmq-context.xml");
                new ClassPathXmlApplicationContext("rabbitmq-context.xml");
        AmqpTemplate template = context.getBean(AmqpTemplate.class);
        template.convertAndSend("myqueue", "foo msg");
        String foo = (String) template.receiveAndConvert("myqueue");
        System.out.println("foo = "+foo);
        //template.send();

    }
}
