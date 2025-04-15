package com.example.javapractice.fifteendaysofcode;

/**
 * @author trinapal
 */
public class AmstrongNumberChecker {
/*Return true if a number is an Armstrong number (e.g. 153 = 1³ + 5³ + 3³).

Follow-up: Optimize for large numbers or add general power-n support.
*/
    public boolean isAmstrongNumber(int input){
        int tempInput = input;
        int sum = 0;
        int numDigits = String.valueOf(input).length(); // dynamic power

        /*
        precompute power
         */
        int [] power = new int[10];
        for(int i =0; i<=9; i++){
            power[i] = (int) Math.pow(i, numDigits);
        }
        while(input != 0){
            //sum+= Math.pow(input%10, numDigits); // expensive operation
            sum+= power[input];
            input /= 10;
        }
        return sum == tempInput;
    }
}
