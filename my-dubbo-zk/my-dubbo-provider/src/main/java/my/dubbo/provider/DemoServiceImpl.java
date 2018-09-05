package my.dubbo.provider;

import org.springframework.stereotype.Service;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/4/24 11:42  by  王帅（wangshuai@cloud-young.com）创建
 */
@Service
public class DemoServiceImpl implements DemoService {

    public String sayHello(String str) {
        System.out.println("hello dubbo provider!");
        return str;
    }
}
