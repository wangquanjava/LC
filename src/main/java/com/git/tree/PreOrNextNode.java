package com.git.tree;

import com.git.Node;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * 获取二叉树任意节点的前驱或后继节点
 *
 * @author wangquan07
 * 2019/10/22 15:05
 */
public class PreOrNextNode {
    public static void main(String[] args) {
        List<Node> nodeList = init();
        Node node = nodeList.get(0);
        System.out.println("锁定" + node);

        Node preNode = getPreNode(node);
        System.out.println("前驱" + preNode);

        Node nextNode = getNextNode(node);
        System.out.println("后继" + nextNode);
    }



    public static Node getPreNode(Node node) {
        if (node.getLeftChild() != null) {
            return getMax(node.getLeftChild());
        } else {
            return getUpSmaller(node);
        }
    }

    /**
     * 获取该Node为根的树, 最大的node
     */
    private static Node getMax(Node node) {
        if (node.getRightChild() != null) {
            return getMax(node.getRightChild());
        } else {
            return node;
        }
    }

    /**
     * 向上获取更小一点的node(\)
     */
    private static Node getUpSmaller(Node node) {
        if (node.getParent() == null) {
            return null;
        }

        if (node.getParent().getRightChild() == node) {
            // 如果父节点的右孩子是自己, 那就返回父节点
            return node.getParent();
        } else {
            // 递归查找父节点
            return getUpSmaller(node.getParent());
        }
    }

    public static Node getNextNode(Node node) {
        if (node.getRightChild() != null) {
            return getMin(node.getRightChild());
        } else {
            return getUpGreater(node);
        }
    }

    private static Node getMin(Node node) {
        if (node.getLeftChild() != null) {
            return getMin(node.getLeftChild());
        } else {
            return node;
        }
    }

    private static Node getUpGreater(Node node) {
        if (node.getParent() == null) {
            return null;
        }
        if (node.getParent().getLeftChild() == node) {
            return node.getParent();
        } else {
            return getUpGreater(node.getParent());
        }
    }






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
