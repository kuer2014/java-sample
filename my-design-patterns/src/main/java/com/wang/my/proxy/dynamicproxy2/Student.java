package com.wang.my.proxy.dynamicproxy2;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/11/20 11:09  by  王帅（wangshuai@cloud-young.com）创建
 */
public class Student implements Person {
    private String name;
    public Student(String name) {
        this.name = name;
    }

   // @Override
    public void giveMoney() {
        try {
            //假设数钱花了一秒时间
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + "上交班费50元");
    }
}
