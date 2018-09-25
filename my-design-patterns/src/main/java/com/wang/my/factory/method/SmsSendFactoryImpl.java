package com.wang.my.factory.method;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/25 15:11  by  王帅（wangshuai@cloud-young.com）创建
 */
public class SmsSendFactoryImpl implements SendFactory {
    public Sender getSender() {
        return new SmsSenderImpl();
    }
}
