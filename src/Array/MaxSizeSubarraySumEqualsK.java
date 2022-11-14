package Array;

/*
Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

        Note:
        The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.

        Example 1:

        Given nums = [1, -1, 5, -2, 3], k = 3,
        return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

        Example 2:

        Given nums = [-2, -1, 2, 1], k = 1,
        return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

        Follow Up:
        Can you do it in O(n) time?
*/

import java.util.HashMap;
import java.util.Map;

public class MaxSizeSubarraySumEqualsK {
    // approach 1: prefixSum only - TC: O(n^2) SC: O(n)
    public int maxSubArrayLen(int[] nums, int k) {
        int[] prefixSum = new int[nums.length + 1];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            // update prefixSum
            prefixSum[i + 1] = prefixSum[i] + nums[i];

            // check and update max
            for (int j = 0; j < i + 1; j++) {
                if (prefixSum[i + 1] - prefixSum[j] == k) {
                    max = Math.max(max, i - j + 1);
                }
            }
        }
        return max;
    }

    // approach 2: prefixSum + Map - TC: O(n) SC: O(n)
    public int maxSubArrayLen2(int[] nums, int k) {
        int[] prefixSum = new int[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            // update prefixSum
            prefixSum[i + 1] = prefixSum[i] + nums[i];

            int res = prefixSum[i + 1] - k;
            if (!map.containsKey(res)) {
                map.put(res, i + 1);
            }
        }

        // check and update max
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(prefixSum[i])) {
                max = Math.max(max, map.get(prefixSum[i]) - i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxSizeSubarraySumEqualsK test = new MaxSizeSubarraySumEqualsK();
        int[] arr = new int[]{1, -1, 5, -2, 3};
        System.out.println(test.maxSubArrayLen2(arr, 10));
    }
}
