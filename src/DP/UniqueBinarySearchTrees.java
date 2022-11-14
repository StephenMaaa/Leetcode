package DP;

/*
Find the number of different Binary Search Trees generated from 1-n.

        Example:

        Input: 3, Return: 5
*/

public class UniqueBinarySearchTrees {
    public int numOfTrees(int n) {
        int[] nums = new int[n + 1];
        nums[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            // nums[i] = SUM(nums[left] * nums[right])
            for (int j = 0; j < i; j++) {
                nums[i] += nums[j] * nums[i - j - 1];
            }
        }
        return nums[n];
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees test = new UniqueBinarySearchTrees();
        System.out.println(test.numOfTrees(2));
    }
}
