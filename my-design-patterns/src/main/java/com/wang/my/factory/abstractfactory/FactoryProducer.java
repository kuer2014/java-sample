package com.wang.my.factory.abstractfactory;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/25 16:50  by  王帅（wangshuai@cloud-young.com）创建
 */
public class FactoryProducer {
    public static MailSendFactory getMailSendFactory() {
        return new MailSendFactory();
    }

    public static SmsSendFactory getSmsSendFactory() {
        return new SmsSendFactory();
    }
}
