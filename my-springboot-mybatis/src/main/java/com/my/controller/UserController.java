package com.my.controller;

import com.my.service.UserService;
import com.my.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/6 19:34  by  王帅（wangshuai@cloud-young.com）创建
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService service;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public boolean add(@RequestBody User user) {
        return service.add(user);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public User get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> list() {
        return service.list();
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "true";
    }
    /**
     * @Descpription:存储过程调用测试
     * @version 1.0  2018/10/8 18:22   by  王帅（wangshuai@cloud-young.com）创建
     * @param
     * @return
     */
    @RequestMapping(value = "/getemail/{name}", method = RequestMethod.GET)
    public String get(@PathVariable("name") String name) {
        Map<String, Object> params =new HashMap<>();
        params.put("name",name);
         service.findEmailByName(params);
         return params.get("email")+"";
    }

}
