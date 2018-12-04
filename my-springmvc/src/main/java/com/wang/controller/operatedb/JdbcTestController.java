package com.wang.controller.operatedb;

import com.wang.repository.JdbcTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/8/18 16:46  by  王帅（wangshuai@cloud-young.com）创建
 */
@Controller
@RequestMapping("db")
public class JdbcTestController {
    @Autowired
    private JdbcTemplateRepository jdbcTemplateRepository;

    @RequestMapping("read")
    @ResponseBody
    public String readDb(@RequestParam Integer userId){
        return jdbcTemplateRepository.getUsername(userId);
    }
}
