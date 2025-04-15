package com.example.javapractice.fifteendaysofcode;
import java.util.HashMap;
import java.util.Map;
/**
 * @author trinapal
 */
public class AnagramCheck {

 public boolean isAnagram(String s1, String s2) {
            if (s1 == null || s2 == null || s1.length() != s2.length()) return false;

            Map<Character, Integer> map = new HashMap<>();

            for (char c : s1.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            for (char c : s2.toCharArray()) {
                if (!map.containsKey(c)) {
                    return false;
                }
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    map.remove(c);
                }
            }

            return map.isEmpty();
        }
    }


