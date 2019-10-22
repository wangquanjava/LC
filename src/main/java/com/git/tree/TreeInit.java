package com.git.tree;

import com.git.Node;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author wangquan07
 * 2019/10/22 16:54
 */
public class TreeInit {
    public static List<Node> init() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);


        connect(node1, null, node5);

        connect(node3, node2, null);
        connect(node3, null, node4);

        connect(node5, node3, null);

        connect(node6, node1, null);
        connect(node6, null, node7);

        connect(node7, null, node9);

        connect(node9, node8, null);
        connect(node9, null, node10);

        return Lists.newArrayList(node1, node2, node3, node4, node5, node6, node7, node8, node9, node10);
    }

    /**
     * 没有node8
     * @return
     */
    public static Node initNo8() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node9 = new Node(9);
        Node node10 = new Node(10);


        connect(node1, null, node5);

        connect(node3, node2, null);
        connect(node3, null, node4);

        connect(node5, node3, null);

        connect(node6, node1, null);
        connect(node6, null, node7);

        connect(node7, null, node9);

        connect(node9, null, node10);
        return node6;
    }
    /**
     * 没有node8
     * @return
     */
    public static Node initNo4() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);


        connect(node1, null, node5);

        connect(node3, node2, null);

        connect(node5, node3, null);

        connect(node6, node1, null);
        connect(node6, null, node7);

        connect(node7, null, node9);

        connect(node9, node8, null);
        connect(node9, null, node10);

        return node6;
    }

    public static void connect(Node parent, Node leftChild, Node rightChild) {
        if (leftChild != null) {
            parent.setLeftChild(leftChild);
            leftChild.setParent(parent);
        } else if (rightChild != null) {
            parent.setRightChild(rightChild);
            rightChild.setParent(parent);
        }
    }
}
