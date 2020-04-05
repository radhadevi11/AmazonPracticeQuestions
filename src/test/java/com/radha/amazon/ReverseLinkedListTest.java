package com.radha.amazon;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

public class ReverseLinkedListTest {

    @Test
    public void reverseList() {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();

        LinkedListExample head = new LinkedListExample(1);
        LinkedListExample node2 = head.insertAfter(2);
        LinkedListExample node3 = node2.insertAfter(3);
        LinkedListExample node4 = node3.insertAfter(4);
        LinkedListExample node5 = node4.insertAfter(5);

        LinkedListExample reversedListHead = reverseLinkedList.reverseList(head);

        assertThat(reversedListHead).isEqualTo(node5);
        assertThat(reversedListHead.getLastNode()).isEqualTo(head);
        reversedListHead.printList();

    }
}