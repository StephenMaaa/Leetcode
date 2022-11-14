package Tree;

/*
Given a binary tree in which each node contains an integer number. Find the maximum possible path sum from a leaf to root.



        Assumptions

        The root of given binary tree is not null.



        Examples



        10

        /      \

        -2        7

        /     \

        8      -4

        The maximum path sum is 10 + 7 = 17.
*/

public class MaxPathSumFromLeafToRoot {
    public int maxPathSumLeafToRoot(TreeNode root) {
        // base case: null
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        // base case: leaf
        if (root.left == null && root.right == null) {
            System.out.println(root.val);
            return root.val;
        }

        int leftMax = maxPathSumLeafToRoot(root.left);
        int rightMax = maxPathSumLeafToRoot(root.right);
        System.out.println(leftMax + "  " + rightMax);
        return Math.max(leftMax, rightMax) + root.val;
    }

    public static void main(String[] args) {
        MaxPathSumFromLeafToRoot test = new MaxPathSumFromLeafToRoot();
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(11);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        System.out.println(test.maxPathSumLeafToRoot(root));
    }
}
