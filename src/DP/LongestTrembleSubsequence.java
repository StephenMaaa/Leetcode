package DP;

/*
Given an integer array, a tremble subsequence is defined as a subsequence in which the difference between maximum value and minimum value is exactly 1. Return the length of the longest tremble subsequence of the given array.

        Example 1:

        Input: nums = [1,6,1,6,1,6,1,6,7]

        Output: 5

        Explanation: The length of the longest tremble subsequence is [6,6,6,6,7] is 5.
*/

import java.util.HashMap;
import java.util.Map;

public class LongestTrembleSubsequence {
    // time complexity: O(n)
    // space complexity: O(n)
    public int longestTrembleSubsequence(int[] nums) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // find max
        for (int key : map.keySet()) {
            // check prev
            if (map.containsKey(key - 1)) {
                max = Math.max(max, map.get(key) + map.get(key - 1));
            }

            // check next
            if (map.containsKey(key + 1)) {
                max = Math.max(max, map.get(key) + map.get(key + 1));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestTrembleSubsequence test = new LongestTrembleSubsequence();
        int[] arr = new int[]{1};
        System.out.println(test.longestTrembleSubsequence(arr));
    }
}
