package com.wang.my.iterator.nestedclass;

/**
 * Description:迭代器模式-内部类的方式
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/28 14:03  by  王帅（wangshuai@cloud-young.com）创建
 */
public class App {
    public static void main(String[] args) {
        MyList list = new ListImpl();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println("size:"+list.size());
        MyIterator iterator = list.getIterator();
        System.out.print("element:");
        while (iterator.hasNext()){
            System.out.print(iterator.next());
        }





    }
}
