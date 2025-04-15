package com.example.javapractice.fifteendaysofcode;

import java.util.Arrays;

/**
 * @author trinapal
 */
public class SortedArrayChecker {

    public static boolean isArraySorted(int[] nums){
        int start =0; int end = nums.length-1;
        if(nums.length <2) return true;
        while(start < end){
            //int mid = start +(end-start)/2;
            if(nums[start] != nums[end] || nums[start] < nums[end]){
                start++;
                end--;
            }else{
                return  false;
            }

        }
        return true;
    }

    public static boolean isArraySorted1(int[] nums) {
        if (nums == null || nums.length < 2) return true;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) return false;
        }
        return true;
    }
    public static boolean isArraySorted2(int[] nums) {
        if (nums == null || nums.length < 2) return true;

        boolean isAscending = nums[0] <= nums[nums.length - 1];

        for (int i = 1; i < nums.length; i++) {
            if (isAscending && nums[i] < nums[i - 1]) return false;
            if (!isAscending && nums[i] > nums[i - 1]) return false;
        }
        return true;
    }

    //public static boolean isArraySortedUsingStream(int[] nums) {
        /*
        What’s the problem?
Arrays can be indexed — streams can't.

Streams might be infinite — can't fully traverse.

No direct way to compare "previous" and "current" elements unless we remember state.


         */
        //Arrays.stream(nums).forEach(num -> num);
   // }
}
