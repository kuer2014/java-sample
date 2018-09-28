package com.wang.my.iterator.nestedclass;

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
        return new MyIteratorImpl();
    }
    //使用内部类，可直接使用外部类的属性 size 和 list
    private class MyIteratorImpl implements MyIterator{
        int cursor=0;
        public boolean hasNext() {
            return !(size==cursor);
        }

        public String next() {
            cursor++;
            return list[cursor-1];
        }
    }
}
