package com.wang.my.builder;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/26 18:12  by  王帅（wangshuai@cloud-young.com）创建
 */
public class Director {
    public static Computer getComputer(BuildComputer buildComputer){
        buildComputer.buildCpu();
        buildComputer.buildMemory();
        buildComputer.buildDisc();
        return buildComputer.getComputer();
    }
}
