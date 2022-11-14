package Tree;

/*
Given a binary tree and a target sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given target.

        Example:
        Given the below binary tree and target = 16,

        5
        / \
        4   8
        /   / \
        1    3  4
        /  \      \
        7    2      1
        return true, as there exist a root-to-leaf path 5-8-3 which sum is 16.
*/

public class PathSumToTarget {
    // time complexity: O(n)
    // space complexity: O(height)
    public boolean exist(TreeNode root, int target) {
        return traverse(root, 0, target);
    }

    private boolean traverse(TreeNode root, int sum, int target) {
        // base case
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return (sum + root.val) == target;
        }

        // recursive case
        return traverse(root.left, sum + root.val, target) || traverse(root.right, sum + root.val, target);
    }

    public static void main(String[] args) {
        PathSumToTarget test = new PathSumToTarget();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(-5);
        TreeNode node4 = new TreeNode(-5);
        TreeNode node5 = new TreeNode(-5);
        TreeNode node6 = new TreeNode(-5);
//        TreeNode node7 = new TreeNode(2);
//        TreeNode node8 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        System.out.println(test.exist(root, 3)); 
    }
}
