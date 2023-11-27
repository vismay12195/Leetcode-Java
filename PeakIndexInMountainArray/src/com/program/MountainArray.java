package com.program;
// LeetCode 852: Peak Index in a Mountain Array
// An array arr is a mountain if the following properties hold:
// arr.length >= 3
// There exists some i with 0 < i < arr.length - 1 such that:
// arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
// arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
// Given a mountain array arr, return the index i such that
// arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].
// You must solve it in O(log(arr.length)) time complexity.
// Example 1:
//Input: arr = [0,1,0]
//Output: 1
//Example 2:
//Input: arr = [0,2,1,0]
//Output: 1

public class MountainArray {
    public static void main(String[] args) {
        int[] numsArr = {1,2,3,5,6,4,3,2};
        int ansIndex = peakIndexInMountainArray(numsArr);
        System.out.println(ansIndex);
        int[] arr = {0,2,1,0};
        int ansIndex2 = peakIndexInMountainArray(arr);
        System.out.println(ansIndex2);
    }

    static int peakIndexInMountainArray(int[] arr){
        int start=0;
        int end=arr.length -1;

        while(start<end){
            int mid = start + (end-start)/2;

            if(arr[mid] > arr[mid + 1]){
                // As the mid > mid+1, the array on the right side is in decreasing order
                // hence mid could be a possible ans
                // that is why end!==mid-1
                end=mid;
            }
            else{
                // In this case mid would be lesser than the mid+1
                // so the array on the right side is in increasing order
                // hence ans would to the right side of mid element
                // therefore start = mid+1
                start=mid+1;
            }

        }
        // Now after going through above 2 checks the mid value would end up to the answer element
        // At that point the mid value is going to be the start and end value as the whole array is narrowed
        // only to the size of 1 and that one element would start = end and also would be the peak value
        // Hence returning either the start or end would be the same index.
        return start; // or return end;
    }
}