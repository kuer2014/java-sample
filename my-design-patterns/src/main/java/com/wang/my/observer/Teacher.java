package com.wang.my.observer;

/**
 * Description:被观察者
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/28 15:51  by  王帅（wangshuai@cloud-young.com）创建
 */
public interface Teacher {
    void addStudent(Student student);
    void removeStudent(Student student);
    void createWork(String work);
    void sendNotice(String msg);
}
