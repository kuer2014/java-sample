package com.wang;

import com.wang.config.RedisCacheConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/4 20:15  by  王帅（wangshuai@cloud-young.com）创建
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RedisCacheConfig.class)
//@EnableCaching
public class UserTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void get() {
        User u = userDao.get(3);
        System.out.println(u.getUsername());
    }
    @Test
    public void get1() {
        User u = userDao.get1(1);
        System.out.println(u.getUsername());
    }
    /**
     * @param
     * @return
     * @Descpription:指定key的过期时间；自定义key生成策略
     * @version 1.0  2018/9/5 12:22   by  王帅（wangshuai@cloud-young.com）创建
     */
    @Test
    public void get2() {
        User u = userDao.getUser(11);
        System.out.println(u.getUsername());
    }
    @Test
    public void del(){
        userDao.del(1);
    }
@Test
    public void save(){
      User ur=  new User(3,"Wang");
      userDao.save(ur);
    }

}
