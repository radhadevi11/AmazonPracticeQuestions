package com.radha.amazon;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

public class ListFatteningTest {

    @Test
    public void testProcess() {
        ListFattening listFattening = new ListFattening();

        DoublyLinkedListWithChild node = new DoublyLinkedListWithChild("x");
        node.insertAfter(new DoublyLinkedListExample("yy"));
        node.getNextNode();

        DoublyLinkedListWithChild node1 = new DoublyLinkedListWithChild("1");
        DoublyLinkedListWithChild node11 = new DoublyLinkedListWithChild("1.1");
        node1.setChildNode(node11);
        DoublyLinkedListWithChild node111 = new DoublyLinkedListWithChild("1.1.1");
        node11.setChildNode(node111);
        DoublyLinkedListWithChild node12 = new DoublyLinkedListWithChild("1.2");
        node11.insertAfter(node12);


        DoublyLinkedListWithChild node2 = new DoublyLinkedListWithChild("2");
        node1.insertAfter(node2);
        DoublyLinkedListWithChild node21 = new DoublyLinkedListWithChild("2.1");

        node2.setChildNode(node21);

        DoublyLinkedListWithChild node3 = new DoublyLinkedListWithChild("3");
        node2.insertAfter(node3);
        DoublyLinkedListWithChild node31 = new DoublyLinkedListWithChild("3.1");
        node3.setChildNode(node31);

        DoublyLinkedListExample actual = listFattening.process(node1, node3);

        assertThat(actual).isEqualTo(new DoublyLinkedListExample("1"));
        assertThat(actual.getLastNode()).isEqualTo(new DoublyLinkedListExample("3.1"));
        actual.printList();


    }

    @Test
    public void testProcessWithLessNodes() {
        ListFattening listFattening = new ListFattening();

        DoublyLinkedListWithChild node1 = new DoublyLinkedListWithChild("1");
        DoublyLinkedListWithChild node11 = new DoublyLinkedListWithChild("1.1");
        node1.setChildNode(node11);

        DoublyLinkedListWithChild node2 = new DoublyLinkedListWithChild("2");
        node1.insertAfter(node2);

        DoublyLinkedListWithChild node3 = new DoublyLinkedListWithChild("3");
        node2.insertAfter(node3);


        DoublyLinkedListExample actual = listFattening.process(node1, node3);

        assertThat(actual).isEqualTo(new DoublyLinkedListExample("1"));
//       assertThat(node1.getLastNode()).isEqualTo(new DoublyLinkedListExample("3.1"));
        actual.printList();


    }
}