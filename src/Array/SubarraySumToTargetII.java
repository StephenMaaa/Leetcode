package Array;

/*
LeetCode 560

Given an array nums and a target value k, find the totoal number of subarrays that sums to k.

        Note:
        The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.

        Example 1:

        Given nums = [1, -1, 5, -2, 3], k = 3,
        return 3. (Because the subarrays [1, -1, 5, -2], [5, -2], [3] sums to 3)

        Example 2:

        Given nums = [-2, -1, 2, 1], k = 1,
        return 2. (Because the subarray [-1, 2], [1] sums to 1)

        Follow Up:
        Can you do it in O(n) time?
*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubarraySumToTargetII {
//    // time complexity: O(n)
//    // space complexity: O(n)
//    public int numOfSubarraySumToK(int[] nums, int k) {
//        int prefixSum = 0;
//        int count = 0;
//        Map<Integer, Integer> existed = new HashMap<>();
//        existed.put(0, 1);
//        for (int i = 0; i < nums.length; i++) {
//            prefixSum += nums[i];
//            if (existed.containsKey(prefixSum - k)) {
//                count += existed.get(prefixSum - k);
//            }
//            existed.put(prefixSum, existed.getOrDefault(prefixSum, 0) + 1);
//        }
//        return count;
//    }

    // approach 1: Map + PrefixSum TC: O(n) SC: O(n)
    public int subarraySum(int[] nums, int k) {
        // initialization
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefixSum = 0;
        int count = 0;

        // calculate prefix sum and search
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            // check
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }

            // update
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        SubarraySumToTargetII test = new SubarraySumToTargetII();
        int[] arr = new int[]{1, 1, 1};
        System.out.println(test.subarraySum(arr, 2));
    }
}
