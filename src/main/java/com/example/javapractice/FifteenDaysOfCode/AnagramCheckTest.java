package com.example.javapractice.FifteenDaysOfCode;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author trinapal
 */

public class AnagramCheckTest {
    @Test
    public void test_validAnagram(){
        String input1 = "eat";
        String input2 = "ate";
        assertTrue(new AnagramCheck().isAnagram(input1,input2));
    }

    @Test
    public void test_invalidAnagram(){
        String input1 = "eat";
        String input2 = "atc";
        assertFalse(new AnagramCheck().isAnagram(input1,input2));
    }
    @Test
    public void test_null_input(){
        String input1 = "";
        String input2 = "atc";
        assertFalse(new AnagramCheck().isAnagram(input1,input2));
    }

    @Test
    public void test_diff_length_input(){
        String input1 = "atchn";
        String input2 = "atc";
        assertFalse(new AnagramCheck().isAnagram(input1,input2));
    }
}
