package codeChallenge;

import java.util.HashMap;

/**
 * @author trinapal
 */
public class LastDigitInWords {
    static HashMap<Integer,String> map = new HashMap<>();
    public static void main(String[] args) {
        convertDigitInWords(23);
    }

    private static String convertDigitInWords(int n) {
        String word = "";
        if(n != 0){ //because only one traversal required
            int target = n%10;
            word=  map.get(target);
        }
        return word;
    }
}
