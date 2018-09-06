package hello;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/8/22 12:14  by  王帅（wangshuai@cloud-young.com）创建
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}
