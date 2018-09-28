package com.wang.my.strategy;

/**
 * Description:策略模式
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/28 17:38  by  王帅（wangshuai@cloud-young.com）创建
 */
public class App {
    public static void main(String[] args) {
        Calculator  add = new Calculator(new OperationAdd());
        int result =add.executeOperation(2,3);
        System.out.println(result);
        Calculator  subtract = new Calculator(new OperationSubtract());
         result =subtract.executeOperation(2,3);
        System.out.println(result);
    }
}
