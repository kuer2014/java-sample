package com.wang.my.adapter.classadapter;

/**
 * Description:适配器模式 - 类适配器模式
 * 已有USB类，增加适配器类，从而可兼容Type-C类
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/27 13:20  by  王帅（wangshuai@cloud-young.com）创建
 */
public class App {
    public static void main(String[] args) {
        TypeC typeC = new Adapter();
        typeC.typeC();
    }
}
