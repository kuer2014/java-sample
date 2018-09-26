package com.wang.my.builder;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/26 18:41  by  王帅（wangshuai@cloud-young.com）创建
 */
public class BuildDellCompuer implements BuildComputer {
    private Computer computer;

    public BuildDellCompuer() {
        this.computer = new Computer();
    }

    public void buildCpu() {
        this.computer.setCpu("AMD 123");
    }

    public void buildMemory() {
        this.computer.setMemory("三星 8G");
    }

    public void buildDisc() {
        this.computer.setDisc("ST 1000G");
    }

    public Computer getComputer() {
        return this.computer;
    }
}
