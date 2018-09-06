package hello;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/8/22 13:27  by  王帅（wangshuai@cloud-young.com）创建
 */
//public interface UserRepository extends CrudRepository<User,Integer> {
public interface UserRepository extends JpaRepository<User,Integer> {
 List<User> findByEmail(String email);
}
