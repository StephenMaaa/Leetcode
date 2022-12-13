package Tree;

/*
Given a binary tree, determine if it is height-balanced.
*/

public class BalancedBinaryTree {
    // approach 1 - Recursion TC: O(n) SC: O(height)
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1; 
    }

    private int helper(TreeNode root) {
        // base case
        if (root == null) {
            return 0;
        }

        // recursive case
        int left = helper(root.left);
        int right = helper(root.right);

        // check
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
