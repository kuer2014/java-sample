package com.my.controller;

import com.my.model.Classes;
import com.my.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description: mybatis 多表关联查询测试
 * All Rights Reserved.
 *
 * @version 1.0  2018/10/9 11:38  by  王帅（wangshuai@cloud-young.com）创建
 */
@RestController
@RequestMapping("class")
public class ClassController {
    @Autowired
    private ClassesService classesService;
    /**
     * @Descpription: mybatis中一对一关联查询测试
     * @version 1.0  2018/10/9 10:50   by  王帅（wangshuai@cloud-young.com）创建
     * @param
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Classes> getClassesList() {
        return classesService.list();
    }
    /**
     * @Descpription:mybatis中一对一关联方式2 查询测试
     * @version 1.0  2018/10/9 12:00   by  王帅（wangshuai@cloud-young.com）创建
     * @param
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Classes getClass(@PathVariable("id")  int id) {
        return classesService.findById(id);
    }
    /**
     * @Descpription:mybatis中一对多关联查询测试
     * @version 1.0  2018/10/9 12:02   by  王帅（wangshuai@cloud-young.com）创建
     * @param
     * @return
     */
    @RequestMapping(value = "/getClass3", method = RequestMethod.GET)
    public List<Classes> getClass3() {
        return classesService.getClass3();
    }
    /**
     * @Descpription:mybatis中一对多关联方式2 查询测试
     * @version 1.0  2018/10/9 12:02   by  王帅（wangshuai@cloud-young.com）创建
     * @param
     * @return
     */
    @RequestMapping(value = "/getClass4/{id}", method = RequestMethod.GET)
    public Classes getClass4(@PathVariable("id")  int id) {
        return classesService.getClass4(id);
    }
}
