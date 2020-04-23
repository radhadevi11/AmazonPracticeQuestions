package com.radha.amazon;

import org.junit.Test;

import static org.junit.Assert.*;

public class TreeTraversalTest {

    @Test
    public void testPreOrder() {
        TreeTraversal treeTraversal = new TreeTraversal();
        TreeNode root = new TreeNode(5);
        root.add(2);
        root.add(4);
        root.add(8);
        root.add(7);
        root.add(10);
        root.add(1);

        treeTraversal.preOrder(root);
    }

    @Test
    public void testInOrder() {
        TreeTraversal treeTraversal = new TreeTraversal();
        TreeNode root = new TreeNode(5);
        root.add(2);
        root.add(4);
        root.add(8);
        root.add(7);
        root.add(10);
        root.add(1);

        treeTraversal.inOrder(root);

    }

    @Test
    public void testPostOrder() {
        TreeTraversal treeTraversal = new TreeTraversal();
        TreeNode root = new TreeNode(5);
        root.add(2);
        root.add(4);
        root.add(8);
        root.add(7);
        root.add(10);
        root.add(1);

        treeTraversal.postOrder(root);
    }
}