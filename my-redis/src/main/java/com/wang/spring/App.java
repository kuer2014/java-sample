package com.wang.spring;

import org.redisson.api.RBucket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2019-04-09 16:41  by  王帅（wangshuai@cloud-young.com）创建
 */
public class App {
    @Autowired
    private static RedisTemplate<String, String> redisTemplate;

   // @Resource(name="redisTemplate")
   // private static ListOperations<String, String> listOps;
    public static void main(String[] args) {
      //  listOps.leftPush(userId, url.toExternalForm());
        // or use template directly


    }
}
