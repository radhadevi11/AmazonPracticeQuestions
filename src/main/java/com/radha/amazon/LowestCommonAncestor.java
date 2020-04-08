package com.radha.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LowestCommonAncestor {
    List<Integer> getListOfAncestors(int value, TreeNode node) {
        /*
        Step 0: create a list called ancestors
        Step 1: if node's value is equal to value
                    return ancestors
        Step 2: Otherwise
                    2.1: add node's value to the ancestors
                    2.2: if value is less than  node's value
                            2.2.1: getListOfAncestors(leftChild)
                            2.2.2: add the result to ancestors
                    2.3: Otherwise
                            2.3.1: getListOfAncestors(rightChild)
                            2.3.2: add the result to ancestors
        Step 3: Return ancestors

         */

        List<Integer> ancestors = new ArrayList<>();
        int curNodeValue = node.getValue();
        if(curNodeValue == value) {
            return ancestors;
        }
        else {
            ancestors.add(curNodeValue);
            if(value < curNodeValue) {
                List<Integer> ancestorsSoFar = getListOfAncestors(value, node.getLeftChild());
                ancestors.addAll(ancestorsSoFar);
            }
            else {
                List<Integer> ancestorsSoFar = getListOfAncestors(value, node.getRightChild());
                ancestors.addAll(ancestorsSoFar);
            }
        }
        return ancestors;
    }

    Map<Integer, Integer> convertListToMap(List<Integer> ancestors) {
        Map<Integer, Integer> ancestorsMap = new HashMap<>();

        for(int ancestor : ancestors) {
            ancestorsMap.put(ancestor, ancestor);
        }

        return ancestorsMap;
    }

    int findLowestCommonAncestorValue(Map<Integer, Integer> ancestorsMap, List<Integer> ancestors) {
        /*
        Step 0: set ancestorsSoFar to 0
        Step 1: For each ancestor in the ancestors
                    1.1: if ancestor present in the ancestorsMap
                            1.1.1: assign ancestorSoFar as ancestor
        Step 2: Return ancestorsSoFar
         */
        int ancestorsSoFar = 0;

        for (int ancestor : ancestors) {
            if(ancestorsMap.containsKey(ancestor)) {
                ancestorsSoFar = ancestor;
            }
        }
        return ancestorsSoFar;
    }

    int getLowestCommonAncestorValue (int value1, int value2, TreeNode root) {
        List<Integer> ancestorsOfValue1 = getListOfAncestors(value1, root);
        List<Integer> ancestorsOfValue2 = getListOfAncestors(value2, root);

        if(ancestorsOfValue1.isEmpty() || ancestorsOfValue2.isEmpty()) {
            throw new IllegalArgumentException("Can not find ancestors for root");
        }

        Map<Integer, Integer> ancestorsMap = convertListToMap(ancestorsOfValue1);

        return findLowestCommonAncestorValue(ancestorsMap, ancestorsOfValue2);

    }
}
