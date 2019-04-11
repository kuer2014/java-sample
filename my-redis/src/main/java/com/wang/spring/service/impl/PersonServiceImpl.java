package com.wang.spring.service.impl;

import com.wang.spring.dao.PersonRepository;
import com.wang.spring.model.Person;
import com.wang.spring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2019-04-10 16:43  by  王帅（wangshuai@cloud-young.com）创建
 */
@Service("personService")
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonRepository personRepository;

    public void save(Person rand) {
        personRepository.save(rand);
    }

    public void findById(String id) {
        personRepository.findById(id);
    }

    public long count() {
        return personRepository.count();
    }

    public void delete(Person person) {
        personRepository.delete(person);
    }
}
