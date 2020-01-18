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

    public void setNextNode(DoublyLinkedListExample nextNode) {
        this.nextNode = nextNode;
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

    public DoublyLinkedListExample insertAfter(Object value){
        DoublyLinkedListExample newNode = new DoublyLinkedListExample(value);

        if(this.nextNode == null){
            this.nextNode = newNode;
            newNode.previousNode = this;
        }

        InsertInTheMiddle(newNode);

        return newNode;
    }

    private void InsertInTheMiddle(DoublyLinkedListExample newNode) {
        newNode.nextNode = this.nextNode;
        this.nextNode.previousNode = newNode;
        newNode.previousNode = this;
        this.nextNode = newNode;
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


}
