package my.dubbo.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/4/24 14:06  by  王帅（wangshuai@cloud-young.com）创建
 */
public class ProviderApp {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] {"my-provider.xml"});
        context.start();
        // press any key to exit
        System.out.println("provider started,press any key to exit");
        System.in.read();
    }
}
