package com.example.javapractice.fifteendaysofcode;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author trinapal
 */
public class TestDuplicateArrayChecker {

    @Test
    public void test_valid_Duplicate_array(){
        int [] input = {45,7,3,45,98,5,93,45,7,3};
        //indexed basesd applies when range is from 1  to n
        List<Integer> expectedList = new ArrayList<>();
        expectedList.add(3);
        expectedList.add(5);
       // expectedList.add(45);
        //assertEquals(expectedList, DuplicateInArrayChecker.findDuplicatesSorted(input));
        assertEquals(expectedList, DuplicateInArrayChecker.findAllDuplicatesConstantSpace(new int [] {3,5,1,4,3,5}));
    }
}
