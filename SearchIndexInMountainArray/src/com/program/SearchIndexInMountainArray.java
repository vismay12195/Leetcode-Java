package com.program;

// Leetcode 1095- Find in Mountain Array
// Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target.
// If such an index does not exist, return -1.

// Logic:
// 1. Finding the peak element. (searchIndex() function)
// 2. Element could exist on the ascending order side of the array too. (orderAgnostic() function)
// 3. If not found, Element could even exist on the descending order side of the array too.(orderAgnostic() function)

public class SearchIndexInMountainArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,3,1};
        int[] arr2 = {0,1,2,4,2,1};
        int peak = searchIndex(arr);
        int ans = orderAgnostic(arr, 3, 0, peak);
        int ans2 = orderAgnostic(arr2,3,0, peak);
        System.out.println(ans);
        System.out.println(ans2);
    }

    static int searchIndex(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while(start<end){
            int mid = start + (end-start)/2;

            if(arr[mid] > arr[mid+1]){
                end=mid;
            }
            else{
                start = mid + 1;
            }
        }
        return start;
    }

    static int orderAgnostic(int[] arr, int target, int start, int end){
        boolean isAscending = arr[start] < arr[end];

        while(start <= end){
            int mid = start + (end-start)/2;

            if(target == arr[mid]){
                return mid;
            }

            if(isAscending){
                if(target < arr[mid]){
                    end = mid -1;
                }
                else{
                    start = mid + 1;
                }
            }
            else{
                if(target > arr[mid]){
                    end = mid -1;
                }
                else{
                    start = mid +1;
                }
            }
        }
        return -1;
    }
}
