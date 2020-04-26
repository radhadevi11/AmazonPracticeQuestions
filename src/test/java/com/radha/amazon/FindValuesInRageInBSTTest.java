package com.radha.amazon;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

public class FindValuesInRageInBSTTest {

    @Test
    public void testIsRootInRange() {
        FindValuesInRageInBST valuesInRageInBST = new FindValuesInRageInBST();

        assertThat(valuesInRageInBST.isRootInRange(6, 10,  7)).isEqualTo(true);
    }

    @Test
    public void testIsRootLessThanRange() {
        FindValuesInRageInBST valuesInRageInBST = new FindValuesInRageInBST();

        assertThat(valuesInRageInBST.isRootInRange(6, 10,  4)).isEqualTo(false);
    }

    @Test
    public void testIsRootGreaterThanRange() {
        FindValuesInRageInBST valuesInRageInBST = new FindValuesInRageInBST();

        assertThat(valuesInRageInBST.isRootInRange(6, 10,  12)).isEqualTo(false);
    }

    @Test
    public void testGetListOfRange() {
        TreeNode root = new TreeNode(8);
        root.add(6);
        root.add(10);
        root.add(4);
        root.add(7);
        root.add(9);
        root.add(11);
        FindValuesInRageInBST valuesInRageInBST = new FindValuesInRageInBST();

        assertThat(valuesInRageInBST.getListOfRange(6, 10, root))
                .containsExactly(6, 7, 8, 9, 10);
    }

    @Test
    public void testGetListOfRangeNotTreeContainsAllValue() {
        TreeNode root = new TreeNode(8);
        root.add(5);
        root.add(6);
        root.add(4);
        root.add(10);
        root.add(13);
        root.add(11);
        FindValuesInRageInBST valuesInRageInBST = new FindValuesInRageInBST();

        assertThat(valuesInRageInBST.getListOfRange(5, 12, root))
                .containsExactly(5, 6, 8, 10, 11);
    }


}