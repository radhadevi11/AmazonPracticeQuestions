package com.radha.amazon;

import org.junit.Test;
import org.assertj.core.api.Assertions;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;


public class LinkedListExampleTest {

    @Test
    public void search() {
        LinkedListExample head = new LinkedListExample(5);
        LinkedListExample secondNode = new LinkedListExample(6);
        LinkedListExample thirdNode = new LinkedListExample(7);
        head.setNextNode(secondNode);
        secondNode.setNextNode(thirdNode);


        Optional<LinkedListExample> expected = Optional.of(secondNode);

        assertThat(head.search(6)).isPresent().isEqualTo(expected);

    }


    @Test
    public void searchForNotAvailableValue() {
        LinkedListExample head = new LinkedListExample(5);
        LinkedListExample secondNode = new LinkedListExample(6);
        LinkedListExample thirdNode = new LinkedListExample(7);
        head.setNextNode(secondNode);
        secondNode.setNextNode(thirdNode);


        assertThat(head.search(10)).isEmpty();

    }

    @Test
    public void remove() {
        LinkedListExample head = new LinkedListExample(5);
        LinkedListExample secondNode = new LinkedListExample(6);
        LinkedListExample thirdNode = new LinkedListExample(7);
        head.setNextNode(secondNode);
        secondNode.setNextNode(thirdNode);

        assertThat(head.remove(6)).isPresent().isEqualTo(Optional.of(secondNode));
        assertThat(secondNode.getNextNode()).isNull();

    }
    @Test
    public void removeLastNode() {
        LinkedListExample head = new LinkedListExample(5);
        LinkedListExample secondNode = new LinkedListExample(6);
        LinkedListExample thirdNode = new LinkedListExample(7);
        head.setNextNode(secondNode);
        secondNode.setNextNode(thirdNode);

        LinkedListExample remove = new LinkedListExample(7);
        Optional<LinkedListExample> expected = Optional.of(remove);

        assertThat(head.remove(7)).isPresent().isEqualTo(expected);

    }

    @Test
    public void removeHead() {
        LinkedListExample head = new LinkedListExample(5);
        LinkedListExample secondNode = new LinkedListExample(6);
        LinkedListExample thirdNode = new LinkedListExample(7);
        head.setNextNode(secondNode);
        secondNode.setNextNode(thirdNode);

        LinkedListExample remove = new LinkedListExample(5);
        remove.setNextNode(secondNode);
        Optional<LinkedListExample> expected = Optional.of(remove);

        assertThat(head.remove(5)).isPresent().isEqualTo(expected);

    }
    @Test
    public void removeSingleNode() {
        LinkedListExample head = new LinkedListExample(5);


        LinkedListExample remove = new LinkedListExample(5);//why I did not got null pointer exception?
        Optional<LinkedListExample> expected = Optional.of(remove);

        assertThat(head.remove(5)).isPresent().isEqualTo(expected);

    }


    @Test
    public void removeForNotAvailableValue() {
        LinkedListExample head = new LinkedListExample(5);
        LinkedListExample secondNode = new LinkedListExample(6);
        LinkedListExample thirdNode = new LinkedListExample(7);
        head.setNextNode(secondNode);
        secondNode.setNextNode(thirdNode);


        assertThat(head.remove(10)).isEmpty();

    }


    @Test
    public void insertAfter() {
        LinkedListExample head = new LinkedListExample(5);
        LinkedListExample secondNode = new LinkedListExample(6);
        LinkedListExample thirdNode = new LinkedListExample(7);
        head.setNextNode(secondNode);
        secondNode.setNextNode(thirdNode);

        LinkedListExample expected = new LinkedListExample(8);
        expected.setNextNode(thirdNode);


        assertThat(secondNode.insertAfter(8)).isEqualTo(expected);

    }

    @Test
    public void insertAfterInTheLast() {
        LinkedListExample head = new LinkedListExample(5);


        LinkedListExample expected = new LinkedListExample(8);

        assertThat(head.insertAfter(8)).isEqualTo(expected);

    }

    @Test
    public void testGetLastNode() {
        LinkedListExample head = new LinkedListExample(5);
        LinkedListExample node2 = new LinkedListExample(10);
        LinkedListExample node3 = new LinkedListExample(15);
        head.setNextNode(node2);
        node2.setNextNode(node3);

        assertThat(head.getLastNode()).isEqualTo(node3);
    }

    @Test
    public void testInsertLast(){
        LinkedListExample head = new LinkedListExample(5);
        LinkedListExample node2 = new LinkedListExample(10);
        LinkedListExample node3 = new LinkedListExample(15);
        head.setNextNode(node2);
        node2.setNextNode(node3);

        LinkedListExample newNode = new LinkedListExample(20);
        head.insertLast(newNode);

        assertThat(head.getLastNode()).isEqualTo(newNode);
    }
    @Test
    public void testInsertLastInSingleNode(){
        LinkedListExample head = new LinkedListExample(5);

        LinkedListExample newNode = new LinkedListExample(20);
        head.insertLast(newNode);

        assertThat(head.getLastNode()).isEqualTo(newNode);
    }
}