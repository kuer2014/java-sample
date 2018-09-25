package com.wang.my.factory.abstractfactory2;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/25 16:37  by  王帅（wangshuai@cloud-young.com）创建
 */
public class App {
    public static void main(String[] args) {
        MailSender mailSender = FactoryProducer.getMailSendFactory().getMailSender();
        mailSender.send();

        FactoryProducer.getSmsSendFactory().getSmsSender().send();
    }
}
