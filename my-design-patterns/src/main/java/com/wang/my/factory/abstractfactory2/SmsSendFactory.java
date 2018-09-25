package com.wang.my.factory.abstractfactory2;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/25 16:45  by  王帅（wangshuai@cloud-young.com）创建
 */
public class SmsSendFactory extends SendFactory {
    public MailSender getMailSender() {
        return null;
    }

    public SmsSender getSmsSender() {
        return null;
    }
}
