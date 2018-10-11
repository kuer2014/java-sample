package com.wang.services;

import com.wang.model.User;

import java.util.List;
import java.util.Map;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/6 19:31  by  王帅（wangshuai@cloud-young.com）创建
 */
public interface UserService {
    boolean add(User user);
    boolean add1(User user);
    boolean add2(User user);
    User  get(Long id);
    List<User> list();
}
