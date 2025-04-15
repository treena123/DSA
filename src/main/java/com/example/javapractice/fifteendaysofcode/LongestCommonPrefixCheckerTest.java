package com.example.javapractice.fifteendaysofcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author trinapal
 */

public class LongestCommonPrefixCheckerTest {

    @Test
    public void test_valid_String_array() {
        String[] input = {"flower", "floyd", "flow"};
        String expected = "flo";
        assertEquals(expected, LongestCommonPrefixChecker.checkLongestCommonPrefix(input));
    }

    @Test
    public void test_valid_String_large_array() {
        String[] input = {"interspecies", "interstellar", "interstate"}; // Expected: "inters"

        String expected = "inters";
        assertEquals(expected, LongestCommonPrefixChecker.checkCommonPrefixForScalableSolution(input));
    }
}