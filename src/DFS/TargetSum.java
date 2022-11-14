package DFS;

/*
Given an int array and a target number, for each number in the given array, you can assign symbol "+" or "-" to that number. Return number of ways to add symbol to all elements in the given array so that the sum of them equals to target.

        Example:

        nums = [1, 0], target = 1

        Output: 2

        Explanation: +1+0 = 1; +1-0 = 1
*/

public class TargetSum {
    // time complexity: O(2^n)
    // space complexity: O(n)
    public int waysToTargetSum(int[] nums, int target) {
        int[] count = new int[1];
        dfs(nums, count, 0, 0, target);
        return count[0];
    }

    private void dfs(int[] nums, int[] count, int index, int sum, int target) {
        // base case
        if (index == nums.length) {
            if (sum == target) {
                count[0]++;
            }
            return;
        }

        // recursive case
        dfs(nums, count, index + 1, sum + nums[index], target);
        dfs(nums, count, index + 1, sum - nums[index], target);
    }

    public static void main(String[] args) {
        TargetSum test = new TargetSum();
        int[] arr = new int[]{};
        System.out.println(test.waysToTargetSum(arr, 1));
    }
}
