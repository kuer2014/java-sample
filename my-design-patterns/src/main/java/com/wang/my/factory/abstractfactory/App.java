package com.wang.my.factory.abstractfactory;

/**
 * Description:抽象工厂模式
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/25 16:37  by  王帅（wangshuai@cloud-young.com）创建
 */
public class App {
    public static void main(String[] args) {
        AbstractSendFactory _163Send = new F163SendFactory();
        AbstractMailSender _163Mail = _163Send.getMailSender();
        AbstractSmsSender _163Sms = _163Send.getSmsSender();
        _163Mail.send();
        _163Sms.send();

        AbstractSendFactory qqSend = new FQqSendFactory();
        AbstractMailSender qqMail = qqSend.getMailSender();
        AbstractSmsSender qqSms = qqSend.getSmsSender();
        qqMail.send();
        qqSms.send();
    }
}
