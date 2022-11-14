package Tree;

/*
Given a binary tree, find its minimum depth. The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

        Example:
        Given the below binary tree

        5

        /       \

        3         8

        \

        4

        minimum depth is 2,path is 5→8.

        Clarification:

        1. The root itself can be a valid path if there is only one node in the binary tree
        2. If root == null, return 0
*/

public class MinimumDepthOfBinaryTree {
    // time complexity: O(n)
    // space complexity: O(height)
    public int minDepth(TreeNode root) {
        int[] min = new int[1];
        min[0] = Integer.MAX_VALUE;
        traverse(root, 1, min);
        return min[0] == Integer.MAX_VALUE ? 0 : min[0];
    }

    private void traverse(TreeNode root, int depth, int[] min) {
        // base case
        if (root == null || min[0] <= depth) {
            return;
        }

        // update max
        if (root.left == null && root.right == null) {
            min[0] = Math.min(min[0], depth);
            return;
        }

        // recursive case
        traverse(root.left, depth + 1, min);
        traverse(root.right, depth + 1, min);
    }

    public static void main(String[] args) {
        MinimumDepthOfBinaryTree test = new MinimumDepthOfBinaryTree();
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(4);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        System.out.println(test.minDepth(null));
    }
}
