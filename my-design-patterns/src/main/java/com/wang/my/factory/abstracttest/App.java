package com.wang.my.factory.abstracttest;

/**
 * Description:
 * All Rights Reserved.
 *  参考：https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/abstract_factory.html#
 * @version 1.0  2018/9/25 19:11  by  王帅（wangshuai@cloud-young.com）创建
 */
public class App {
    public static void main(String[] args) {
        AbstractFactory abstractFactory1 =new ConcreteFactory1();
        AbstractProductA productA1=abstractFactory1.createProductA();
        AbstractProductB productB1=abstractFactory1.createProductB();
        productA1.use();
        productB1.eat();

        AbstractFactory abstractFactory2 =new ConcreteFactory2();
        AbstractProductA productA2=abstractFactory2.createProductA();
        AbstractProductB productB2=abstractFactory2.createProductB();
        productA2.use();
        productB2.eat();
    }
}
