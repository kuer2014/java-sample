package com.wang.spring;

import com.wang.spring.config.RedisConfig;
import com.wang.spring.model.Person;
import com.wang.spring.service.PersonService;
import com.wang.spring.service.impl.PersonServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Description:配置类方式 使用
 * All Rights Reserved.
 * 演示 JedisConnection+ RedisRepositories 操作Redis数据
 * @version 1.0  2019-04-10 16:50  by  王帅（wangshuai@cloud-young.com）创建
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RedisConfig.class) //配置类方式
public class RepositoryConfigTest {
    @Autowired
    private PersonService personService;

    @Test
    public void saveTest() {
        Person person = new Person("wang", "shuai");
        //  rand.setAddress(new Address("emond's field", "andor"));
        personService.save(person);
        Person person2 = new Person("aa", "bb");
        //  rand.setAddress(new Address("emond's field", "andor"));
        personService.save(person2);
    }
    @Test
    public void countTest() {
        long cnt =  personService.count();
        System.out.println("cnt="+cnt);
    }
}
