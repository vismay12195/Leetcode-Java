package com.program;

// LeetCode Problem No: 744
// You are given an array of characters letters that is sorted in non-decreasing order, and a character target.
// There are at least two different characters in letters.
//Return the smallest character in letters that is lexicographically greater than target.
// If such a character does not exist, return the first character in letters.
public class SmallestLetter {

    public static void main(String[] args) {
        char[] letterArr = {'c','f','j'};
        char target = 'c';
        char result = nextGreatestLetter(letterArr,target);
        System.out.println(result);    }

    static char nextGreatestLetter(char[] letters,char target){
        int start = 0;
        int end = letters.length-1;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(target < letters[mid]){
                end = mid -1;
            }
            else{
                start = mid + 1;
            }
        }

        // Return value is very crucial here because when the target character is the last in the array then
        // we have to return the zero indexed(0) value from letters array.
        // for start % letters.length == 0 which means the while loop condition is violated else in all the other cases
        // only the character at letters[start] would be returned.
        return letters[start % letters.length];
    }
}
