package com.radha.amazon;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListProblemsTest {
    @Test
    public void testMthTOLast(){
        LinkedListExample head1 = new LinkedListExample(1);
        LinkedListExample node2 = new LinkedListExample(2);
        LinkedListExample node3 = new LinkedListExample(3);
        LinkedListExample node4 = new LinkedListExample(4);
        LinkedListExample node5 = new LinkedListExample(5);
        LinkedListExample node6 = new LinkedListExample(6);

        head1.setNextNode(node2);
        node2.setNextNode(node3);
        node3.setNextNode(node4);
        node4.setNextNode(node5);
        node5.setNextNode(node6);

        LinkedListProblems listExample = new LinkedListProblems();

        LinkedListExample actual = listExample.mthToLastElementSpaceEfficient(head1, 2);
        assertEquals(actual, node4);
    }

}