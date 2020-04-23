package com.radha.amazon;

public class TreeTraversal {

    void preOrder (TreeNode node) {
        /*
            Step 1: print root value
            Step 2: If left child != null then call preOrder(leftChild)
            Step 3: If right child != null then call preOrder(rightChild)

         */
        System.out.println(node.getValue());

        if(node.getLeftChild() != null) {
            preOrder(node.getLeftChild());
        }

        if(node.getRightChild() != null) {
            preOrder(node.getRightChild());
        }
    }

    void inOrder(TreeNode node) {
        /*
            Step 1: If left child != null then call inOrder(leftChild)
            Step 2: print root value
            Step 3: If right child != null then call inOrder(rightChild)
         */
        if (node.getLeftChild() != null) {
            inOrder(node.getLeftChild());
        }
        System.out.println(node.getValue());

        if (node.getRightChild() != null) {
            inOrder(node.getRightChild());
        }
    }

    void postOrder (TreeNode root) {

        /*
                Step 1: If left child != null then call postOrder(leftChild)
                Step 2: If right child != null then call postOrder(rightChild)
                Step 3: print root value

         */
        if(root.getLeftChild() != null) {
            postOrder(root.getLeftChild());
        }

        if(root.getRightChild() != null) {
            postOrder(root.getRightChild());
        }

        System.out.println(root.getValue());
    }

}
