package com.my.controller;

import com.my.service.UserService;
import com.my.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

}
