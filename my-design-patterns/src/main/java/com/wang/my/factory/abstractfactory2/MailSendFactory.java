package com.wang.my.factory.abstractfactory2;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/25 16:39  by  王帅（wangshuai@cloud-young.com）创建
 */
public class MailSendFactory extends SendFactory {
    public MailSender getMailSender() {
        return new MailSenderImpl();
    }

    public SmsSender getSmsSender() {
        return new SmsSenderImpl();
    }
}
