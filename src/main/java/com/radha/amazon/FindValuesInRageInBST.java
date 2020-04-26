package com.radha.amazon;

import java.util.ArrayList;
import java.util.List;

public class FindValuesInRageInBST {
    /*
    Step 0: create resultList
     Step 1: if root has left child
                    1.1: add the result of  getListOfRange into resultList
     Step 2: IsRootInRange
                    2.1: add root in the resultList
     Step 3: if root has right child
                    1.1: add the result of  getListOfRange into resultList
     Step 4: return resultList

     */

    List<Integer> getListOfRange(int low, int high, TreeNode root) {
        List<Integer> resultList = new ArrayList<>();

        if(root.getLeftChild() != null) {
            resultList.addAll(getListOfRange(low, high, root.getLeftChild()));
        }

        if(isRootInRange(low, high, root.getValue())) {
            resultList.add(root.getValue());
        }

        if(root.getRightChild() != null) {
            resultList.addAll(getListOfRange(low, high, root.getRightChild()));
        }

        return resultList;
    }

     boolean isRootInRange(int low, int high, int value) {
        return value >= low && value <= high;
    }
}
