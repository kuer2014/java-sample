package com.wang.my.prototype;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/26 19:51  by  王帅（wangshuai@cloud-young.com）创建
 */
public class Car implements Cloneable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Car clone() {
        Car o = null;
        try {
            o = (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
    }
    protected Car copy() {
        Car o = null;
        try {
            o = (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
    }
}
