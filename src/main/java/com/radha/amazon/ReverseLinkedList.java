package com.radha.amazon;

public class ReverseLinkedList {
    LinkedListExample reverseList(LinkedListExample node){
        /*
        Step 1: if hasNextNode
                    1.1: set resultList = reverseList(nextNode)
                    1.2: insertLast the node into the resultList
                    1.3: return resultList
        Step 2: Otherwise
                    return node
         */
        System.out.println("Processing Node with value = "+node.getValue());
        if(hasNextNode(node)){
            System.out.println("Processing Next Node with value = "+node.getNextNode().getValue());
            LinkedListExample resultList = reverseList(node.getNextNode());
            resultList.insertLast(node);
            System.out.println("====================");
            return resultList;
        }
        System.out.println("Processing tail Node with value = "+node.getValue());
        return node;
    }

    private boolean hasNextNode(LinkedListExample node) {
        return node.getNextNode() != null;
    }
}
