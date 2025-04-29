package codeChallenge;

import java.util.Arrays;

/**
 * @author trinapal
 */
/*
Create a class Biggest that contains a single-dimensional
 array as a data member and a method display() to find and display the largest element of the array.
 */
public class Biggest {
    private int[] member;
    public static void main(String[] args) {
        Biggest biggest = new Biggest(new int[] {4,6,9,9,3,8});
        System.out.println(biggest.display());
    }
    Biggest(int[] member){
        this.member = member;
    }
    public int display(){
        Arrays.sort(member);
        return member[member.length-1];
    }
}
