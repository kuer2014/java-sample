package com.wang.controller.validtest;

import com.wang.model.Car;
import com.wang.model.CarPO;
import com.wang.model.CarValidator;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018-12-03 17:04  by  王帅（wangshuai@cloud-young.com）创建
 */
@RestController
@RequestMapping("/valid1")
public class InitBinderTestController {

    ///验证方式一：通过spring的 InitBinder注解
    //绑定CarValidator
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(new CarValidator());
    }
    //使用演示
    //get /valid1/get?id=21&name=fff
    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public String get(@Valid Car car, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "错误："+ bindingResult.getAllErrors().get(0).getDefaultMessage();
        else
            return car.getName();
    }
}
