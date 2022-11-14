package Array;

/*
You are given a 0-indexed integer array nums of length n.

        nums contains a valid split at index i if the following are true:

        The sum of the first i + 1 elements is greater than or equal to the sum of the last n - i - 1 elements.
        There is at least one element to the right of i. That is, 0 <= i < n - 1.
        Return the number of valid splits in nums.
*/

public class NumberOfWaysToSplitArray {
    // approach 1 - prefixSum TC: O(n) SC: O(1)
    public int waysToSplitArray(int[] nums) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        // prefixSum
        long prefixSum = 0;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            prefixSum += nums[i];

            // check
            if (prefixSum >= sum - prefixSum) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfWaysToSplitArray test = new NumberOfWaysToSplitArray();
        int[] arr = new int[]{2, 3, 1, 0};
        System.out.println(test.waysToSplitArray(arr));
    }
}
