package com.my.service;

import com.my.model.Classes;

import java.util.List;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/10/9 10:43  by  王帅（wangshuai@cloud-young.com）创建
 */
public interface ClassesService {
    List<Classes> list();
    Classes findById(int id);
    List<Classes> getClass3();//一对多
    Classes getClass4(int id);//一对多
}
