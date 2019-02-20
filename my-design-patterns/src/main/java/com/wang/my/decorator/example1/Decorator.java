package com.wang.my.decorator.example1;

/**
 * Description:装饰者类
 * 装饰者类的接口必须与被装饰类的接口保持相同，对于客户端来说无论是装饰之前的对象还是装饰之后的对象都可以一致对待。
 * All Rights Reserved.
 *
 * @version 1.0  2019-02-19 17:05  by  王帅（wangshuai@cloud-young.com）创建
 */
public abstract class Decorator implements Component {
    protected Component component;
    public Decorator(Component component) {
        this.component = component;
    }
    //可有可无，
    // 没有该方法时具体装饰类直接调用具体被装饰类；
    // 有该方法时，可以在多个具体装饰类中拥有共同的装饰行为。
//    public void biu() {
//        this.component.biu();
//    }
}
