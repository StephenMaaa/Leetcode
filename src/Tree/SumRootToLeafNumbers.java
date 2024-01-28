package Tree;

/*
LeetCode 129

You are given the root of a binary tree containing digits from 0 to 9 only.

        Each root-to-leaf path in the tree represents a number.

        For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
        Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

        A leaf node is a node with no children.
*/

public class SumRootToLeafNumbers {
    // approach 1: Recursion TC: O(n) SC: O(height)
    public int sumNumbers(TreeNode root) {
        return traverse(root, 0);
    }

    private int traverse(TreeNode root, int sum) {
        // base case
        if (root == null) {
            return 0;
        }

        // recursive case
        int nextSum = sum * 10 + root.val;

        // check left node
        if (root.left == null && root.right == null) {
            return nextSum;
        }
        return traverse(root.left, nextSum) + traverse(root.right, nextSum);
    }

    public static void main(String[] args) {
        SumRootToLeafNumbers test = new SumRootToLeafNumbers();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
//        TreeNode node3 = new TreeNode(4);
//        TreeNode node4 = new TreeNode(5);
//        TreeNode node5 = new TreeNode(6);
//        TreeNode node6 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
//        node1.left = node3;
//        node1.right = node4;
//        node2.left = node5;
//        node2.right = node6;
        System.out.println(test.sumNumbers(root));
    }
}
