package com.wang.my.prototype;

/**
 * Description:原型模式
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/26 19:57  by  王帅（wangshuai@cloud-young.com）创建
 */
public class App {
    public static void main(String[] args) {
        Car car = new Car();
        car.setName("qq");
        Car car2 = car.clone();
        System.out.println("car1:"+car.hashCode());
        System.out.println("car2:"+car2.hashCode());
        car2.setName("bmw");
        System.out.println("car1:"+car.getName());
        System.out.println("car2:"+car2.getName());

        Car car3 = car.copy();
        System.out.println("car3:"+car3.getName());
    }
}
