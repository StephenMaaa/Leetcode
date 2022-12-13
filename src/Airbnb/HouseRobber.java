package Airbnb;

/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

        Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
*/

public class HouseRobber {
    // approach 1 - DP TC: O(n) SC: O(1)
    public int rob(int[] nums) {
        int dp1 = nums[0];
        int dp2 = 0;
        for (int i = 1; i < nums.length; i++) {
            int max = Math.max(dp1, dp2 + nums[i]);
            dp2 = dp1;
            dp1 = max;
        }
        return dp1;
    }
}
