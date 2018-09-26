package com.wang.my.builder;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/26 18:01  by  王帅（wangshuai@cloud-young.com）创建
 */
public class BuildLenovoComputer implements BuildComputer {
    private Computer computer;
    public BuildLenovoComputer() {
        this.computer = new Computer();
    }

    public void buildCpu() {
        this.computer.setCpu("Intel Core 8700");
    }

    public void buildMemory() {
        this.computer.setMemory("Kingstong 4G.");
    }

    public void buildDisc() {
        this.computer.setDisc("westData 500G");
    }

    public Computer getComputer() {
        return this.computer;
    }
}
