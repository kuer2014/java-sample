package com.wang.my.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Description:java 语言中的迭代器应用
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/28 12:07  by  王帅（wangshuai@cloud-young.com）创建
 */
public class App {
    public static void main(String[] args) {
        List list =new ArrayList<String>();
        list.add("aa");
        list.add("bb");
       Iterator iterable= list.iterator();
      String s = (String)iterable.next();
        System.out.println(s);
    }
}
