package com.example.javapractice.FifteenDaysOfCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author trinapal
 */
public class DuplicateInArrayChecker {

    public static List<Integer> findAllDuplicates(int[] arr) {
        /*
        Solution 1
         */

        HashMap<Integer, Integer> countNumAppearence = new HashMap<>();
        for (int num : arr)
            countNumAppearence.put(num, countNumAppearence.getOrDefault(num, 0) + 1);
        return countNumAppearence.entrySet().stream().filter(each -> each.getValue() > 1)
                .map(Map.Entry::getKey).toList();
    }

    /*
    Solution 2 - index based - constant space
     */
    public static List<Integer> findAllDuplicatesConstantSpace(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;

            if (nums[index] < 0) {
                result.add(Math.abs(nums[i])); // already seen
            } else {
                nums[index] = -nums[index]; // mark as seen
            }
        }

        return result;
    }


    /*
    Solution 3- sorting
     */
    public static List<Integer> findDuplicatesSorted(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] && (result.isEmpty() || result.get(result.size() - 1) != nums[i])) {
                result.add(nums[i]);
            }
        }

        return result;
    }

}
/*
Approach	        Time Complexity	Space Complexity	    Notes
HashMap	                O(n)	        O(n)	            Easiest and clean
Sorting	                O(n log n)	    O(1) (in-place)	    Avoids extra memory, modifies array
Index marking(O(1))	    O(n)	        O(1)	            Only if values in [1, n]
 */