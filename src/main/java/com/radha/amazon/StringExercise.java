package com.radha.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringExercise {
    public char getNonDuplicateChar(String string){
        /*Algorithm
        Step 0: Declare a integer list called positions initialize isDuplicate = false
        Step1: For each character in the string from i=0 to length-1
                1.1: For each character from j = i+1 to length-1
                        1.1.1: If the positions is contain j assign isDuplicate = true then continue
                        1.1.2: Otherwise check if ith character = jth character then add the j value into the positions
                        assign isDuplicate = true then break
                1.2: If isDuplicate = false then return the ith character
                1.3: set isDuplicate = false
         */
        List<Integer> positions = new ArrayList<>();
        boolean isDuplicate = false;
        for(int i = 0; i < string.length(); i++){
            for(int j = i+1; j < string.length(); j++){
                if(positions.contains(i)){
                    isDuplicate = true;
                    break;
                }
                else{
                    if(string.charAt(i) == string.charAt(j)){
                        positions.add(j);
                        isDuplicate = true;
                        break;
                    }

                }

            }
            if(!isDuplicate){
                return string.charAt(i);
            }
            isDuplicate = false;

        }
        return ' ';
    }
    /*i = 0    j=1   positions = []   positions does not contain 1, 't' != 'o' so isDup=false, positions = []
    i = 0    j=2   positions = []   positions does not contain 2, 't' == 't' therefore isDup=true, at end of loop positions = [2] break out of inner loop
    i = 1    j=2   positions = [2] positions does not contains i, o != t  isDuplicate = false
    i = 1    j = 3  positions = [2] both conditions false

     */
    public char getNonDuplicateChar2(String string){
        /*Algorithm O(n)
        Step 0: Declare a map called letters with character and boolean as key value
        Step 1: For each value from i = 0 to string length do
                    1.1: if the ith character is already present in the map then set the value as true in the map
                    1.2: Otherwise set value as false
         Step 2: For each value from ith character to string length
                        2.1: Return the ith character if the value is false
         */
        Map<Character,Boolean> letters = new HashMap<>();
        for(int i = 0; i < string.length(); i++){
            if(letters.containsKey(string.charAt(i))){
                letters.put(string.charAt(i), true);
            }
            else{
                letters.put(string.charAt(i), false);
            }
        }
        for (int i = 0; i < string.length(); i++){
            if(!letters.get(string.charAt(i))){
                return string.charAt(i);
            }
        }
          return ' ';
      }
}
