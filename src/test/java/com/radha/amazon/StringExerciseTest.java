package com.radha.amazon;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringExerciseTest {
    @Test
    public void testGetNonDuplicateChar() {
        StringExercise stringExercise = new StringExercise();
        char actual = stringExercise.getNonDuplicateChar("total");
        assertEquals('o',actual);
    }
    @Test
    public void testGetNonDuplicateChar2() {
        StringExercise stringExercise = new StringExercise();
        char actual = stringExercise.getNonDuplicateChar("ababc");
        System.out.println("actual = "+actual);
        assertEquals('c',actual);
    }
}