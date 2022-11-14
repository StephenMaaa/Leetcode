package Array;

/*
You are given a 0-indexed integer array nums of length n.

        The average difference of the index i is the absolute difference between the average of the first i + 1 elements of nums and the average of the last n - i - 1 elements. Both averages should be rounded down to the nearest integer.

        Return the index with the minimum average difference. If there are multiple such indices, return the smallest one.

        Note:

        The absolute difference of two numbers is the absolute value of their difference.
        The average of n elements is the sum of the n elements divided (integer division) by n.
        The average of 0 elements is considered to be 0.
*/

public class MinimumAverageDifference {
    // approach 1 - prefixSum TC: O(n) SC: O(1)
    public int minimumAverageDifference(int[] nums) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        // prefixSum
        long prefixSum = 0;
        long minDiff = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            long rightAverage = i == nums.length - 1 ? 0 : (sum - prefixSum) / (nums.length - i - 1);
            long diff = Math.abs(prefixSum / (i + 1) - rightAverage);

            // update minDiff
            if (diff == 0) {
                return i;
            } else if (diff < minDiff) {
                minDiff = diff;
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        MinimumAverageDifference test = new MinimumAverageDifference();
        int[] arr = new int[]{0};
        System.out.println(test.minimumAverageDifference(arr));
    }
}
