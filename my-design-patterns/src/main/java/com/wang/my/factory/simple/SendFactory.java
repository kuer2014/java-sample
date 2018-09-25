package com.wang.my.factory.simple;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/25 14:52  by  王帅（wangshuai@cloud-young.com）创建
 */
public class SendFactory {
    public static Sender getMailSender(){
        return new MailSender();
    }
    public static Sender getSmsSender(){
        return new SmsSender();
    }
}
