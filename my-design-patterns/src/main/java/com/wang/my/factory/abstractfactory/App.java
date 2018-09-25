package com.wang.my.factory.abstractfactory;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/25 16:37  by  王帅（wangshuai@cloud-young.com）创建
 */
public class App {
    public static void main(String[] args) {
      MailSendFactory mailSendFactory=   FactoryProducer.getMailSendFactory();
mailSendFactory.get163MailSender().send();

    }
}
