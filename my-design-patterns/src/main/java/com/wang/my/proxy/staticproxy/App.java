package com.wang.my.proxy.staticproxy;

/**
 * Description:代理模式-静态代理模式
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/27 17:38  by  王帅（wangshuai@cloud-young.com）创建
 */
public class App {
    public static void main(String[] args) {
        //不用代理
        Deal houseOwner=new HouseOwner();
        houseOwner.sell();
        //使用代理，隐藏了房主类。
        Deal houseProxy = new HouseProxy();
        houseProxy.sell();
    }
}
