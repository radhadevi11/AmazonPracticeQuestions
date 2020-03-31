package com.radha.amazon;

public class ListFattening extends DoublyLinkedListExample {

    private DoublyLinkedListExample childNode;

    public ListFattening(Object value) {
        super(value);
    }

    public void setChildNode(DoublyLinkedListExample childNode) {
        this.childNode = childNode;
    }

    public DoublyLinkedListExample getChildNode() {
        return this.childNode;
    }


    DoublyLinkedListExample insertListBetweenTwoNodes(DoublyLinkedListExample fromNode, DoublyLinkedListExample toNode,
                                                      DoublyLinkedListExample headOfList){
        /*
        Step 1: set lastNode = getLastNode of headOfList
        Step 2: set fromNode's nextNode as headOfList
        Step 3: set headOfList's previousNode as fromNode
        Step 4: set lastNode's nextNode as toNode
        Step 5: set toNode's previousNode as lastNode
         */
        DoublyLinkedListExample linkedList = fromNode;

        DoublyLinkedListExample lastNode = getLastNode(headOfList);
        fromNode.setNextNode(headOfList);
        headOfList.setPreviousNode(fromNode);
        lastNode.setNextNode(toNode);
        toNode.setPreviousNode(lastNode);

        return linkedList;

    }

    DoublyLinkedListExample insertListLast(DoublyLinkedListExample fromNode, DoublyLinkedListExample headOfList){
        /*
        Step 2: set fromNode's nextNode as headOfList
        Step 3: set headOfList's previousNode as fromNode

         */
        DoublyLinkedListExample linkedList = fromNode;

        fromNode.setNextNode(headOfList);
        headOfList.setPreviousNode(fromNode);

        return linkedList;

    }

    DoublyLinkedListExample getLastNode(DoublyLinkedListExample head){
        /*
        Step 1: for each node in the list
                    1.1: if the node's nextNode is null
                            1.1.1: return the node
         */
        DoublyLinkedListExample temp = head;
        while (temp != null){
            if(temp.getNextNode() == null){
                return temp;
            }
            temp = temp.getNextNode();
        }
        return temp;
    }

    DoublyLinkedListExample getHeadOfFlattenList(DoublyLinkedListExample node){
        /*
        Step 0: If node is tail
                    0.1: set headOfList to getHeadOfFlattenList(child)
                    0.2: return insertListLast(node, headOfList)
        Step 1: If the node has no child and node has no nextNode
                    return node
        Step 2: If the node has no child
                    2.1: set headOfList = getHeadOfFlattenList(nextNode)
                    2.2: if headOfList has one node
                            2.2.1: return node
                    2.3: otherwise return insertListBetweenTwoNodes(node, headOfList)
        Step 4: Otherwise
                    4.1: set headOfList to getHeadOfFlattenList(child)
                    4.2: return insertListBetweenTwoNodes(node, nextNode, headOfList)

         */
        return null;
    }

    DoublyLinkedListExample process(ListFattening head, ListFattening tail){
        /*
        Look a node
            create a resultList
            if we can't flatten the node
                insert it at the end of the resultList
            Otherwise
                insert it at the end of the resultList
                process child
                insert the result of process child to the resultList

           if node is not tail and nextNode not null
                process nextNode
                insert the result of process nextNode to the resultList

return resultList

         */

        DoublyLinkedListExample resultList = new ListFattening(head.getValue());

        if(! hasChild()){
            insertNodeInTheResultList(head, resultList);
        }
        if(hasChild()){
            processChildNode(head, tail, resultList);
        }
        if(! isLastNode(tail)){
            processNextNode(head, tail, resultList);
        }

        return resultList;
    }

     boolean isLastNode( DoublyLinkedListExample tail) {
        return this.equals(tail) && this.getNextNode() == null;
    }

     boolean hasChild() {
        return this.getChildNode() != null;
    }

     void processNextNode(ListFattening head, ListFattening tail, DoublyLinkedListExample resultList) {
        DoublyLinkedListExample nextNode = process((ListFattening)head.getNextNode(), tail);
        insertNodeInTheResultList((ListFattening)nextNode, resultList);
    }

     void processChildNode(ListFattening head, ListFattening tail, DoublyLinkedListExample resultList) {
        processNextNode(head, tail, resultList);
    }

     void insertNodeInTheResultList(ListFattening head, DoublyLinkedListExample resultList) {
        resultList.insertNodeInTheMiddle(head);
    }
}
