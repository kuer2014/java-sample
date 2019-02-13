package com.wang.my.factory.abstractdemo2;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2019-02-13 11:07  by  王帅（wangshuai@cloud-young.com）创建
 */
public class BenzFactory extends AutoFactory {
    public Car getCar() {
        return new BenzCar();
    }

    public Suv getSuv() {
        return new BenzSuv();
    }
}
