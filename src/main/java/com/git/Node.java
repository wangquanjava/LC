package com.git;

import lombok.Getter;
import lombok.Setter;

/**
 * @author wangquan07
 * 2019/10/22 15:06
 */
@Getter
@Setter
public class Node {
    private int value;
    private Node parent;
    private Node rightChild;
    private Node leftChild;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("节点value:%s", this.getValue());
    }
}
