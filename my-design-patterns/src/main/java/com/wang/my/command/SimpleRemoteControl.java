package com.wang.my.command;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/27 19:11  by  王帅（wangshuai@cloud-young.com）创建
 */
public class SimpleRemoteControl {
    private Command command;
    public void setCommand(Command command) {
        this.command = command;
    }
    public void buttonWasPressed(){
        this.command.execute();
    }

}
