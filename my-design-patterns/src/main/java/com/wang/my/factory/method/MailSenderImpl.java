package com.wang.my.factory.method;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/25 15:05  by  王帅（wangshuai@cloud-young.com）创建
 */
public class MailSenderImpl implements Sender {
    public void send() {
        System.out.println("Mail send.");
    }
}
