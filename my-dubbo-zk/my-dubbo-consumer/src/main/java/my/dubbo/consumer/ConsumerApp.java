package my.dubbo.consumer;

import my.dubbo.provider.CalcService;
import my.dubbo.provider.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/4/24 14:15  by  王帅（wangshuai@cloud-young.com）创建
 */
public class ConsumerApp {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"my-consumer.xml"});
        context.start();
        System.out.println("consumer started.");
        // obtain proxy object for remote invocation
        DemoService demoService = (DemoService) context.getBean("demoService");
        // execute remote invocation
        String hello = demoService.sayHello("world");
        // show the result
        System.out.println(hello);

        CalcService calcService=(CalcService)context.getBean("calcService");
        System.out.println(calcService.add(2,3));
        System.out.println("consumer runs successfully.");
    }
}
