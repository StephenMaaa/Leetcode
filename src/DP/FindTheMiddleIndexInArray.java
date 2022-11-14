package DP;

/*
Given a 0-indexed integer array nums, find the leftmost middleIndex (i.e., the smallest amongst all the possible ones).

        A middleIndex is an index where nums[0] + nums[1] + ... + nums[middleIndex-1] == nums[middleIndex+1] + nums[middleIndex+2] + ... + nums[nums.length-1].

        If middleIndex == 0, the left side sum is considered to be 0. Similarly, if middleIndex == nums.length - 1, the right side sum is considered to be 0.

        Return the leftmost middleIndex that satisfies the condition, or -1 if there is no such index.
*/

public class FindTheMiddleIndexInArray {
    // approach 1 - prefixSum + suffixSum TC: O(n) SC: O(n)
    public int findMiddleIndex(int[] nums) {
        // suffixSum
        int[] suffixSum = new int[nums.length + 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + nums[i];
        }

        // find leftmost middle index
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            // check
            if (prefixSum == suffixSum[i + 1]) {
                return i;
            }
            prefixSum += nums[i];
        }
        return -1;
    }

    // approach 2 - prefixSum + suffixSum TC: O(n) SC: O(1)
    public int findMiddleIndex2(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        // find leftmost middle index
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            // check
            if (prefixSum == sum - prefixSum - nums[i]) {
                return i;
            }
            prefixSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        FindTheMiddleIndexInArray test = new FindTheMiddleIndexInArray();
        int[] arr = new int[]{2, 5};
        System.out.println(test.findMiddleIndex2(arr));
    }
}
