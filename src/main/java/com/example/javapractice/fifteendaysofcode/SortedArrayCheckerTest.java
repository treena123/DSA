package com.example.javapractice.fifteendaysofcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author trinapal
 */
public class SortedArrayCheckerTest {

    @Test
    public void test_unsorted_array(){
        Assert.assertTrue(SortedArrayChecker.isArraySorted2(new int[]{9, 7, 5, 1}));
    }

   // @Test
    /*public void test_unsorted_array_on_stream(){
        Assert.assertTrue(SortedArrayChecker.isArraySortedUsingStream(new int[]{9, 7, 5, 1}));
    }*/
}
