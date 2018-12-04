package com.wang.model;


/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/3/6 下午8:20  by  王帅（wangshuai@cloud-young.com）创建
 */
public class CalculateModel {
    private Integer x;

    public CalculateModel(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    private Integer y;


    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }
    public String getStr(){
        return "";
    }
}
