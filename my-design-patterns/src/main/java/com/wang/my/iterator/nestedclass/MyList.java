package com.wang.my.iterator.nestedclass;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/28 13:35  by  王帅（wangshuai@cloud-young.com）创建
 */
public interface MyList {
    void add(String val);
    int size();
    MyIterator getIterator();
}
