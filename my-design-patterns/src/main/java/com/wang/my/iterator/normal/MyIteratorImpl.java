package com.wang.my.iterator.normal;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/28 14:39  by  王帅（wangshuai@cloud-young.com）创建
 */
public class MyIteratorImpl implements MyIterator {
    int cursor=0;
    String[] list;
    int size=0;
    public MyIteratorImpl(String[] list,int size) {
        this.list = list;
        this.size=size;
    }

    public boolean hasNext() {
        return !(size==cursor);
    }

    public String next() {
        cursor++;
        return list[cursor-1];
    }

}
