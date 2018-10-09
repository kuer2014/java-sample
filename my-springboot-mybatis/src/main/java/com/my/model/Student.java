package com.my.model;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/10/9 11:49  by  王帅（wangshuai@cloud-young.com）创建
 */
public class Student {
    //定义属性，和student表中的字段对应
     private int id;            //id===>s_id
    private String name;    //name===>s_name

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
