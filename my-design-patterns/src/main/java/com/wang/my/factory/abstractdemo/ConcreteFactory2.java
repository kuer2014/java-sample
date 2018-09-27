package com.wang.my.factory.abstractdemo;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/25 19:06  by  王帅（wangshuai@cloud-young.com）创建
 */
public class ConcreteFactory2 extends AbstractFactory {
    public AbstractProductA createProductA() {
     return new ProductA2();
    }

    public AbstractProductB createProductB() {
        return new ProductB2();
    }
}
