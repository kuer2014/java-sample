package com.wang.my.decorator.example1;

/**
 * Description:具体实现类
 * 尽量保持具体构件类Component作为一个“轻”类，也就是说不要把太多的逻辑和状态放在具体构件类中，可以通过装饰类对其进行扩展。
 * All Rights Reserved.
 *
 * @version 1.0  2019-02-19 17:04  by  王帅（wangshuai@cloud-young.com）创建
 */
public class ConcretComponent implements Component {
    public void biu() {
        System.out.println("biubiubiu");
    }
}
