package com.wang.my.facade;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/27 16:23  by  王帅（wangshuai@cloud-young.com）创建
 */
public class ComputerFactory {
    private CpuFactory cpuFactory;
    private MemoryFactory memoryFactory;
    private DiskFactory diskFactory;

    public ComputerFactory() {
        this.cpuFactory = new CpuFactory();
        this.memoryFactory = new MemoryFactory();
        this.diskFactory = new DiskFactory();
    }

    public void makeComputer() {
        this.cpuFactory.makeCpu();
        this.memoryFactory.makeMemory();
        this.diskFactory.makeDisk();
    }

}
