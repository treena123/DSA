package com.example.javapractice.FifteenDaysOfCode;

/**
 * @author trinapal
 */
public class PalindromeChecker {
    public boolean isPalindrome(String s) {
        if (s == null) return false;

        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;

        while (left < right) {
            // Skip non-alphanumeric characters from the left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // Skip non-alphanumeric characters from the right
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

}
