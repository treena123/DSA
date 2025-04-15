package com.example.javapractice.fifteendaysofcode;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author trinapal
 */
public class BalancedParenthesisCheckerTest {

    @Test
    public void test_valid_parenthesis(){
        assertTrue(BalancedParenthesisChecker.validateParenthesis("[{}]()"));
    }
}
