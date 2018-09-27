package com.wang.my.proxy.staticproxy;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/27 17:51  by  王帅（wangshuai@cloud-young.com）创建
 */
public class HouseProxy implements Deal {
    private HouseOwner houseOwner;

    public HouseProxy() {
        this.houseOwner = new HouseOwner();
    }

    public void sell() {
        this.houseOwner.sell();
    }
}
