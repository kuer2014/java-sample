package com.my.model;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/10/9 10:34  by  王帅（wangshuai@cloud-young.com）创建
 */
public class Teacher {
    //定义实体类的属性，与teacher表中的字段对应
    private int id;            //id===>t_id
    private String name;    //name===>t_name
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
