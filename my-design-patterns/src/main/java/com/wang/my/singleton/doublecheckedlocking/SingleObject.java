package com.wang.my.singleton.doublecheckedlocking;

/**
 * Description:
 4、双检锁/双重校验锁（DCL，即 double-checked locking）
 JDK 版本：JDK1.5 起
 是否 Lazy 初始化：是
 是否多线程安全：是
 实现难度：较复杂
 描述：这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
 getInstance() 的性能对应用程序很关键。
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/21 14:58  by  王帅（wangshuai@cloud-young.com）创建
 */
public class SingleObject {
    private SingleObject(){}
    private volatile static  SingleObject instance;

    public static SingleObject getInstance() {
        if(instance==null){
            synchronized (SingleObject.class){
                if(instance==null){
                    instance=new SingleObject();
                }
            }
        }
        return instance;
    }
}
