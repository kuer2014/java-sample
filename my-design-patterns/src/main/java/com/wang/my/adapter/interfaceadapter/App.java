package com.wang.my.adapter.interfaceadapter;

/**
 * Description:适配器模式 - 接口适配器模式
 * 适配器屏蔽掉无关的接口方法
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/27 14:15  by  王帅（wangshuai@cloud-young.com）创建
 */
public class App {
    public static void main(String[] args) {
        Usb usb = new Usb();
        usb.usb1();
        usb.usb2();

    }
}
