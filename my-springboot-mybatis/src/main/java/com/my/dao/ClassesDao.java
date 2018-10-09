package com.my.dao;

import com.my.model.Classes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/10/9 10:41  by  王帅（wangshuai@cloud-young.com）创建
 */
@Mapper
public interface ClassesDao {
    List<Classes> findAll();
   Classes findById(int id);
    List<Classes> getClass3();//一对多
    Classes getClass4(int id);//一对多
}
