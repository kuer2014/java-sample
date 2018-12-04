package com.wang.security;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/8/17 17:40  by  王帅（wangshuai@cloud-young.com）创建
 */
public class BasicTest {
@Test
    public void pwdEncode(){
        //进行加密
        BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
        String epwd = encoder.encode("123");
        System.out.println(epwd);//out:$2a$10$Qz0ePWoFy8YmLTxR7njXFOWsZh2vYyZ6EDwpJtzazIiKrDdfFZbhG
    System.out.println(encoder.matches("123","$2a$10$Qz0ePWoFy8YmLTxR7njXFOWsZh2vYyZ6EDwpJtzazIiKrDdfFZbhG"));
    }
}
