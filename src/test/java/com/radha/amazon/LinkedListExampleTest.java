package com.radha.amazon;

import org.junit.Test;
import org.assertj.core.api.Assertions;

import java.util.Optional;

import static org.junit.Assert.*;

public class LinkedListExampleTest {

    @Test
    public void search() {
        LinkedListExample head = new LinkedListExample(5);
        LinkedListExample secondNode = new LinkedListExample(6);
        LinkedListExample thirdNode = new LinkedListExample(7);
        head.setNextNode(secondNode);
        secondNode.setNextNode(thirdNode);


        Optional<LinkedListExample> expected = Optional.of(secondNode);

        Assertions.assertThat(head.search(6)).isPresent().isEqualTo(expected);

    }


    @Test
    public void searchForNotAvailableValue() {
        LinkedListExample head = new LinkedListExample(5);
        LinkedListExample secondNode = new LinkedListExample(6);
        LinkedListExample thirdNode = new LinkedListExample(7);
        head.setNextNode(secondNode);
        secondNode.setNextNode(thirdNode);


        Assertions.assertThat(head.search(10)).isEmpty();

    }

    @Test
    public void remove() {
        LinkedListExample head = new LinkedListExample(5);
        LinkedListExample secondNode = new LinkedListExample(6);
        LinkedListExample thirdNode = new LinkedListExample(7);
        head.setNextNode(secondNode);
        secondNode.setNextNode(thirdNode);

        Assertions.assertThat(head.remove(6)).isPresent().isEqualTo(Optional.of(secondNode));
        Assertions.assertThat(secondNode.getNextNode()).isNull();

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

        Assertions.assertThat(head.remove(7)).isPresent().isEqualTo(expected);

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

        Assertions.assertThat(head.remove(5)).isPresent().isEqualTo(expected);

    }
    @Test
    public void removeSingleNode() {
        LinkedListExample head = new LinkedListExample(5);


        LinkedListExample remove = new LinkedListExample(5);//why I did not got null pointer exception?
        Optional<LinkedListExample> expected = Optional.of(remove);

        Assertions.assertThat(head.remove(5)).isPresent().isEqualTo(expected);

    }


    @Test
    public void removeForNotAvailableValue() {
        LinkedListExample head = new LinkedListExample(5);
        LinkedListExample secondNode = new LinkedListExample(6);
        LinkedListExample thirdNode = new LinkedListExample(7);
        head.setNextNode(secondNode);
        secondNode.setNextNode(thirdNode);


        Assertions.assertThat(head.remove(10)).isEmpty();

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


        Assertions.assertThat(secondNode.insertAfter(8)).isEqualTo(expected);

    }

    @Test
    public void insertAfterInTheLast() {
        LinkedListExample head = new LinkedListExample(5);


        LinkedListExample expected = new LinkedListExample(8);

        Assertions.assertThat(head.insertAfter(8)).isEqualTo(expected);

    }
}