package DP;

/*
Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

        For example, given the array [2,3,1,2,4,3] and s = 7,
        the subarray [4,3] has the minimal length under the problem constraint.
*/

public class MinimumSizeSubarraySum {
    // time complexity: O(n)
    // space complexity: O(1)
    public int minSubArrayLen(int num, int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            // case 1: sum + arr[i] >= target
            // case 2: otherwise
            sum += nums[i];
            if (sum >= num) {
                // update start index and min
                while (sum - nums[start] >= num) {
                    sum -= nums[start++];
                }
                min = Math.min(min, i - start + 1);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    // approach 1 - Sliding Window TC: O(n) SC: O(1)
    public int minSubArrayLen2(int target, int[] nums) {
        int sum = 0;
        int start = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            // case 1: sum >= target
            // case 2: sum < target
            if (sum >= target) {
                // prune
                while (sum - nums[start] >= target) {
                    sum -= nums[start];
                    start++;
                }

                // update min
                min = Math.min(min, i - start + 1);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum test = new MinimumSizeSubarraySum();
        int[] arr = new int[]{2, 3, 1, 2, 4, 3};
        System.out.println(test.minSubArrayLen2(7, arr));
    }
}
