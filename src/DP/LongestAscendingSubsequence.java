package DP;

/*
LeetCode 300

Given an array A[0]...A[n-1] of integers, find out the length of the longest ascending subsequence.

        Assumptions

        A is not null
        Examples
        Input: A = {5, 2, 6, 3, 4, 7, 5}
        Output: 4
        Because [2, 3, 4, 5] is the longest ascending subsequence.
*/

import java.util.*;

public class LongestAscendingSubsequence {
    public int longest(int[] array) {
        // edge case
        if (array.length == 0) {
            return 0;
        }

        int globalMax = 1;
        int[] maxArr = new int[array.length];
        Arrays.fill(maxArr, 1);

        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]) {
                    maxArr[i] = Math.max(maxArr[i], maxArr[j] + 1);
                }
            }
            globalMax = Math.max(globalMax, maxArr[i]);
        }

        return globalMax;
    }

//     // approach 1 - DP TC: O(n^2) SC: O(n)
//     public int lengthOfLIS(int[] nums) {
//         // dp array
//         int[] dp = new int[nums.length];
//         int globalMax = 0;
//         for (int i = 0; i < nums.length; i++) {
//             int max = 1;
//
//             // check max from previous array
//             for (int j = 0; j < i; j++) {
//                 if (nums[i] > nums[j]) {
//                     max = Math.max(max, dp[j] + 1);
//                 }
//             }
//             dp[i] = max;
//             globalMax = Math.max(globalMax, max);
//         }
//         return globalMax;
//     }

//    // approach 2 - Arrays + Binary Search TC: O(nlogn) SC: O(n)
//    public int lengthOfLIS2(int[] nums) {
//        // maintain a min ascending subsequence
//        List<Integer> arr = new ArrayList<>();
//        arr.add(nums[0]);
//
//        for (int i = 1; i < nums.length; i++) {
//            // case 1: arr[i] > all numbers in subsequence
//            // case 2: otherwise
//            if (nums[i] > arr.get(arr.size() - 1)) {
//                arr.add(nums[i]);
//            } else {
//                // replace the min greater number in subsequence with current number
//                arr.set(find(arr, nums[i]), nums[i]);
//            }
//        }
//        return arr.size();
//    }
//
//    private int find(List<Integer> arr, int target) {
//        // binary search to find the min greater number
//        int left = 0;
//        int right = arr.size() - 1;
//        while (left < right) {
//            int mid = (left + right) >> 1;
//
//            if (arr.get(mid) < target) {
//                left = mid + 1;
//            } else {
//                right = mid;
//            }
//        }
//        return left;
//    }

    // approach 1: DP TC: O(n^2) SC: O(n)
    public int lengthOfLIS2(int[] nums) {
        int[] dp = new int[nums.length];
        int globalMax = 0;

        for (int i = 0; i < nums.length; i++) {
            int max = 1;

            // search previous
            for (int j = 0; j < i; j++) {
                // check
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
            globalMax = Math.max(dp[i], globalMax);
        }
        return globalMax;
    }

    // approach 2: DP + Binary Search TC: O(nlogn) SC: O(n)
    public int lengthOfLIS(int[] nums) {
        // maintain the min ascending subsequence
        List<Integer> arr = new ArrayList<>();
        arr.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            // check
            // case 1: last in ascending subsequence < current
            // case 2: otherwise
            if (arr.get(arr.size() - 1) < nums[i]) {
                arr.add(nums[i]);
            } else {
                int index = find(arr, nums[i]);
                arr.set(index, nums[i]);
            }
        }
        return arr.size();
    }

    private int find(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size() - 1;
        while (left < right) {
            int mid = (left + right) >> 1;

            if (arr.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        LongestAscendingSubsequence test = new LongestAscendingSubsequence();
        int[] arr = new int[]{4, 10, 4, 3, 8, 9};
        System.out.println(test.lengthOfLIS(arr)); 
    }
}
