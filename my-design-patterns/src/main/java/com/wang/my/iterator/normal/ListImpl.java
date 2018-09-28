package com.wang.my.iterator.normal;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/28 13:40  by  王帅（wangshuai@cloud-young.com）创建
 */
public class ListImpl implements MyList {
    String[] list;
    int size = 0;

    public ListImpl() {
        this.list = new String[10];
    }

    public void add(String val) {
        this.list[size] = val;
        size++;
    }

    public int size() {
        return size;
    }

    public MyIterator getIterator() {
        return new MyIteratorImpl(list,size);
    }

}
