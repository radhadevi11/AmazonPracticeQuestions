package com.radha.amazon;

public class SecondLargestInBST {

    int getSecondLargestNumber (TreeNode root) {
        /*
    Step 1: if root has no child
             1.1: throw exception
    Step 2: if root has rightChild
             2.1: getLargestNodeInRightSubTree()
             2.2: return it's value
    Step 3: Otherwise
             3.1: getLargestNodeInLeftSubTree()
             3.2: return it's value
     */

        if(root.getLeftChild() == null && root.getRightChild() == null){
            throw new IllegalArgumentException("Can not find second largest using single node");
        }
        if(root.getRightChild() != null) {
            return getSecondLargestNodeInRightSubTree(root).getValue();
        }
        return getLargestNodeInLeftSubTree(root).getValue();
    }

    TreeNode getSecondLargestNodeInRightSubTree(TreeNode root){
        /*
             2.1: for each rightChild in the tree
                2.1.1: if it's rightChild's rightChild is null
                       2.1.2: return the node
         */
        TreeNode tempNode = root;
        while (tempNode.getRightChild() != null) {
            if(tempNode.getRightChild().getRightChild() == null) {
                return tempNode;
            }
            tempNode = tempNode.getRightChild();
        }
        return tempNode;

    }

    TreeNode getLargestNodeInLeftSubTree(TreeNode root) {
        /*
        3.1: if root's leftChild has no rightChild
                       3.1.1: return the leftChild
         3.2: Get the leaf rightChild
         */
        if(root.getLeftChild().getRightChild() == null) {
            return root.getLeftChild();
        }

        TreeNode tempNode = root.getLeftChild().getRightChild();
        while (tempNode.getRightChild() != null) {
            tempNode = tempNode.getRightChild();
        }
        return tempNode;

    }
}
