package com.wang;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/8/31 13:16  by  王帅（wangshuai@cloud-young.com）创建
 */
public class JedisApp {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.auth("111");
        jedis.set("foo", "bar");
        jedis.lpush("jedis", "j", "e", "d");
        String value = jedis.get("foo");
        System.out.println(value);
        //集群
        Set<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("localhost", 7001));
        nodes.add(new HostAndPort("localhost", 7002));
        nodes.add(new HostAndPort("localhost", 7003));
        nodes.add(new HostAndPort("localhost", 7004));
        nodes.add(new HostAndPort("localhost", 7005));
        nodes.add(new HostAndPort("localhost", 7006));
        JedisCluster jedisCluster = new JedisCluster(nodes);
        // 直接使用JedisCluster对象操作redis。
        jedisCluster.set("test", "123");
        String string = jedisCluster.get("test");
        System.out.println(string);
        try {
            jedisCluster.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
