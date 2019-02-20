package com.wang.my.decorator.example1;

/**
 * Description: 标准的装饰器模式
 * 参考：装饰器模式(Decorator)——深入理解与实战应用 https://www.cnblogs.com/jzb-blog/p/6717349.html
 * All Rights Reserved.
 *
 * @version 1.0  2019-02-19 17:09  by  王帅（wangshuai@cloud-young.com）创建
 */
public class App {
    public static void main(String[] args) {
        //使用装饰器
        Component component = new ConcreteDecorator(new ConcretComponent());
        component.biu();
    }
}
