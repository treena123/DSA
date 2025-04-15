package com.example.javapractice.fifteendaysofcode;

import java.util.stream.Collectors;

/**
 * @author trinapal
 */
public class PangramChecker {
    /*A pangram contains every letter of the alphabet at least once.

    Follow-up: Case-insensitive and ignore non-letter characters.
    */
    boolean isPangram(String input) {
        if (input == null) return false;
        /*HashSet<Character> letterMapping = new HashSet<>();
        for(char each: input.toCharArray()){
            if (Character.isLetter(each))
                letterMapping.add(Character.toLowerCase(each));
        }
        //get the total key number
        return  letterMapping.size() == 26;

    } */
        // streaming version
        return input.chars().mapToObj(c -> (char) c).
                filter(Character::isLetter).map(Character::toLowerCase).collect(Collectors.toSet()).size() == 26;

    }
}