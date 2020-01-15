package com.radha.amazon;

import java.util.ArrayList;
import java.util.List;

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
                if(positions.contains(j)){
                    isDuplicate = true;
                    continue;
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
}
