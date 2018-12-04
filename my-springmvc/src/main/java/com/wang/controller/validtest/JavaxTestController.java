package com.wang.controller.validtest;

import com.wang.model.Car;
import com.wang.model.CarPO;
import com.wang.model.CarValidator;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018-12-03 17:04  by  王帅（wangshuai@cloud-young.com）创建
 */
@RestController
@RequestMapping("/valid2")
public class JavaxTestController {

    ///验证方式二：通过javax.validation.constraints包中的注解
    //get /valid2/get?id=21&name=fff
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String get(@Valid CarPO po, Errors errors) {
        if (errors.hasErrors()) {
           // return errors.getObjectName(); //output:CarPO
             return "错误:"+errors.getAllErrors().get(0).getDefaultMessage();//output:name不能为空/请检查name长度
        }
        return "po.name:" + po.getName();
    }

}
