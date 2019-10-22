package com.git.tree;

import com.git.Node;

/**
 * @author wangquan07
 * 2019/10/22 16:54
 */
public class FuzzySearchNode {

    public static void main(String[] args) {
        Node root = TreeInit.initNo4();

        Node result = fuzzyGreaterSearch(root, 4);
        System.out.println(result);

    }

    public static Node fuzzyGreaterSearch(Node node, int key) {
        if (key == node.getValue()) {
            // 直接找到
            return node;
        } else if (key > node.getValue()) {
            // 比根大
            if (node.getRightChild() != null) {
                // 如果存在右孩子, 在右子树再查找
                return fuzzyGreaterSearch(node.getRightChild(), key);
            } else {
                // 如果不存在, 找当前节点的后继节点
                return PreOrNextNode.getNextNode(node);
            }
        } else {
            if (node.getLeftChild() != null) {
                // 如果存在左孩子, 在左子树查找
                return fuzzyGreaterSearch(node.getLeftChild(), key);
            } else {
                // 如果不存在, 当前节点就是比key大一点
                return node;
            }
        }
    }

}
