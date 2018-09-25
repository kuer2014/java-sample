package com.wang.my.factory.abstractfactory;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/25 16:45  by  王帅（wangshuai@cloud-young.com）创建
 */
public class SmsSendFactory {
    public SmsSender getQqSmsSender() {
        return new _QqSmsSenderImpl();
    }
    public SmsSender getWxSmsSender() {
        return new _WxSmsSenderImpl();
    }
}
