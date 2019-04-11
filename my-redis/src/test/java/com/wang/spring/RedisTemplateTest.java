package com.wang.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Set;
import java.util.concurrent.TimeUnit;


/**
 * Description:spring 的 RedisTemplate 使用
 * All Rights Reserved.
 * RedisTemplate 会把key和value先序列化为
 *
 * @version 1.0  2019-04-09 17:44  by  王帅（wangshuai@cloud-young.com）创建
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:redis-context.xml")
public class RedisTemplateTest {
    // 直接使用RedisTemplate类操作
    @Autowired
    private RedisTemplate<String, String> template;

    // 或者使用 Operations 类
     @Resource(name = "redisTemplate")
    private ListOperations<String, String> listOps;
    @Resource(name = "redisTemplate")
    private SetOperations<String, String> setOps;
    @Test
    public void templateTest() {

        template.opsForSet().add("RedisTemplateKey1", "v211");//value("v211")存在时不添加
        template.opsForSet().getOperations().expire("RedisTemplateKey1", 100, TimeUnit.SECONDS);//设置10秒有效期
        System.out.println("ok21");
        Set<String> setKeys = template.opsForSet().members("RedisTemplateKey1");
        String v212 = setKeys.iterator().next();
        //String v21= template.opsForSet().pop("RedisTemplateKey"); //返回并删除
        System.out.println("RedisTemplateKey1=" + v212);
        setKeys.forEach(s -> System.out.println(s));
    }

    @Test
    public void operationsTest() {
        listOps.leftPush("listkey", "v3");
        System.out.println("ok3");

        setOps.add("setkey", "v4");
        System.out.println("ok4");
    }
}
