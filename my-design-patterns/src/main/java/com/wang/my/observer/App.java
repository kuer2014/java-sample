package com.wang.my.observer;

/**
 * Description:观察者模式
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/28 16:24  by  王帅（wangshuai@cloud-young.com）创建
 */
public class App {
    public static void main(String[] args) {
        Student a=new StudentAImpl("A-小刚");
        Student b=new StudentBImpl("B-小明");
        Student c=new StudentCImpl("C-小红");
        Teacher teacher = new TeacherImpl("王老师");
        teacher.addStudent(a);
        teacher.addStudent(b);
        teacher.addStudent(c);
        teacher.createWork("语文");
        teacher.removeStudent(a);
        teacher.createWork("数学");


    }
}
