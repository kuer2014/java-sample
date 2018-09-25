package com.wang.my.factory.abstractfactory2;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/25 16:36  by  王帅（wangshuai@cloud-young.com）创建
 */
public class SmsSenderImpl implements SmsSender {
    public void send() {
        System.out.println("Sms send.");
    }
}
