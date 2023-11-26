package com.program;
import java.util.Arrays;

// Find position of an element in a sorted array of infinite numbers
// https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
public class InfiniteArray {
    public static void main(String[] args) {
        int[] numsArr = {3,5,7,9,17,30,36,56,67,78,98,100,102,105,107,109,111,166,290,347,5783,5789,5799,6457,6699};
        int target = 56;
        int ans = findingRange(numsArr,target);
        System.out.println(ans);
    }

    //Below function is basically working as a reverse engineering of Binary Search Algo where worst case to reach the
    // answer is with the time complexity of "logN" after breaking down the array length to half at every single step
    // to reach the final element.

    static int findingRange(int[] arr, int target){
        // As it is an infinite array, starting with smallest size of box(array)
        int start = 0;
        int end = 1;

        // Condition for the target to lie in the range
        while(target> arr[end]){
            int newStart = end + 1;
            //Updating the size of the box by doubling the original size
            // size of box formula = (end-start+1)
            end = end + (end-start+1) * 2;

            //This condition is handle the Array.IndexOutOfBound exception.
            if(end >= arr.length){
                end = arr.length -1;
            }

            start = newStart;
        }

        return binarySearch(arr,target,start,end);
    }


    //Binary search algorithm is needed in order to reach the target element
    static int binarySearch(int[] arr,int target,int start, int end){
        while(start<=end){
            int mid = start + (end-start)/2;
            if(target<arr[mid]){
                end = mid-1;
            }
            else if(target>arr[mid]){
                start= mid+1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }

}