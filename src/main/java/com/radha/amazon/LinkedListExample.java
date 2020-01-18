package com.radha.amazon;


import java.util.LinkedList;
import java.util.Objects;
import java.util.Optional;

public class LinkedListExample {
  private Object value;
  private LinkedListExample nextNode;


    public LinkedListExample(Object value) {
        this.value = value;
    }

    public void setNextNode(LinkedListExample nextNode) {
        this.nextNode = nextNode;
    }

    public LinkedListExample getNextNode() {
        return nextNode;
    }

    public Optional<LinkedListExample> search(Object value){

        LinkedListExample list = this;

        while(list != null){

            if(value == list.value){
                return Optional.of(list);
            }

            else{
               list = list.nextNode;
            }
        }
        return Optional.empty();
    }
    public Optional<LinkedListExample> remove(Object value){
       /*
       step 1: set this node's previous node's next = this.next

        */
        LinkedListExample currentList = this;
        LinkedListExample previousList = this;

        while(currentList != null){

            if(value == currentList.value){
                previousList.nextNode = currentList.nextNode;
                currentList.nextNode = null;
                return Optional.of(currentList);
            }

            else{
                previousList = currentList;
                currentList = currentList.nextNode;
            }
        }
        return Optional.empty();

    }
    /*
    insertAfter
        insert the given value as a node after this node

     */
    public  LinkedListExample insertAfter(Object value){
        LinkedListExample newNode = new LinkedListExample(value);
        newNode.nextNode = this.nextNode;
        this.nextNode = newNode;
        return newNode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedListExample that = (LinkedListExample) o;
        return Objects.equals(value, that.value) &&
                Objects.equals(nextNode, that.nextNode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, nextNode);
    }
}
