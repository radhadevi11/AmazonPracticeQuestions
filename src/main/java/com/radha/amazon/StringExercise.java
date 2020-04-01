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

    public String removeSpecifiedCharacter(String sentence, String lettersToBeRemove){
        /*
        Step 0: convert lettersToBeRemove as map and set resultString as empty
        Step 1: For each character in the sentence
                    1.1: if map not contains the character
                            1.1.1: concat the character with resultString
        Step 2: return resultString

         */
          Map<Character, Character> characterMap = convertStringToMap(lettersToBeRemove);
          String resultString = "";
          for(int i = 0; i < sentence.length(); i++){
              char curChar = sentence.charAt(i);
              if(!characterMap.containsKey(curChar)){
                  resultString += curChar;
              }
          }
          return resultString;

    }

    Map<Character, Character> convertStringToMap(String str){
        Map<Character, Character> characterMap = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            characterMap.put(str.charAt(i), str.charAt(i));
        }
        return characterMap;
    }

    public String reverseWords(String sentence){
        /*
        Step 0: set reverseString to empty
        Step 1: Split each word in the sentence and store it in the stringArray
        Step 2: For each word in the stringArray from last to first
                    2.1 : concat the word with reverseString
        Step 3: return reverseString
         */
        String reverseString = "";
        String[] stringArray = sentence.split(" ");
        for(int i = stringArray.length-1; i >= 0; i--){
            if(isFirstWord(i)){
                reverseString = concatWord(reverseString, stringArray, i, "");
            }else{
                reverseString = concatWord(reverseString, stringArray, i, " ");
            }

        }
        return reverseString;
    }

    private String concatWord(String reverseString, String[] stringArray, int i, String delimiter) {
        reverseString += stringArray[i]+delimiter;
        return reverseString;
    }

    boolean isFirstWord(int i){
        return i == 0;
    }

    public int ConvertStingToInt(String str){
        try{
            int num = Integer.parseInt(str);
            return num;
        }catch (NumberFormatException e){
            throw new RuntimeException("Out of range", e);
        }

    }

    public String convertIntToString(int num){

            return new Integer(num).toString();

    }
}
