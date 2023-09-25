package DFS;

/*
Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.
*/

public class PartitionEqualSubsetSum {
//    // approach 1: DFS TC: O(n^2) SC: O(n)
//    public boolean canPartition(int[] nums) {
//        boolean[] res = new boolean[1];
//        dfs(nums, 0, 0, 0, res);
//        return res[0];
//    }
//
//    private void dfs(int[] nums, int index, int left, int right, boolean[] res) {
//        // base case
//        if (index == nums.length) {
//            if (left == right) {
//                res[0] = true;
//            }
//            return;
//        }
//
//        // recursive case
//        // add to left sum
//        dfs(nums, index + 1, left + nums[index], right, res);
//
//        // add to right sum
//        dfs(nums, index + 1, left, right + nums[index], res);
//    }

//    // approach 2: DFS TC: O(n^2) SC: O(n)
//    public boolean canPartition(int[] nums) {
//        int total = 0;
//        for (int i = 0; i < nums.length; i++) {
//            total += nums[i];
//        }
//
//        // edge case
//        if (total % 2 == 1) {
//            return false;
//        }
//
//        return dfs(nums, 0, total / 2);
//    }
//
//    private boolean dfs(int[] nums, int index, int sum) {
//        // base case
//        if (sum == 0) {
//            return true;
//        }
//
//        if (index == nums.length) {
//            return false;
//        }
//
//        // recursive case
//        return dfs(nums, index + 1, sum - nums[index]) || dfs(nums, index + 1, sum);
//    }

    // approach 3: DP TC: O(mn) SC: O(mn)
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }

        // edge case
        if (total % 2 == 1) {
            return false;
        }

        // initialization
        boolean[][] dp = new boolean[nums.length][total / 2 + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }

        // populate
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < dp[1].length; j++) {
                // dp[i][j] = true
                // if dp[i - 1][j] == true or dp[i - 1][j - nums[i]] == true
                if (dp[i - 1][j]) {
                    dp[i][j] = true;
                } else if (j - nums[i] >= 0 && dp[i - 1][j - nums[i]]) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[nums.length - 1][total / 2];
    }

    public static void main(String[] args) {
        PartitionEqualSubsetSum test = new PartitionEqualSubsetSum();
        int[] arr = new int[]{1, 5, 11, 5};
        System.out.println(test.canPartition(arr));
    }
}
