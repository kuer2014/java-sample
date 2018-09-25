package com.wang.my.factory.method;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/25 15:06  by  王帅（wangshuai@cloud-young.com）创建
 */
public class SmsSenderImpl implements Sender {
    public void send() {
        System.out.println("Sms send.");
    }
}
