// Find numbers with Even number of Digits
// https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
// Given an array nums of integers, return how many of them contain an even number of digits.

package com.evennumberofdigits;

public class EvenDigits {
    public static void main(String[] args) {
    int[] numsArr = {12,9,1176,111,45,657};
    System.out.println(findEven(numsArr));
    System.out.println(even(1745));
    System.out.println(digits(1745));
    }

    static int findEven(int[] arr){
        int count = 0;

        for(int num: arr){
            if(even(num)){
                count++;
            }
        }

        return count;
    }

    // Checking Whether the number is even

    static boolean even(int num){
        int numOfDigits = digits(num);
        return numOfDigits %2 == 0;
    }

    static int digits(int num){
        // Checking for the condition when there is a negative number
        if(num < 0){
            return num * -1;
        }

        // For num = 0
        if(num == 0){
            return 1;
        }

        int count =0;
        // Counting the number of digits in a number
        while(num>0){
            count++;
            num = num/10;
        }
        return count;
    }
}