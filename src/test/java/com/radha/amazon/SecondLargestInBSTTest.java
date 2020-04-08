package com.radha.amazon;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

public class SecondLargestInBSTTest {

    @Test
    public void getSecondLargestNodeInRightSubTree() {
        SecondLargestInBST largest = new SecondLargestInBST();
        TreeNode root = new TreeNode(5);
        root.add(3);
        root.add(7);
        root.add(2);
        root.add(4);
        root.add(6);
        root.add(8);

        TreeNode actual = largest.getSecondLargestNodeInRightSubTree(root);

        assertThat(actual).isEqualTo(new TreeNode(7));
    }

    @Test
    public void getRootAsSecondLargestNodeInRightSubTree() {
        SecondLargestInBST largest = new SecondLargestInBST();
        TreeNode root = new TreeNode(5);
        root.add(3);
        root.add(7);
        root.add(2);
        root.add(4);


        TreeNode actual = largest.getSecondLargestNodeInRightSubTree(root);

        assertThat(actual).isEqualTo(root);
    }


    @Test
    public void getLargestNodeInLeftSubTree() {
        SecondLargestInBST largest = new SecondLargestInBST();
        TreeNode root = new TreeNode(5);
        root.add(3);
        root.add(2);
        root.add(4);

        TreeNode actual = largest.getLargestNodeInLeftSubTree(root);

        assertThat(actual).isEqualTo(new TreeNode(4));
    }

    @Test
    public void getLeftChildAsLargestNodeInLeftSubTree() {
        SecondLargestInBST largest = new SecondLargestInBST();
        TreeNode root = new TreeNode(5);
        root.add(3);


        TreeNode actual = largest.getLargestNodeInLeftSubTree(root);

        assertThat(actual).isEqualTo(new TreeNode(3));
    }


    @Test
    public void getSecondLargestNumber() {
        SecondLargestInBST largest = new SecondLargestInBST();
        TreeNode root = new TreeNode(5);
        root.add(3);
        root.add(7);
        root.add(2);
        root.add(4);
        root.add(6);
        root.add(8);

        assertThat(largest.getSecondLargestNumber(root)).isEqualTo(7);
    }

    @Test
    public void getSecondLargestNumberInLeftSubTree() {
        SecondLargestInBST largest = new SecondLargestInBST();
        TreeNode root = new TreeNode(5);
        root.add(3);
        root.add(2);
        root.add(4);

        assertThat(largest.getSecondLargestNumber(root)).isEqualTo(4);
    }

    @Test
    public void getSecondLargestNumberInSingleNode() {
        SecondLargestInBST largest = new SecondLargestInBST();
        TreeNode root = new TreeNode(5);

        assertThatThrownBy(() -> largest.getSecondLargestNumber(root))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Can not find second largest using single node");
    }




}