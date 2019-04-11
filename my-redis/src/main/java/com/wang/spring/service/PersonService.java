package com.wang.spring.service;

import com.wang.spring.dao.PersonRepository;
import com.wang.spring.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2019-04-10 16:43  by  王帅（wangshuai@cloud-young.com）创建
 */
public interface PersonService {
    public void save(Person rand);

    public void findById(String id);

    public long count();

    public void delete(Person person);
}
