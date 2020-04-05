package com.radha.amazon;

import org.junit.Test;
import org.assertj.core.api.Assertions;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

public class DoublyLinkedListExampleTest {

    @Test
    public void search() {
        DoublyLinkedListExample head = new DoublyLinkedListExample(5);
        DoublyLinkedListExample secondNode = new DoublyLinkedListExample(6);
        DoublyLinkedListExample thirdNode = new DoublyLinkedListExample(7);
        head.setNextNode(secondNode);
        secondNode.setPreviousNode(head);
        secondNode.setNextNode(thirdNode);
        thirdNode.setPreviousNode(secondNode);

        DoublyLinkedListExample search = new DoublyLinkedListExample(7);
        search.setPreviousNode(secondNode);
        Optional<DoublyLinkedListExample> expected = Optional.of(search);

        assertThat(head.search(7)).isPresent().isEqualTo(expected);

    }


    @Test
    public void searchForNotAvailableValue() {
        DoublyLinkedListExample head = new DoublyLinkedListExample(5);
        DoublyLinkedListExample secondNode = new DoublyLinkedListExample(6);
        DoublyLinkedListExample thirdNode = new DoublyLinkedListExample(7);
        head.setNextNode(secondNode);
        secondNode.setPreviousNode(head);
        secondNode.setNextNode(thirdNode);
        thirdNode.setPreviousNode(secondNode);



        assertThat(head.search(10)).isEmpty();

    }

    @Test
    public void removeInTheMiddle() {
        DoublyLinkedListExample head = new DoublyLinkedListExample(5);
        DoublyLinkedListExample secondNode = new DoublyLinkedListExample(6);
        DoublyLinkedListExample thirdNode = new DoublyLinkedListExample(7);
        head.setNextNode(secondNode);
        secondNode.setPreviousNode(head);
        secondNode.setNextNode(thirdNode);
        thirdNode.setPreviousNode(secondNode);


        DoublyLinkedListExample remove = new DoublyLinkedListExample(6);
        remove.setPreviousNode(head);
        remove.setNextNode(thirdNode);
        Optional<DoublyLinkedListExample> expected = Optional.of(remove);

        assertThat(head.remove(6)).isPresent().isEqualTo(expected);

    }
    @Test
    public void removeLastNode() {
        DoublyLinkedListExample head = new DoublyLinkedListExample(5);
        DoublyLinkedListExample secondNode = new DoublyLinkedListExample(6);
        DoublyLinkedListExample thirdNode = new DoublyLinkedListExample(7);
        head.setNextNode(secondNode);
        secondNode.setPreviousNode(head);
        secondNode.setNextNode(thirdNode);
        thirdNode.setPreviousNode(secondNode);

        DoublyLinkedListExample remove = new DoublyLinkedListExample(7);
        remove.setPreviousNode(secondNode);
        Optional<DoublyLinkedListExample> expected = Optional.of(remove);

        assertThat(head.remove(7)).isPresent().isEqualTo(expected);

    }

    @Test
    public void removeHead() {
        DoublyLinkedListExample head = new DoublyLinkedListExample(5);
        DoublyLinkedListExample secondNode = new DoublyLinkedListExample(6);
        DoublyLinkedListExample thirdNode = new DoublyLinkedListExample(7);
        head.setNextNode(secondNode);
        secondNode.setNextNode(thirdNode);

        DoublyLinkedListExample remove = new DoublyLinkedListExample(5);
        remove.setNextNode(secondNode);
        Optional<DoublyLinkedListExample> expected = Optional.of(remove);

        assertThat(head.remove(5)).isPresent().isEqualTo(expected);

    }
    @Test
    public void removeSingleNode() {
        DoublyLinkedListExample head = new DoublyLinkedListExample(5);


        DoublyLinkedListExample remove = new DoublyLinkedListExample(5);//why I did not get null pointer exception?
        Optional<DoublyLinkedListExample> expected = Optional.of(remove);

        assertThat(head.remove(5)).isPresent().isEqualTo(expected);

    }


    @Test
    public void removeForNotAvailableValue() {
        DoublyLinkedListExample head = new DoublyLinkedListExample(5);
        DoublyLinkedListExample secondNode = new DoublyLinkedListExample(6);
        DoublyLinkedListExample thirdNode = new DoublyLinkedListExample(7);
        head.setNextNode(secondNode);
        secondNode.setNextNode(thirdNode);


        assertThat(head.remove(10)).isEmpty();

    }


    @Test
    public void insertAfterInThMiddle() {
        DoublyLinkedListExample head = new DoublyLinkedListExample(5);
        DoublyLinkedListExample secondNode = new DoublyLinkedListExample(6);
        DoublyLinkedListExample thirdNode = new DoublyLinkedListExample(7);
        head.setNextNode(secondNode);
        secondNode.setPreviousNode(head);
        secondNode.setNextNode(thirdNode);
        thirdNode.setPreviousNode(secondNode);


        DoublyLinkedListExample expected = new DoublyLinkedListExample(8);
        expected.setNextNode(thirdNode);
        expected.setPreviousNode(secondNode);


        assertThat(secondNode.insertAfter(8)).isEqualTo(expected);

    }

    @Test
    public void insertAfterInTheLast() {
        DoublyLinkedListExample head = new DoublyLinkedListExample(5);


        DoublyLinkedListExample expected = new DoublyLinkedListExample(8);
        expected.setPreviousNode(head);

        assertThat(head.insertAfter(8)).isEqualTo(expected);

    }

    @Test
    public void testGetLastNode(){
        DoublyLinkedListExample head = new DoublyLinkedListExample(5);
        DoublyLinkedListExample secondNode = head.insertAfter(6);
        DoublyLinkedListExample thirdNode = secondNode.insertAfter(7);

        assertThat(head.getLastNode()).isEqualTo(thirdNode);
    }

    @Test
    public void testGetLastNodeForSingleNode(){
        DoublyLinkedListExample head = new DoublyLinkedListExample(5);

        assertThat(head.getLastNode()).isEqualTo(head);
    }

    @Test
    public void insertNodeInTheMiddle(){
        DoublyLinkedListExample head = new DoublyLinkedListExample(5);
        DoublyLinkedListExample secondNode = head.insertAfter(6);
        DoublyLinkedListExample thirdNode = secondNode.insertAfter(7);

        DoublyLinkedListExample newNode = new DoublyLinkedListExample(8);
        DoublyLinkedListExample nextNode = newNode.insertAfter(9);

        secondNode.insertNodeInTheMiddle(newNode);

        assertThat(secondNode.getNextNode()).isEqualTo(newNode);
        assertThat(newNode.getPreviousNode()).isEqualTo(secondNode);
        assertThat(nextNode.getNextNode()).isEqualTo(thirdNode);
        assertThat(thirdNode.getPreviousNode()).isEqualTo(nextNode);
        assertThat(head.getLastNode()).isEqualTo(thirdNode);
        assertThat(thirdNode.getPreviousNode()).isEqualTo(nextNode);
    }

    @Test
    public void insertNodeInTheMiddleForSingleNode(){
        DoublyLinkedListExample head = new DoublyLinkedListExample(5);

        DoublyLinkedListExample newNode = new DoublyLinkedListExample(8);
        DoublyLinkedListExample nextNode = newNode.insertAfter(9);

        head.insertNodeInTheMiddle(newNode);

        assertThat(head.getNextNode()).isEqualTo(newNode);
        assertThat(newNode.getPreviousNode()).isEqualTo(head);
        assertThat(head.getLastNode()).isEqualTo(nextNode);
    }

    @Test
    public void insertNodeInTheMiddleForSingleNewNode(){
        DoublyLinkedListExample head = new DoublyLinkedListExample(5);

        DoublyLinkedListExample newNode = new DoublyLinkedListExample(8);

        head.insertNodeInTheMiddle(newNode);

        assertThat(head.getNextNode()).isEqualTo(newNode);
        assertThat(newNode.getPreviousNode()).isEqualTo(head);
        assertThat(head.getLastNode()).isEqualTo(newNode);
    }

    @Test
    public void testInsertNodeInTheMiddleForDifferentList() {
        DoublyLinkedListExample head = new DoublyLinkedListExample(1);
        DoublyLinkedListExample secondNode = head.insertAfter(1.1);

        DoublyLinkedListExample newNode = new DoublyLinkedListExample(2);
        DoublyLinkedListExample nextNode = newNode.insertAfter(3);

        head.insertNodeInTheMiddle(newNode);

        head.printList();
    }
}