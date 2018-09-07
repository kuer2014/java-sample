package com.my.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/6 19:28  by  王帅（wangshuai@cloud-young.com）创建
 */
@Data
public class User implements Serializable {
    private Long id;
    private String user_name;
    private String pass_word;
    private String email;
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getUser_name() {
//        return user_name;
//    }
//
//    public void setUser_name(String user_name) {
//        this.user_name = user_name;
//    }
//
//    public String getPass_word() {
//        return pass_word;
//    }
//
//    public void setPass_word(String pass_word) {
//        this.pass_word = pass_word;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
}
