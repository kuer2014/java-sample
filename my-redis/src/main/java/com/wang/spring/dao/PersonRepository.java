package com.wang.spring.dao;

import com.wang.spring.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2019-04-10 16:41  by  王帅（wangshuai@cloud-young.com）创建
 */

public interface PersonRepository extends CrudRepository<Person, String> {

}
