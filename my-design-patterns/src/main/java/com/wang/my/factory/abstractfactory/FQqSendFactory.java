package com.wang.my.factory.abstractfactory;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/25 16:45  by  王帅（wangshuai@cloud-young.com）创建
 */
public class FQqSendFactory extends AbstractSendFactory{

    public AbstractMailSender getMailSender() {
        return new _QqMailSender();
    }

    public AbstractSmsSender getSmsSender() {
        return new _QqSmsSender();
    }
}
