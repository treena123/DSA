package com.example.javapractice.fifteendaysofcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author trinapal
 */
public class BalancedParenthesisChecker {
    /*
    Check if (), {}, [] are all properly balanced.

Follow-up: Extend to custom bracket types or nesting depth.

     */
    public static boolean validateParenthesis(String input){
        if(input == null || input.length() == 0) return false;
        char [] inputCharArray = input.toCharArray();
        HashMap<Character,Character> parenthesisMapper = new HashMap<>();
        parenthesisMapper.put(')','(');
        parenthesisMapper.put('}','{');
        parenthesisMapper.put(']','[');
        parenthesisMapper.put('>','<');
        parenthesisMapper.put('Z','A');
        Stack<Character>stack = new Stack<>();
        int maxDepth = 0;
        int currentDepth = 0;
        for(char each : inputCharArray){
            if(parenthesisMapper.containsValue(each)){
                stack.push(each);
                currentDepth++;
                maxDepth = Math.max(maxDepth, currentDepth);
            }
            else if(parenthesisMapper.containsKey(each)){
               if(stack.isEmpty() || stack.pop() != parenthesisMapper.get(each)){
                   currentDepth--;
                   return false;
               }
            }
        }
        return stack.empty();
    }
}
