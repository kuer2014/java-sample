package com.wang.my.strategy;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/28 17:36  by  王帅（wangshuai@cloud-young.com）创建
 */
public class Calculator {
    private Operation operation;

    public Calculator(Operation operation) {
        this.operation = operation;
    }
    public int executeOperation(int x,int y){
       return this.operation.operating(x,y);
    }
}
