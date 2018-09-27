package com.wang.my.command;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/27 19:07  by  王帅（wangshuai@cloud-young.com）创建
 */
public class LightOnCommand implements Command {
    public void execute() {
        System.out.println("Light is on.");
    }
}
