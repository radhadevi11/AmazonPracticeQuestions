package com.radha.amazon;

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
}