package com.my.service.impl;

import com.my.dao.ClassesDao;
import com.my.model.Classes;
import com.my.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/10/9 10:44  by  王帅（wangshuai@cloud-young.com）创建
 */
@Service
public class ClassesServiceImpl implements ClassesService {
    @Autowired
    private ClassesDao dao;
    @Override
    public List<Classes> list() {
        return dao.findAll() ;
    }

    @Override
    public Classes findById(int id) {
        return dao.findById( id);
    }

    @Override
    public List<Classes> getClass3() {
        return dao.getClass3();
    }

    @Override
    public Classes getClass4(int id) {
        return dao.getClass4(id);
    }
}
