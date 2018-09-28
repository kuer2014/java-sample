package com.wang.my.observer;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/28 15:58  by  王帅（wangshuai@cloud-young.com）创建
 */
public class StudentBImpl implements Student {
    private String name;
    public StudentBImpl(String name) {
        this.name = name;
    }
    public void receiveNotice(String msg) {
        doWork(msg);
    }
    private void doWork(String work){
        System.out.println(this.name+"写作业："+work);
    }
}
