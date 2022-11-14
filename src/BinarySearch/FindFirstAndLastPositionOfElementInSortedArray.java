package BinarySearch;

/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

        If target is not found in the array, return [-1, -1].

        You must write an algorithm with O(log n) runtime complexity.
*/

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    // approach 1 - Binary Search TC: O(logn) SC: O(1)
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};

        // find first index
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // case 1: arr[mid] == target
            // case 2: arr[mid] < target
            // case 3: otherwise
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                if (nums[mid] == target) {
                    res[0] = mid;
                }
                right = mid - 1;
            }
        }

        // find last index
        left = Math.max(0, right);
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // case 1: arr[mid] == target
            // case 2: arr[mid] < target
            // case 3: otherwise
            if (nums[mid] <= target) {
                if (nums[mid] == target) {
                    res[1] = mid;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray test = new FindFirstAndLastPositionOfElementInSortedArray();
        int[] arr = new int[]{};
        System.out.println(Arrays.toString(test.searchRange(arr, 10))); 
    }
}
