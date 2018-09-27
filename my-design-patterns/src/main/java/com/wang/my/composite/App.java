package com.wang.my.composite;

/**
 * Description:组合模式
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/27 15:22  by  王帅（wangshuai@cloud-young.com）创建
 */
public class App {
    public static void main(String[] args) {
        Node node = new Node("dir");
        Node node1 = new Node("dir/dir1");
        Node node2 = new Node("dir/dir2");
        try {
            node.addNode(node1);
            node.addNode(node2);
        } catch (Exception ex) {
        }
        node.display();
    }
}
