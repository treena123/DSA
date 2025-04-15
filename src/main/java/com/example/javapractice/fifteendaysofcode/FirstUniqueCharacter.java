package com.example.javapractice.fifteendaysofcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueCharacter {

    public char firstNonRepeatingChar(String s) {
        if (s == null || s.isEmpty()) return '_'; // handle edge case

        Map<Character, Integer> freq = new LinkedHashMap<>();

        // Count character frequencies in order
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Find first character with frequency 1
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return '_'; // Indicates no non-repeating character
    }
}
