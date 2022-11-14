package Array;

/*
You are given an integer array nums and an integer k.

        For each index i where 0 <= i < nums.length, change nums[i] to be either nums[i] + k or nums[i] - k.

        The score of nums is the difference between the maximum and minimum elements in nums.

        Return the minimum score of nums after changing the values at each index.
*/

import java.util.Arrays;

public class SmallestRangeII {
    // approach 1 - Sorting + Arrays TC: O(nlogn) SC: O(logn)
    public int smallestRangeII(int[] nums, int k) {
        // sort
        Arrays.sort(nums);

        int res = nums[nums.length - 1] - nums[0];
        int max = 0;
        int min = 0;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(nums[i - 1] + k, nums[nums.length - 1] - k);
            min = Math.min(nums[i] - k, nums[0] + k);
            res = Math.min(res, max - min);
        }
        return res;
    }

    public static void main(String[] args) {
        SmallestRangeII test = new SmallestRangeII();
        int[] arr = new int[]{1};
        System.out.println(test.smallestRangeII(arr, 3));
    }
}
