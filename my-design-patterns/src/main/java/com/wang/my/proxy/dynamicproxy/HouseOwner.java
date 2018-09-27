package com.wang.my.proxy.dynamicproxy;


/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/27 17:47  by  王帅（wangshuai@cloud-young.com）创建
 */
public class HouseOwner implements Deal {

    public void sell() {
        System.out.println("房东卖房");
    }
}
