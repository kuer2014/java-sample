package com.wang.exceptiontest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/8/15 18:49  by  王帅（wangshuai@cloud-young.com）创建
 */
@Controller
@RequestMapping("ex1")
public class Ex2Controller {
    @RequestMapping("a2")
    @ResponseBody
    public String action1( String str){
        str.length();
        return "ok";
    }
}
