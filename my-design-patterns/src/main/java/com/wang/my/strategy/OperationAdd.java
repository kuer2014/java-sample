package com.wang.my.strategy;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/28 17:32  by  王帅（wangshuai@cloud-young.com）创建
 */
public class OperationAdd implements Operation {
    public int operating(int x, int y) {
        return x+y;
    }
}
