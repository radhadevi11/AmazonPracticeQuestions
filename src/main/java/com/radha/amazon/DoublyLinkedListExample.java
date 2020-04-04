 package com.radha.amazon;

import java.util.Objects;
import java.util.Optional;

public class DoublyLinkedListExample {

    private Object value;
    private  DoublyLinkedListExample previousNode;
    private DoublyLinkedListExample nextNode;

    public DoublyLinkedListExample(Object value) {
        this.value = value;
    }

    public void setPreviousNode(DoublyLinkedListExample previousNode) {
        this.previousNode = previousNode;
    }

    public DoublyLinkedListExample getPreviousNode() {
        return previousNode;
    }

    public void setNextNode(DoublyLinkedListExample nextNode) {
        this.nextNode = nextNode;
    }

    public DoublyLinkedListExample getNextNode() {
        return nextNode;
    }

    public Object getValue() {
        return value;
    }


    public Optional<DoublyLinkedListExample> search(Object value){

        DoublyLinkedListExample list = this;

        while (list != null){
            if(list.value == value){
                return Optional.of(list);
            }
            else{
                list.previousNode = list;
                list = list.nextNode;
            }
        }

        return Optional.empty();
    }
    public Optional<DoublyLinkedListExample>remove(Object value) {
        DoublyLinkedListExample list = this;

        while (list != null){

            if(list.nextNode == null && list.value == value){
                return Optional.of(list);
            }

            else if(list.previousNode == null && list.value == value){
                return Optional.of(list);
            }

            else if(list.value == value){
                return removeInTheMiddle(list);
            }

            else{
                list = list.nextNode;
            }
        }
        return Optional.empty();

    }

    private Optional<DoublyLinkedListExample> removeInTheMiddle(DoublyLinkedListExample list) {
        list.previousNode.nextNode = list.nextNode;
        list.nextNode.previousNode = list.previousNode;
        return Optional.of(list);
    }
    public DoublyLinkedListExample insertAfter(DoublyLinkedListExample newNode) {
        if(this.nextNode == null){
            this.nextNode = newNode;
            newNode.previousNode = this;
        }
        else{
            InsertInTheMiddle(newNode);
        }
        return newNode;
    }

    public DoublyLinkedListExample insertAfter(Object value){
        DoublyLinkedListExample newNode = new DoublyLinkedListExample(value);
        return insertAfter(newNode);
    }

    private void InsertInTheMiddle(DoublyLinkedListExample newNode) {
        newNode.nextNode = this.nextNode;
        this.nextNode.previousNode = newNode;
        newNode.previousNode = this;
        this.nextNode = newNode;
    }

    public void insertNodeInTheMiddle(DoublyLinkedListExample newNode){
        DoublyLinkedListExample lastNode = newNode.getLastNode();
        if(this.nextNode == null){
            this.nextNode = newNode;
            newNode.previousNode = this;
        }
        else {
            newNode.previousNode = this;
            lastNode.nextNode = this.nextNode;
            this.nextNode.previousNode = lastNode;
            this.nextNode = newNode;
        }


    }

    DoublyLinkedListExample getLastNode(){
        /*
        Step 1: for each node in the list
                    1.1: if the node's nextNode is null
                            1.1.1: return the node
         */
        DoublyLinkedListExample temp = this;
        while (temp != null){
            if(temp.getNextNode() == null){
                return temp;
            }
            temp = temp.getNextNode();
        }
        return temp;
    }

    public boolean isLastNode( DoublyLinkedListExample tail) {
        return this.equals(tail) && this.getNextNode() == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoublyLinkedListExample that = (DoublyLinkedListExample) o;
        return Objects.equals(value, that.value) &&
                Objects.equals(previousNode, that.previousNode) &&
                Objects.equals(nextNode, that.nextNode);
    }

    @Override
    public String toString() {
        return "DoublyLinkedListExample{" +
                "value=" + value +
                '}';
    }
}
