package com.radha.amazon;

public class Node {
    private Object value;
    private Node rightChild;
    private Node leftChild;

    public Node(Object value) {
        this.value = value;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }
}
