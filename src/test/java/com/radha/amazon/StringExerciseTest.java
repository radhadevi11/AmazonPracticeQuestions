package com.radha.amazon;

import org.junit.Test;

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
}