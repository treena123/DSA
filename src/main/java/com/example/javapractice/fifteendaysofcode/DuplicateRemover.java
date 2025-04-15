package com.example.javapractice.fifteendaysofcode;

import java.util.*;

public class DuplicateRemover {
    public int[] removeDuplicates(int[] arr) {
        Set<Integer> distinctSet = new LinkedHashSet<>(); // maintains order, use HashSet if order doesn't matter
        for (int num : arr) {
            distinctSet.add(num);
        }
        // Convert Set<Integer> to int[]
        return distinctSet.stream().mapToInt(Integer::intValue).toArray();
    }
}
