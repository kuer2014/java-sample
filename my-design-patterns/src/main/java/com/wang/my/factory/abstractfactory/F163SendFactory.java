package com.wang.my.factory.abstractfactory;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/25 16:39  by  王帅（wangshuai@cloud-young.com）创建
 */
public class F163SendFactory extends AbstractSendFactory  {

    public AbstractMailSender getMailSender() {
        return new _163MailSender();
    }

    public AbstractSmsSender getSmsSender() {
        return new _YxSmsSender();
    }
}
