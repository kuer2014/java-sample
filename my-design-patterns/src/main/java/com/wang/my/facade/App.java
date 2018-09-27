package com.wang.my.facade;

/**
 * Description:外观模式
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/27 16:31  by  王帅（wangshuai@cloud-young.com）创建
 */
public class App {
    public static void main(String[] args) {
        ComputerFactory computerFactory = new ComputerFactory();
        computerFactory.makeComputer();
    }
}
