package Tree;

/*
LeetCode 222

Given the root of a complete binary tree, return the number of the nodes in the tree.

        According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

        Design an algorithm that runs in less than O(n) time complexity.
*/

public class CountCompleteTreeNodes {
    // approach 1: Recursion TC: O(n) SC: O(height)
    public int countNodes2(TreeNode root) {
        // base case
        if (root == null) {
            return 0;
        }

        // recursive case
        return countNodes2(root.left) + countNodes2(root.right) + 1;
    }

    // approach 2: Recursion TC: O(logn^2) SC: O(height)
    public int countNodes(TreeNode root) {
        int height = getHeight(root);

        // base case
        if (height < 0) {
            return 0;
        }

        // recursive case
        // check tree height
        // case 1: left height > right height -> left subtree is not and right subtree is full complete
        // case 2: left height == right height -> left subtree is full complete and right subtree is not
        if (getHeight(root.right) == height - 1) {
            return (1 << height) + countNodes(root.right);
        } else {
            return (1 << height - 1) + countNodes(root.left);
        }
    }

    private int getHeight(TreeNode node) {
        int height = 0;

        // edge case
        if (node == null) {
            return -1;
        }

        while (node.left != null) {
            node = node.left;
            height++;
        }
        return height;
    }
}
