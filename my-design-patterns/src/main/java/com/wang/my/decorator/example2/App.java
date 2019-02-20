package com.wang.my.decorator.example2;

/**
 * Description:装饰器模式简化版，直接使用装饰器类装饰
 * All Rights Reserved.
 *
 * @version 1.0  2019-02-19 17:09  by  王帅（wangshuai@cloud-young.com）创建
 */
public class App {
    public static void main(String[] args) {
        //使用装饰器
        Component component = new Decorator(new ConcretComponent());
        component.biu();
    }
}
