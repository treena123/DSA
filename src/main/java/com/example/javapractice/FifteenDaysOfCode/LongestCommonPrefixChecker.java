package com.example.javapractice.FifteenDaysOfCode;

/**
 * @author trinapal
 */
public class LongestCommonPrefixChecker {

    public static String checkLongestCommonPrefix(String[] inputs) {
        /*
        Solution 1
         */
        if (inputs == null || inputs.length == 0) return "";
        String commonPrefix = inputs[0];

        for (int i = 1; i < inputs.length; i++) {
            while (inputs[i].indexOf(commonPrefix) != 0) {
                commonPrefix = commonPrefix.substring(0, commonPrefix.length() - 1); //check by decrease one letter at a time
            }
        }
        return commonPrefix;
    }

    /*
    Optimize for millions of strings or large inputs.
     */

    public static String checkCommonPrefixForScalableSolution(String[] inputs) {
        if (inputs == null || inputs.length == 0) return "";
        return lcpHelper(inputs, 0, inputs.length - 1);
    }

    private static String lcpHelper(String[] inputs, int low, int high) {
        if (low == high) return inputs[low];
        int mid = low + (high-low)/ 2; // needed this substraction to avoid stack overflow
        String lcpLow = lcpHelper(inputs,low, mid);
        String lcphigh = lcpHelper(inputs, mid+1, high);
        return commonPrefix(lcpLow,lcphigh);
    }

    private static String commonPrefix(String left, String right) {
        int minLength = Math.min(left.length(), right.length());
        for (int i = 0; i < minLength; i++) {
            if (left.charAt(i) != right.charAt(i))
                return left.substring(0, i);
        }
        return left.substring(0, minLength);
    }
}