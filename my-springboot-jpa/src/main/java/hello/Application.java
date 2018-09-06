package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.*;

import java.util.List;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/8/22 12:15  by  王帅（wangshuai@cloud-young.com）创建
 */
@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    //@Order(1) //多个CommandLineRunner方法时控制执行顺序
    @Bean
    public CommandLineRunner demo(UserRepository repository) {
        return (args) -> {

            // save a couple of User
            //repository.save(new User("ww123","ww@163.com","pwd"));
          //保存或更新
            User u =new User("ww123","ww@163.com","pwd");
            u.setId(3);//id为3不在数据库中添加。如果在数据库中则是更新
           // u.setId(0);//id为0时添加
            repository.save(u);
            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");

            log.info("");

            // fetch an individual customer by ID
            repository.findById(1)
                    .ifPresent(user -> {
                        log.info("Customer found with findById(1):");
                        log.info("--------------------------------");
                        log.info(user.getUser_name() + ":id=" + user.getId());
                        log.info("");
                    });
            Iterable<User> userList = repository.findAll();
            userList.forEach(user -> {
                log.info(user.getUser_name());
            });
//            log.info("--------------------------------");
//            log.info("---------------使用example查询--------------");
//            User param=new User();
//            param.setUser_name("ww");
//            Example<User> example= Example.of(param);
//                List<User> l= repository.findAll();
//                l.forEach(u->{log.info(u.getUser_name());});
            log.info("--------------------------------");
            log.info("---------------使用自定义查询--------------");
            List<User> list = repository.findByEmail("ww");
            list.forEach(user -> {
                log.info(user.getUser_name()+ ":id=" + user.getId());
            });
            log.info("---------------使用分页查询--------------");
            /* 需求：查询第2页的数据,每页3条 */
            int page = 2 - 1;   //由于springdata默认的page是从0开始，所以减1
            int size = 3;
            Pageable pageable = PageRequest.of(page,size, Sort.Direction.ASC,"username");
            //Pageable pageable = PageRequest.of(2,3, Sort.by(Sort.Direction.DESC,"username"));
            Page<User> userPage= repository.findAll(pageable);
            userPage.forEach(p->{
                log.info(p.getUser_name()+ ":id=" + p.getId());
            });
        };
    }
//    @Bean
//    public CommandLineRunner demo(CustomerRepository repository) {
//        return (args) -> {
//
//            // save a couple of customers
//            repository.save(new Customer("Jack", "Bauer"));
//            repository.save(new Customer("Chloe", "O'Brian"));
//            repository.save(new Customer("Kim", "Bauer"));
//            repository.save(new Customer("David", "Palmer"));
//            repository.save(new Customer("Michelle", "Dessler"));
//
//            // fetch all customers
//            log.info("Customers found with findAll():");
//            log.info("-------------------------------");
//            for (Customer customer : repository.findAll()) {
//                log.info(customer.toString());
//            }
//            log.info("");
//
//            // fetch an individual customer by ID
//            repository.findById(1L)
//                    .ifPresent(customer -> {
//                        log.info("Customer found with findById(1L):");
//                        log.info("--------------------------------");
//                        log.info(customer.toString());
//                        log.info("");
//                    });
//
//            // fetch customers by last name
//            log.info("Customer found with findByLastName('Bauer'):");
//            log.info("--------------------------------------------");
//            repository.findByLastName("Bauer").forEach(bauer -> {
//                log.info(bauer.toString());
//            });
//            // for (Customer bauer : repository.findByLastName("Bauer")) {
//            // 	log.info(bauer.toString());
//            // }
//            log.info("");
//        };
//    }

}
