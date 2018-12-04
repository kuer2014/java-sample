package com.wang.exceptiontest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/8/15 18:12  by  王帅（wangshuai@cloud-young.com）创建
 */
@Controller
@RequestMapping("ex1")
public class Ex1Controller {

    @RequestMapping("a1")
    @ResponseBody
    public String action1( String str){
   str.length();
   return "ok";
    }

//    @ExceptionHandler(NullPointerException.class)
//    @ResponseBody
//    String errHandler(){
//        //可捕获该控制器下所有方法抛出的NullPointerException错误
          //要捕获所有控制器下的NullPointerException错误 可使用通知（@ControllerAdvice注解）
//        System.out.println("error msg");
//        return "err";
//    }
}
