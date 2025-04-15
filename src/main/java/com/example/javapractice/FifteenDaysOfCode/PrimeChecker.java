package com.example.javapractice.FifteenDaysOfCode;

/**
 * @author trinapal
 */
public class PrimeChecker {
    public boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0) return false;
        return true;
    }

    //why use sqrt of n
    /*
    If n is divisible by any number greater than √n, then it must have a corresponding factor less than √n.
    Time complexity improves from O(n) to O(√n) — huge savings for large numbers.
     */

}
