package com.wang.services.impl;

import com.wang.dao.UserDao;
import com.wang.model.User;
import com.wang.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/6 19:33  by  王帅（wangshuai@cloud-young.com）创建
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao dao;

    @Override
    public boolean add(User user) {
        dao.addUser(user);
        return true;
    }
    @Override
    public boolean add1(User user) {
        dao.addUser(user);
         int x =2/0;
        return true;
    }
     @Transactional(isolation = Isolation.READ_COMMITTED)
    @Override
    public boolean add2(User user) {
        dao.addUser(user);
         int x =2/0;
        return true;
    }
    @Override
    public User get(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<User> list() {
        return dao.findAll();
    }
   }
