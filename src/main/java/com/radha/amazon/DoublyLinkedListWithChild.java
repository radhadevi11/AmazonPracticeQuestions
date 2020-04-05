package com.radha.amazon;

import java.util.Objects;

public class DoublyLinkedListWithChild extends DoublyLinkedListExample {

    private DoublyLinkedListWithChild childNode;

    public DoublyLinkedListWithChild(Object value) {
        super(value);
    }

    public DoublyLinkedListWithChild getChildNode() {
        return childNode;
    }

    public void setChildNode(DoublyLinkedListWithChild childNode) {
        this.childNode = childNode;
    }

    boolean hasChild() {
        return this.getChildNode() != null;
    }

   /* public DoublyLinkedListWithChild insertAfter(Object value){
        return (DoublyLinkedListWithChild)super.insertAfter(value);
    }*/

    public DoublyLinkedListExample insertAfter(DoublyLinkedListWithChild newNode) {
        return super.insertAfter(newNode);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DoublyLinkedListWithChild)) return false;
        if (!super.equals(o)) return false;
        DoublyLinkedListWithChild that = (DoublyLinkedListWithChild) o;
        return getChildNode().equals(that.getChildNode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getChildNode());
    }
}
