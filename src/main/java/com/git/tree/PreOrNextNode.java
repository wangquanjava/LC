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
        List<Node> nodeList = TreeInit.init();
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

}
