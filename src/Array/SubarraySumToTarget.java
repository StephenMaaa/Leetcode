package Array;

/*
Given an array of integers, determine whether there exists a contiguous sub-array in the array, which sums to a target number.

        Assumptions:

        The given array is not null and its length is > 0.
        Examples:

        array = {1, 5, 2, 3}, target = 10, return true since the sum of subarray {5, 2, 3} is 10.
        array = {1, 5, 2, 3}, target = 4, return false.
*/

import java.util.*;

public class SubarraySumToTarget {
    // time complexity: O(n)
    // space complexity: O(n)
    public boolean sumToTarget(int[] array, int target) {
        int prefixSum = 0;
        Set<Integer> existed = new HashSet<>();
        existed.add(0);
        for (int i = 0; i < array.length; i++) {
            prefixSum += array[i];
            if (existed.contains(prefixSum - target)) {
                return true;
            }
            existed.add(prefixSum);
        }
        return false;
    }

//    // approach 1 - prefixSum + Set TC: O(n) SC: O(n)
//    public boolean checkSubarraySum(int[] nums, int k) {
//        long prefixSum = 0;
//        Set<Long> set = new HashSet<>();
//        set.add((long) k);
//        for (int i = 0; i < nums.length; i++) {
//            prefixSum += nums[i];
//
//            // check
//            if (set.contains(prefixSum)) {
//                return true;
//            }
//            set.add(prefixSum + k);
//        }
//        return false;
//    }

//    // approach 1 - prefixSum + Map TC: O(n) SC: O(k)
//    public boolean checkSubarraySum(int[] nums, int k) {
//        int prefixSum = 0;
//        Map<Integer, Integer> map = new HashMap<>();
//        map.put(0, -1);
//        for (int i = 0; i < nums.length; i++) {
//            prefixSum += nums[i];
//            prefixSum %= k;
//
//            // check
//            if (map.containsKey(prefixSum)) {
//                if (i - map.get(prefixSum) > 1) {
//                    return true;
//                }
//            } else {
//                map.put(prefixSum, i);
//            }
//        }
//        return false;
//    }

    // approach 2 - prefixSum + Arrays TC: O(n) SC: O(k)
    public boolean checkSubarraySum(int[] nums, int k) {
        int prefixSum = 0;
        int[] arr = new int[k];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[0] = -1;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            prefixSum %= k;

            // check
            if (arr[prefixSum] != Integer.MAX_VALUE) {
                if (i - arr[prefixSum] > 1) {
                    return true;
                }
            } else {
                arr[prefixSum] = i;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SubarraySumToTarget test = new SubarraySumToTarget();
        int[] arr = new int[]{23, 2, 4, 6, 6};
        System.out.println(test.checkSubarraySum(arr, 7));
    }
}
