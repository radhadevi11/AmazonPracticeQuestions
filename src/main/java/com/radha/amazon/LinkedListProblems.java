package com.radha.amazon;

import java.util.ArrayList;
import java.util.List;

public class LinkedListProblems {
    public LinkedListExample mthToLastElement(LinkedListExample head, int m){
        /*
        Step 1: Declare a List of LinkedListExample called extraList and currentList = head
        Step 2: For each node from head
                2.1: add the node into the extraList
                2.2: If you process all the node then return extraList.size() - m -1 th element from the extraList
         */
        List<LinkedListExample> extraList = new ArrayList<>();
        LinkedListExample currentList = head;
        while(currentList != null){
            extraList.add(currentList);
            currentList = currentList.getNextNode();

        }
        if(m < extraList.size()){
            return extraList.get(extraList.size() - m - 1);
        }
        else{
            return null;
        }

    }
    public LinkedListExample mthToLastElementSpaceEfficient(LinkedListExample head, int m){
        /*
        Step 1: Initialize a variable cur = 1, declare a variable mthToLast and currentList
        Step 2: For each node from head
                2.1: If cur = m+1 then set mthToLast = head
                2.2: Otherwise if cur > m+1 then set mthToLast = mthToLast's next and currentList = currentLiist.next
                2.4: otherwise set currentList = currentLiist.next
                2.5: increment cur by 1
       Step 3: return mthToLast

         */
        /*
        cur = 7
        mthToLast = node5
        currentList = null
        m = 2
         */
        int cur = 1;
        LinkedListExample mthToLast = null ,currentList = head;
        while ((currentList.getNextNode() != null)){
            System.out.println("cur="+cur);
            System.out.println("mthToLast:"+mthToLast);
            System.out.println("currentList:"+currentList);
            if(cur == m+1){ // 5 == 3
                mthToLast = head;
                System.out.println("cur == m+1");
            }
            else if(cur > m+1){// 6 > 3
                mthToLast = mthToLast.getNextNode();
                currentList = currentList.getNextNode();
                System.out.println("cur > m+1");

            }
            else{
                currentList = currentList.getNextNode();
                System.out.println("Else block : ");
            }
            cur++;
            System.out.println("cur="+cur);
            System.out.println("mthToLast:"+mthToLast);
            System.out.println("currentList:"+currentList);
            System.out.println("======");
        }
        return mthToLast;

    }



}
