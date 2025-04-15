package com.example.javapractice.fifteendaysofcode;

/**
 * @author trinapal
 */
public class WordCapitalizerChecker {
    /*Given a sentence, capitalize the first letter of each word.
    Follow-up: Handle tabs, multiple spaces, or punctuation.
*/

    public static String fixSentenceByWordCapitalization(String sentence){
       /* if (sentence == null || sentence.isEmpty()) return sentence;
        String [] words = sentence.trim().split("\\s+");
        StringBuilder fixedSentence = new StringBuilder();
        for(String word : words) {
            fixedSentence.append(word.substring(0, 1).toUpperCase() + word.substring(1));
            fixedSentence.append(" ");
        }
        //return String.valueOf(Arrays.stream(words).map(each -> String.valueOf(each.charAt(0)).toUpperCase()).toArray());
        return  fixedSentence.substring(0,fixedSentence.length()-1);

        */
        if (sentence == null || sentence.isEmpty()) return sentence;
        String [] words = sentence.trim().split("\\s+");
        StringBuilder fixedSentence = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                fixedSentence.append(Character.toUpperCase(word.charAt(0)));
                if (word.length() > 1) {
                    fixedSentence.append(word.substring(1));
                }
                fixedSentence.append(" ");
            }
        }

        return fixedSentence.toString().trim(); // Removes final space
    }
}
