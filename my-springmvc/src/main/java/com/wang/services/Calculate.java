package com.wang.services;

import org.springframework.stereotype.Component;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/3/6 下午8:14  by  王帅（wangshuai@cloud-young.com）创建
 */
@Component
public class Calculate {

    public Integer add(Integer x,Integer y){
        return x+y+1;
    }
}
