package com.my.service;

import com.my.model.User;

import java.util.List;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/6 19:31  by  王帅（wangshuai@cloud-young.com）创建
 */
public interface UserService {
    boolean add(User user);
    User  get(Long id);
    List<User> list();
}
