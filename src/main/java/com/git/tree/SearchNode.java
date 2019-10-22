package com.git.tree;

import com.git.Node;

import java.util.List;

/**
 * @author wangquan07
 * 2019/10/22 16:54
 */
public class SearchNode {

    public static void main(String[] args) {
        List<Node> init = TreeInit.init();
        Node root = init.get(5);

        Node result = search(root, 3);
        System.out.println(result);

    }

    private static Node search(Node node, int key) {
        if (node == null) {
            return null;
        }
        if (key == node.getValue()) {
            return node;
        } else if (key > node.getValue()) {
            return search(node.getRightChild(), key);
        } else {
            return search(node.getLeftChild(), key);
        }
    }
}
