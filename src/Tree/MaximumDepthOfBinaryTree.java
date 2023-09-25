package Tree;

/*
Given the root of a binary tree, return its maximum depth.

        A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
*/

public class MaximumDepthOfBinaryTree {
    // approach 1: Recursion TC: O(n) SC: O(height)
    public int maxDepth(TreeNode root) {
        // base case
        if (root == null) {
            return 0;
        }

        // recursive case
        return Math.max(maxDepth(root.left), maxDepth((root.right))) + 1;
    }
}
