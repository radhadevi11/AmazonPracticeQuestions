package com.radha.amazon;

import org.junit.Test;
import org.assertj.core.api.Assertions;

import java.util.Optional;

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

        Assertions.assertThat(head.search(7)).isPresent().isEqualTo(expected);

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



        Assertions.assertThat(head.search(10)).isEmpty();

    }

    @Test
    public void remove() {
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

        Assertions.assertThat(head.remove(6)).isPresent().isEqualTo(expected);

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

        Assertions.assertThat(head.remove(7)).isPresent().isEqualTo(expected);

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

        Assertions.assertThat(head.remove(5)).isPresent().isEqualTo(expected);

    }
    @Test
    public void removeSingleNode() {
        DoublyLinkedListExample head = new DoublyLinkedListExample(5);


        DoublyLinkedListExample remove = new DoublyLinkedListExample(5);//why I did not get null pointer exception?
        Optional<DoublyLinkedListExample> expected = Optional.of(remove);

        Assertions.assertThat(head.remove(5)).isPresent().isEqualTo(expected);

    }


    @Test
    public void removeForNotAvailableValue() {
        DoublyLinkedListExample head = new DoublyLinkedListExample(5);
        DoublyLinkedListExample secondNode = new DoublyLinkedListExample(6);
        DoublyLinkedListExample thirdNode = new DoublyLinkedListExample(7);
        head.setNextNode(secondNode);
        secondNode.setNextNode(thirdNode);


        Assertions.assertThat(head.remove(10)).isEmpty();

    }


    @Test
    public void insertAfter() {
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


        Assertions.assertThat(secondNode.insertAfter(8)).isEqualTo(expected);

    }

    @Test
    public void insertAfterInTheLast() {
        DoublyLinkedListExample head = new DoublyLinkedListExample(5);


        DoublyLinkedListExample expected = new DoublyLinkedListExample(8);
        expected.setPreviousNode(head);

        Assertions.assertThat(head.insertAfter(8)).isEqualTo(expected);

    }

}