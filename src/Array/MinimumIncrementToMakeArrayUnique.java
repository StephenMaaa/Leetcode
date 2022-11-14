package Array;

/*
You are given an integer array nums. In one move, you can pick an index i where 0 <= i < nums.length and increment nums[i] by 1.

        Return the minimum number of moves to make every value in nums unique.

        The test cases are generated so that the answer fits in a 32-bit integer.
*/

import java.util.Arrays;

public class MinimumIncrementToMakeArrayUnique {
    // approach 1 - Sorting TC: O(nlogn) SC: O(logn)
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);

        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] >= nums[i]) {
                count += nums[i - 1] - nums[i] + 1;
                nums[i] = nums[i - 1] + 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MinimumIncrementToMakeArrayUnique test = new MinimumIncrementToMakeArrayUnique();
        int[] arr = new int[]{1, 2, 2};
        System.out.println(test.minIncrementForUnique(arr));
    }
}
