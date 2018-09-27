package com.wang.my.command;

/**
 * Description:命令模式
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/27 19:13  by  王帅（wangshuai@cloud-young.com）创建
 */
public class App {
    public static void main(String[] args) {
        SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();

        LightOnCommand lightOnCommand = new LightOnCommand();
        simpleRemoteControl.setCommand(lightOnCommand);
        simpleRemoteControl.buttonWasPressed();
        //Light is on.

        OpenDoorCommand openDoorCommand = new OpenDoorCommand();
        simpleRemoteControl.setCommand(openDoorCommand);
        simpleRemoteControl.buttonWasPressed();
        //Door is open.
    }
}
