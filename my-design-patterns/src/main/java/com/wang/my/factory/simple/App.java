package com.wang.my.factory.simple;

/**
 * Description:简单工厂模式-多个静态方法
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/25 14:57  by  王帅（wangshuai@cloud-young.com）创建
 */
public class App {
    public static void main(String[] args) {
        SendFactory.getMailSender().send();
        SendFactory.getSmsSender().send();
    }
}
