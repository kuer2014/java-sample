package com.wang.my.builder;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/26 17:58  by  王帅（wangshuai@cloud-young.com）创建
 */
public interface BuildComputer {
     void buildCpu();
     void buildMemory();
     void buildDisc();
     Computer getComputer();
}
