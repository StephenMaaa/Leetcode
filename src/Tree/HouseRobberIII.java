package Tree;

/*
The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.

        Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place form a binary tree. It will automatically contact the police if two directly-linked houses were broken into on the same night.

        Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class HouseRobberIII {
    // approach 1 - Recursion TC: O(n) SC: O(height)
    public int rob(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }

    private int[] helper(TreeNode root) {
        // base case
        if (root == null) {
            return new int[2];
        }

        // recursive case
        int[] left = helper(root.left);
        int[] right = helper(root.right);

        // choose
        int sumA = root.val + left[0] + right[0];

        // skip
        int sumB = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{sumB, sumA};
    }
}
