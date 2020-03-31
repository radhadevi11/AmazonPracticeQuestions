package com.radha.amazon;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

public class ListFatteningTest {

    @Test
    public void process() {

    }

    @Test
    public void testIsLastNodeForTailNode() {
        ListFattening head = new ListFattening(5);
        DoublyLinkedListExample tail =  head.insertAfter(10);

        assertThat(((ListFattening)tail).isLastNode(tail)).isEqualTo(true);

    }

    @Test
    public void testHasChild() {
        ListFattening head = new ListFattening(5);
        head.setChildNode(new DoublyLinkedListExample(10));

        assertThat(head.hasChild()).isEqualTo(true);
    }
    @Test
    public void testHasNotChild() {
        ListFattening head = new ListFattening(5);

        assertThat(head.hasChild()).isEqualTo(false);
    }

    @Test
    public void processNextNode() {
    }

    @Test
    public void processChildNode() {
    }

    @Test
    public void insertNodeInTheResultList() {
    }
}