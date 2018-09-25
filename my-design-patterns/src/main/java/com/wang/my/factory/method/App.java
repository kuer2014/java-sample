package com.wang.my.factory.method;

/**
 * Description:工厂方法模式
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/25 15:13  by  王帅（wangshuai@cloud-young.com）创建
 */
public class App {
    public static void main(String[] args) {
        SendFactory mailFactory=new MailSendFactoryImpl();
        mailFactory.getSender().send();

        SendFactory smsFactory = new SmsSendFactoryImpl();
        smsFactory.getSender().send();
    }
}
