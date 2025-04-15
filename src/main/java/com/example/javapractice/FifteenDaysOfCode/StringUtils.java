package com.example.javapractice.FifteenDaysOfCode;

/**
 * Utility class for String operations.
 */
public class StringUtils {

    /**
     * Reverses the given string.
     *
     * @param input the input string
     * @return the reversed string, or the original input if it's null or empty
     */
    public static String reverse(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        StringBuilder reversed = new StringBuilder(input.length());
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed.append(input.charAt(i));
        }
        return reversed.toString();
    }
}
