package com.example.javapractice.fifteendaysofcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author trinapal
 */
public class WordCapitalizerCheckerTest {

    @Test
    public void test_valid_word_capitalizer(){
        String sentence = "She's              is        efficient";
        String expected = "She's Is Efficient";
        assertEquals(expected,WordCapitalizerChecker.fixSentenceByWordCapitalization(sentence));
    }
}
