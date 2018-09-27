package com.wang.my.proxy.dynamicproxy;

/**
 * Description:代理模式-动态代理模式
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/27 18:12  by  王帅（wangshuai@cloud-young.com）创建
 */
public class App {
    public static void main(String[] args) {
        // 被代理对象
        Deal target = new HouseOwner();
        System.out.println(target.getClass());//class com.wang.my.proxy.dynamicproxy.HouseOwner
        // 代理对象
        Deal proxy = (Deal) new ProxyFactory(target).getProxyInstance();
        System.out.println(proxy.getClass());//class com.sun.proxy.$Proxy0
        // 执行方法
        proxy.sell();
    }
}
