package com.wang.my.factory.abstractfactory;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/25 16:39  by  王帅（wangshuai@cloud-young.com）创建
 */
public class MailSendFactory  {
    public  MailSender get163MailSender() {
        return new _163MailSenderImpl();
    }
    public static MailSender getSinaMailSender() {
        return new _SinaMailSenderImpl();
    }
}
