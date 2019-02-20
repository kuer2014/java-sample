package com.wang.my.decorator.example1;

/**
 * Description:具体装饰类
 * All Rights Reserved.
 *
 * @version 1.0  2019-02-19 17:06  by  王帅（wangshuai@cloud-young.com）创建
 */
public class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component component) {
        super(component);
    }
    public void biu() {
        System.out.println("ready?go!");//具体的装饰行为
        this.component.biu();
    }
}
