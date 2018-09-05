package com.wang;

import redis.clients.jedis.Jedis;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/8/31 13:16  by  王帅（wangshuai@cloud-young.com）创建
 */
public class JedisApp {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost",6379);
        jedis.auth("111");
        jedis.set("foo", "bar");
        jedis.lpush("jedis","j","e","d");
        String value = jedis.get("foo");
        System.out.println(value);
    }
}
