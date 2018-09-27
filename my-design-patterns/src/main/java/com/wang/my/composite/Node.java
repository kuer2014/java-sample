package com.wang.my.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/9/27 15:20  by  王帅（wangshuai@cloud-young.com）创建
 */
public class Node {
    private String name;
    List<Node> nodeList = new ArrayList<Node>();

    public Node(String name) {
        this.name = name;
    }

    //新增节点
    public void addNode(Node node) throws Exception {
        nodeList.add(node);
    }

    void display() {
        System.out.println(name);
        for (Node node : nodeList) {
            node.display();
        }
    }
}
