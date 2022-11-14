package Tree;

/*
Given a binary tree in which each node contains an integer number. Find the maximum possible subpath sum(both the starting and ending node of the subpath should be on the same path from root to one of the leaf nodes, and the subpath is allowed to contain only one node).

        Assumptions

        The root of given binary tree is not null
        Examples

        -5

        /    \

        2      11

        /    \

        6     14

        /

        -3

        The maximum path sum is 11 + 14 = 25
*/

public class MaxPathSumIII {
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        findMaxPathSum(root, 0, max);
        return max[0];
    }

    private void findMaxPathSum(TreeNode root, int prev, int[] max) {
        // base case
        if (root == null) {
            return;
        }

        int curr = prev < 0 ? root.val : prev + root.val;
        max[0] = Math.max(max[0], curr);
        findMaxPathSum(root.left, curr, max);
        findMaxPathSum(root.right, curr, max);
    }

    public static void main(String[] args) {
        MaxPathSumIII test = new MaxPathSumIII();
        TreeNode root = new TreeNode(-5);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(11);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(14);
        TreeNode node5 = new TreeNode(-3);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        node4.left = node5;
        System.out.println(test.maxPathSum(node5));
    }
}
