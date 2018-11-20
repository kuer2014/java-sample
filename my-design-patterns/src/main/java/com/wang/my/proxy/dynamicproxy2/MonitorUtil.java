package com.wang.my.proxy.dynamicproxy2;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/11/20 11:12  by  王帅（wangshuai@cloud-young.com）创建
 */
public class MonitorUtil {

    private static ThreadLocal<Long> tl = new ThreadLocal<Long>();

    public static void start() {
        tl.set(System.currentTimeMillis());
    }

    //结束时打印耗时
    public static void finish(String methodName) {
        long finishTime = System.currentTimeMillis();
        System.out.println(methodName + "方法耗时" + (finishTime - tl.get()) + "ms");
    }
}
