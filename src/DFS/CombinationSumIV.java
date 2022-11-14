package DFS;

/*
Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.

        The test cases are generated so that the answer can fit in a 32-bit integer.
*/

public class CombinationSumIV {
    // approach 1 - DFS TC: O(k^n) SC: O(n)
    public int combinationSum4(int[] nums, int target) {
        // base case
        if (target == 0) {
            return 1;
        }

        // recursive case
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                count += combinationSum4(nums, target - nums[i]);
            }
        }
        return count;
    }

    // approach 2 - DP TC: O(kn) SC: O(n)
    public int combinationSum4_2(int[] nums, int target) {
        int[] counts = new int[target + 1];
        counts[0] = 1;

        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    counts[i] += counts[i - nums[j]];
                }
            }
        }
        return counts[target];
    }

    public static void main(String[] args) {
        CombinationSumIV test = new CombinationSumIV();
        int[] arr = new int[]{1, 2, 3};
        System.out.println(test.combinationSum4_2(arr, 4));
    }
}
