package com.wang.my.builder;

/**
 * Description:建造者模式
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/26 18:07  by  王帅（wangshuai@cloud-young.com）创建
 */
public class App {
    public static void main(String[] args) {
        Computer lenovo = Director.getComputer(new BuildLenovoComputer());
        System.out.println(lenovo.getCpu());
        Computer dell =  Director.getComputer(new BuildDellCompuer());
        System.out.println(dell.getCpu());
    }
}
