package com.wang.my.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/28 15:55  by  王帅（wangshuai@cloud-young.com）创建
 */
public class TeacherImpl implements Teacher {
    private List<Student> students;
    private String name;

    public TeacherImpl(String name) {
        this.name = name;
        this.students = new ArrayList();
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void removeStudent(Student student) {
        this.students.remove(student);
    }

    public void createWork(String work) {
        System.out.println(this.name+"布置作业:"+work);
        sendNotice(work);
    }

    public void sendNotice(String msg) {
        for (Student student : students
                ) {
            student.receiveNotice(msg);
        }
    }
}
