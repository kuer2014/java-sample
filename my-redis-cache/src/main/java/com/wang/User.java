package com.wang;

import java.io.Serializable;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/4 20:31  by  王帅（wangshuai@cloud-young.com）创建
 */
public class User implements Serializable {
    private Integer id;
    private String username;

    public User(Integer id, String username) {
        this.username = username;
        this.id = id;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
