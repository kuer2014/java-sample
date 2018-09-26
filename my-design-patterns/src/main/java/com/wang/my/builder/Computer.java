package com.wang.my.builder;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/26 17:54  by  王帅（wangshuai@cloud-young.com）创建
 */
public class Computer {
    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }

    private String cpu;
    private String memory;
    private String disc;
}
