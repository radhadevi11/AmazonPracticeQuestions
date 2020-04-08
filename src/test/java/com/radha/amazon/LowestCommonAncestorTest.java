package com.radha.amazon;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

public class LowestCommonAncestorTest {

    @Test
    public void testGetListOfAncestorsForLeftChild() {
        LowestCommonAncestor ancestor = new LowestCommonAncestor();
        TreeNode root = new TreeNode(20);
        root.add(8);
        root.add(22);
        root.add(7);
        root.add(4);

        List<Integer> actual = ancestor.getListOfAncestors(4, root);

        assertThat(actual).isEqualTo(new ArrayList<>(Arrays.asList(20, 8, 7)));
    }

    @Test
    public void testGetListOfAncestorsForRightChild() {
        LowestCommonAncestor ancestor = new LowestCommonAncestor();
        TreeNode root = new TreeNode(20);
        root.add(8);
        root.add(22);
        root.add(21);
        root.add(7);
        root.add(25);

        List<Integer> actual = ancestor.getListOfAncestors(25, root);

        assertThat(actual).isEqualTo(new ArrayList<>(Arrays.asList(20, 22)));
    }

    @Test
    public void testGetListOfAncestorsRootAsValue() {
        LowestCommonAncestor ancestor = new LowestCommonAncestor();
        TreeNode root = new TreeNode(20);
        root.add(8);
        root.add(22);
        root.add(21);
        root.add(7);
        root.add(25);

        List<Integer> actual = ancestor.getListOfAncestors(20, root);

        assertThat(actual).isEqualTo(new ArrayList<>());
    }

    @Test
    public void testGetListOfAncestorsLargeTree() {
        LowestCommonAncestor ancestor = new LowestCommonAncestor();
        TreeNode root = new TreeNode(20);
        root.add(8);
        root.add(22);
        root.add(21);
        root.add(23);
        root.add(17);
        root.add(19);
        root.add(7);
        root.add(45);
        root.add(55);

        List<Integer> actual = ancestor.getListOfAncestors(45, root);

        assertThat(actual).isEqualTo(new ArrayList<>(Arrays.asList(20, 22, 23)));
    }

    @Test
    public void testFindLowestCommonAncestorValue() {
        LowestCommonAncestor ancestor = new LowestCommonAncestor();
        Map<Integer, Integer> ancestorsMap = new HashMap<>();
        ancestorsMap.put(20, 20);
        ancestorsMap.put(8, 8);
        ancestorsMap.put(12, 12);
        List<Integer> ancestors = new ArrayList<>(Arrays.asList(20, 8));

        int actual = ancestor.findLowestCommonAncestorValue(ancestorsMap, ancestors);

        assertThat(actual).isEqualTo(8);
    }

    @Test
    public void testFindLowestCommonAncestorValueForHugeList() {
        LowestCommonAncestor ancestor = new LowestCommonAncestor();
        Map<Integer, Integer> ancestorsMap = new HashMap<>();
        ancestorsMap.put(20, 20);
        ancestorsMap.put(8, 8);
        ancestorsMap.put(12, 12);
        ancestorsMap.put(23, 23);
        ancestorsMap.put(15, 15);
        List<Integer> ancestors = new ArrayList<>(Arrays.asList(20,8, 12,10));

        int actual = ancestor.findLowestCommonAncestorValue(ancestorsMap, ancestors);

        assertThat(actual).isEqualTo(12);
    }

    @Test
    public void testFindLowestCommonAncestorValueForEmptyList() {
        LowestCommonAncestor ancestor = new LowestCommonAncestor();
        Map<Integer, Integer> ancestorsMap = new HashMap<>();
        ancestorsMap.put(20, 20);
        ancestorsMap.put(8, 8);
        ancestorsMap.put(12, 12);
        List<Integer> ancestors = new ArrayList<>();

        int actual = ancestor.findLowestCommonAncestorValue(ancestorsMap, ancestors);

        assertThat(actual).isEqualTo(0);
    }

    @Test
    public void testGetLowestCommonAncestorValue() {
        LowestCommonAncestor ancestor = new LowestCommonAncestor();
        TreeNode root = new TreeNode(20);
        root.add(8);
        root.add(22);
        root.add(4);
        root.add(12);
        root.add(10);
        root.add(14);

        int actual = ancestor.getLowestCommonAncestorValue(4, 14, root);

        assertThat(actual).isEqualTo(8);
    }

    @Test
    public void testGetLowestCommonAncestorRootAsValue() {
        LowestCommonAncestor ancestor = new LowestCommonAncestor();
        TreeNode root = new TreeNode(20);
        root.add(8);
        root.add(22);
        root.add(4);
        root.add(12);
        root.add(10);
        root.add(14);


        assertThatThrownBy (() -> ancestor.getLowestCommonAncestorValue(20, 14, root))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Can not find ancestors for root");
    }
}