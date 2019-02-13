package com.wang.my.factory.abstractdemo2;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2019-02-13 11:54  by  王帅（wangshuai@cloud-young.com）创建
 */
public class App {
    public static void main(String[] args) {
        AutoFactory audiFactory = new AudiFactory();
        audiFactory.getCar().run();
        audiFactory.getSuv().run();
        AutoFactory benzFactory = new BenzFactory();
        benzFactory.getCar().run();
        benzFactory.getSuv().run();
    }
}
