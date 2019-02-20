package com.wang.my.decorator.example2;

/**
 * Description:装饰者类
 * All Rights Reserved.
 *
 * @version 1.0  2019-02-19 17:05  by  王帅（wangshuai@cloud-young.com）创建
 */
public  class Decorator implements Component {
    protected Component component;

    public Decorator(Component component) {

        this.component = component;
    }
    public void biu() {
        System.out.println("ready?go!");//具体的装饰行为
        this.component.biu();
    }
}
