package com.wang;

import com.wang.model.User;
import com.wang.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MySpringTransactionApplicationTests {
    @Autowired
    private UserService service;
    @Resource
    private TransactionTemplate transactionTemplate;

    @Test
    public void get() {
        User u = service.get(1L);
        System.out.println(u.getUser_name());
    }

    /**
     * @param
     * @return
     * @Descpription:编程式事务管理测试 编程式事务管理可以通过PlatformTransactionManager实现来进行事务管理，
     * Spring为我们提供了模板类TransactionTemplate进行事务管理
     * @version 1.0  2018/10/10 18:23   by  王帅（wangshuai@cloud-young.com）创建
     */
    @Test
    public void transactionTemplateTest() {
        User user = new User();
        user.setUser_name("e123");
        user.setPass_word("111");
        user.setEmail("abc@ddd.com");
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    service.add(user);
                    int i = 1 / 0;
                } catch (Exception e) {
                    //对于抛出Exception类型的异常且需要回滚时,需要捕获异常并通过调用status对象的setRollbackOnly()方法告知事务管理器当前事务需要回滚
                    transactionStatus.setRollbackOnly();
                    e.printStackTrace();
                }
            }
        });
    }
/**
 * @Descpription: 声明式事务管理 方式1 基于tx和aop命名空间的xml配置文件
 *  测试未成功
 * @version 1.0  2018/10/10 19:27   by  王帅（wangshuai@cloud-young.com）创建
 * @param
 * @return
 */
    @Test
    public void aopTransactionTest() {
        User user = new User();
        user.setUser_name("kk123");
        user.setPass_word("111");
        user.setEmail("abc@ddd.com");
        service.add1(user);

    }
    /**
     * @Descpription:声明式事务管理 方式2 基于@Transactional注解
     * 这种方式最简单，也是最为常用的
     * @version 1.0  2018/10/10 19:32   by  王帅（wangshuai@cloud-young.com）创建
     * @param
     * @return
     */
    @Test
    public void annotationTransactionTest(){
        User user = new User();
        user.setUser_name("j123");
        user.setPass_word("111");
        user.setEmail("abc@ddd.com");
        service.add2(user);
    }

}
