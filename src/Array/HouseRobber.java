package Array;

/*
LeetCode 198

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

        Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
*/

public class HouseRobber {
//    // approach 1 - DP TC: O(n) SC: O(1)
//    public int rob(int[] nums) {
//        // base case
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//
//        int dp1 = 0;
//        int dp2 = 0;
//        int dp3 = 0;
//        int temp = 0;
//        if (nums.length > 0) {
//            dp1 = nums[0];
//        }
//
//        if (nums.length > 1) {
//            dp2 = nums[1];
//        }
//
//        if (nums.length > 2) {
//            dp3 = nums[0] + nums[2];
//        }
//
//        // inductive case
//        for (int i = 3; i < nums.length; i++) {
//            // M[i] = arr[i] + MAX(M[i - 2], M[i - 3])
//            temp = dp1;
//            dp1 = dp2;
//            dp2 = dp3;
//            dp3 = Math.max(temp, dp1) + nums[i];
//        }
//        return Math.max(dp1, Math.max(dp2, dp3));
//    }

    // approach 1 - DP TC: O(n) SC: O(1)
    public int rob2(int[] nums) {
        // base case
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int dp1 = 0;
        int dp2 = 0;
        int temp = 0;
        if (nums.length > 0) {
            dp1 = nums[0];
        }

        if (nums.length > 1) {
            dp2 = nums[1];
        }

        // inductive case
        for (int i = 2; i < nums.length; i++) {
            // M[i - 1] = MAX(M[i - 1], M[i])
            // M[i] = arr[i] + M[i - 1]
            temp = dp1;
            dp1 = Math.max(dp1, dp2);
            dp2 = temp + nums[i];
        }
        return Math.max(dp1, dp2);
    }

    // approach 1: DP TC: O(n) SC: O(1)
    public int rob(int[] nums) {
        // initialization
        int dpA = 0;
        int dpB = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // update rules: dp[i] = MAX(dp[i - 2] + arr[i], dp[i - 1])
            int temp = dpB;
            dpB = Math.max(dpA + nums[i], dpB);
            dpA = temp;
        }
        return dpB;
    }

    public static void main(String[] args) {
        HouseRobber test = new HouseRobber();
        int[] arr = new int[]{2, 7, 9, 3, 1};
        System.out.println(test.rob(arr));
    }
}
