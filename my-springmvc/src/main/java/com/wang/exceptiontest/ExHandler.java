package com.wang.exceptiontest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/8/15 18:50  by  王帅（wangshuai@cloud-young.com）创建
 */
@ControllerAdvice
public class ExHandler {
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    String errHandler(){
        //可捕获所有控制器下所有方法抛出的NullPointerException错误
        System.out.println("error msg");
        return "err";
    }
}
