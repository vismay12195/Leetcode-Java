package com.program;
import java.util.Arrays;

// Leetcode Problem 34: Find First and Last Position of Element in Sorted Array
// Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given
// target value. If target is not found in the array, return [-1, -1].
// You must write an algorithm with O(log n) runtime complexity.

public class FirstAndLastPosition {
    public static void main(String[] args) {
        int[] numsArr = {5,7,7,8,8,10};
        int target = 7;
        int[] ans = searchRange(numsArr,target);
        System.out.println(Arrays.toString(ans));
    }

    static int[] searchRange(int[] nums, int target) {

        int[] ans = {-1, -1};
        // Now look for the first occurance of the target element
        int start = search(nums, target, true);
        // Looking for the last occurance of the target element
        int end = search(nums, target, false);

        ans[0] = start;
        ans[1] = end;

        // Or more concise way to do the same above thing
//        ans[0] = search(nums,target,true);
//        if(ans[0] != -1){
//        ans[1] =search(nums,target, false);}

        return ans;
    }

    //Below function will be looking for the start and index of the target
     static int search(int[] nums, int target, boolean findFirstIndex) {
        int ans = -1;

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            // Finding the middle element
            int mid = start + (end - start) / 2;

            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            }

            // Main Logic of the program lies here
            else {
                // Potential answer found
                ans = mid;
                // After potential answer it might be possible that the new start index might lie to the left of mid
                // So checking all the possibilities and at the same time also looking for the end index of the target
                if(findFirstIndex){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }

        }
        return ans;
    }
}
