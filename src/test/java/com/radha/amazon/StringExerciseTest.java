package com.radha.amazon;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

public class StringExerciseTest {
    @Test
    public void testGetNonDuplicateChar() {
        StringExercise stringExercise = new StringExercise();
        char actual = stringExercise.getNonDuplicateChar("total");
        System.out.println("actual = "+actual);
        assertEquals('o',actual);
    }
    @Test
    public void testGetNonDuplicateChar2() {
        StringExercise stringExercise = new StringExercise();
        char actual = stringExercise.getNonDuplicateChar2("total");
        System.out.println("actual = "+actual);
        assertEquals('o',actual);
    }
    @Test
    public void testGetNonDuplicateChar3() {
        StringExercise stringExercise = new StringExercise();
        char actual = stringExercise.getNonDuplicateChar2("teeter");
        System.out.println("actual = "+actual);
        assertEquals('r',actual);
    }

    @Test
    public void testConvertStringToMap(){
        StringExercise stringExercise = new StringExercise();
        String str = "aeiou";

        Map<Character, Character> actual = stringExercise.convertStringToMap(str);

        assertThat(actual.size()).isEqualTo(5);


    }

    @Test
    public void testRemoveSpecifiedCharacter(){
        StringExercise stringExercise = new StringExercise();

        String actual = stringExercise.removeSpecifiedCharacter("Battle of the Vowels: Hawaii vs. Grozny", "aeiou");

        assertThat(actual).isEqualTo("Bttl f th Vwls: Hw vs. Grzny");
    }

    @Test
    public void testReverseString(){
        StringExercise stringExercise = new StringExercise();

        String actual = stringExercise.reverseWords("Do or do not, there is no try");

        assertThat(actual).isEqualTo("try no is there not, do or Do");
    }

    @Test
    public void testConvertIntToString(){
        StringExercise stringExercise = new StringExercise();;

        assertThat(stringExercise.ConvertStingToInt("230")).isEqualTo(230);
    }

    @Test
    public void testConvertIntToStringOutOfRange(){
        StringExercise stringExercise = new StringExercise();;

        assertThatThrownBy (()-> stringExercise.ConvertStingToInt("2147483657"))
                .isInstanceOf( RuntimeException.class)
                .hasMessage("Out of range");
    }


    @Test
    public void testConvertNegativeIntToString(){
        StringExercise stringExercise = new StringExercise();;

        assertThat(stringExercise.ConvertStingToInt("-230")).isEqualTo(-230);
    }

    @Test
    public void testConvertStringToInt(){
        StringExercise stringExercise = new StringExercise();

        assertThat(stringExercise.convertIntToString(855)).isEqualTo("855");
    }

}