package Tree;

/*
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

        A valid BST is defined as follows:

        The left subtree of a node contains only nodes with keys less than the node's key.
        The right subtree of a node contains only nodes with keys greater than the node's key.
        Both the left and right subtrees must also be binary search trees.
*/

public class ValidateBinarySearchTree {
    // approach 1: recursion TC: O(n) SC: O(height)
    public boolean isValidBST(TreeNode root) {
        return traverse(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean traverse(TreeNode root, long left, long right) {
        // base case
        if (root == null) {
            return true;
        }

        // recursive case
        if (root.val > left && root.val < right) {
            return traverse(root.left, left, root.val) && traverse(root.right, root.val, right);
        }
        return false;
    }
}
