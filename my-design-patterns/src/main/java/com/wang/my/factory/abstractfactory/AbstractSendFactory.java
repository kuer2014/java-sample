package com.wang.my.factory.abstractfactory;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/25 16:50  by  王帅（wangshuai@cloud-young.com）创建
 */
public abstract class AbstractSendFactory {
    public abstract AbstractMailSender getMailSender();
    public abstract AbstractSmsSender getSmsSender();
}
