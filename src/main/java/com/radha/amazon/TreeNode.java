package com.radha.amazon;

import java.util.Objects;

public class TreeNode {
    private int value;
    private TreeNode rightChild;
    private TreeNode leftChild;

    public int getValue() {
        return value;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode add(int value){
        if(value > this.value){
            if(this.rightChild == null){
                TreeNode rightChild = new TreeNode(value);
                this.rightChild = rightChild;
                return rightChild;
            }
            else {
                return rightChild.add(value);
            }
        }
        else if(value < this.value){
            if(this.leftChild == null){
                TreeNode leftChild = new TreeNode(value);
                this.leftChild = leftChild;
                return leftChild;
            }
            else {
                return leftChild.add(value);
            }
        }
        else {
            return this;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TreeNode)) return false;
        TreeNode treeNode = (TreeNode) o;
        return getValue() == treeNode.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                '}';
    }

    /*
    Find Lowest Common Ancestor of 2 nodes:
    Step 1 : Find all the ancestors of the given first node and store in a1
    Step 2 : Find all the ancestors of the given second node and store in a2
    Step 3 : Process the 2 a1 and a2 and find last common value*/
}






