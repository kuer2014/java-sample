package com.wang.my.adapter.objectadapter;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/27 13:50  by  王帅（wangshuai@cloud-young.com）创建
 */
public class Adapter implements TypeC {
    Usb usb;
    public Adapter(Usb usb) {
        this.usb = usb;
    }
    public void typeC() {
        this.usb.usb();
    }
}
