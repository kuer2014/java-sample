package com.wang.my.factory.abstracttest;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/25 19:05  by  王帅（wangshuai@cloud-young.com）创建
 */
public class ConcreteFactory1 extends AbstractFactory {
    public AbstractProductA createProductA() {
       return new ProductA1();
    }

    public AbstractProductB createProductB() {
        return new ProductB1();
    }
}
