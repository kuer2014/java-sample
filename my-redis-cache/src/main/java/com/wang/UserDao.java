package com.wang;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/4 20:30  by  王帅（wangshuai@cloud-young.com）创建
 */
@Repository
public class UserDao {
    private HashMap<Integer, User> userMap;

    //@PostConstruct
    public void init() {
        //模拟数据库
        userMap = new HashMap<Integer, User>();
        userMap.put(1, new User(1,"Zhang"));
        userMap.put(2, new User(2,"Wang"));
    }

    @Cacheable("u")
    //参数id=1时，生成对应redis中数据：key= "u::1";value="[\"com.wang.User\",{\"id\":1,\"username\":\"Zhang\"}]"
    public User get(Integer id) {
        init();
        return userMap.get(id);
    }
    @Cacheable(value = "uid",key="#id",condition = "#id==1")
    //参数id=1时，生成对应redis中数据：key= "uid::1";value="[\"com.wang.User\",{\"id\":1,\"username\":\"Zhang\"}]"
    public User get1(Integer id) {
        init();
        return userMap.get(id);
    }
    @Cacheable(value = "userOutTime",keyGenerator = "simpleKeyGenerator", unless = "#result==null")
    //参数id=1时，生成对应redis中数据：key="userOutTime::UserDao.getUser[1]";  value="[\"com.wang.User\",{\"id\":1,\"username\":\"Zhang\"}]"
   //condition 与 unless 的使用：
    //condition 为false ,禁用缓存，不存也不查
    //unless 为true ,不存
    public User getUser(Integer id) {
        init();
        return userMap.get(id);
    }
    @CacheEvict("u")
    //@CacheEvict(value = "u",key="",condition = "", allEntries = false,beforeInvocation = false)
    ///allEntries：是否清空所有缓存内容，缺省为 false
    ///beforeInvocation：是否在方法执行前就清空，缺省为 false，

    public void del(Integer id) {

    }
    @CachePut(value = "u",key="#ur.id") //CachePut 是每次都会调用方法并且把返回值放到缓存
    public User save(User ur ) {
        userMap = new HashMap<Integer, User>();
        userMap.put(ur.getId(),ur);
        return ur;
    }
}
