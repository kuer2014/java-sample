package com.wang.spring.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2019-04-10 16:39  by  王帅（wangshuai@cloud-young.com）创建
 */
@RedisHash("people")
public class Person {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    @Id
    String id="1";
    String firstname;
    String lastname;
    private static int nextId=0;
    public Person(String firstname, String lastname) {
        nextId++;
        id=String.valueOf(nextId);
        this.firstname = firstname;
        this.lastname = lastname;
    }
    //Address address;
}