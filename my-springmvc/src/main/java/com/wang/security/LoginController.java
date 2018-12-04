package com.wang.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/8/16 20:01  by  王帅（wangshuai@cloud-young.com）创建
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public String loginPage() {
        return "loginPage";
    }

}
