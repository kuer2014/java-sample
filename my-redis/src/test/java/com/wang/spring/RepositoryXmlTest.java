package com.wang.spring;

import com.wang.spring.model.Person;
import com.wang.spring.service.impl.PersonServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Description: XML方式 使用
 * All Rights Reserved.
 * 演示 JedisConnection+ RedisRepositories 操作Redis数据
 * @version 1.0  2019-04-10 16:50  by  王帅（wangshuai@cloud-young.com）创建
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:redis-context.xml") //XML方式
public class RepositoryXmlTest {
    @Autowired
    private PersonServiceImpl personService;

    @Test
    public void saveTest() {
        Person person = new Person("rand", "al'thor");
        //  rand.setAddress(new Address("emond's field", "andor"));
        personService.save(person);
    }
    @Test
    public void countTest() {
      long cnt =  personService.count();
        System.out.println("cnt="+cnt);
    }
}
