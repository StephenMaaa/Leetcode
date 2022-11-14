package Tree;

/*
Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.

        Note:
        A subtree must include all of its descendants.
        Here's an example:

        10
        / \
        5  15
        / \   \
        1   8   7
        The Largest BST Subtree in this case is the highlighted one.
        The return value is the subtree's size, which is 3.

        Follow up:
        Can you figure out ways to solve it with O(n) time complexity?
*/

import Array.IntersectionOfTwoArrays;

public class LargestBSTSubtree {
//    // time complexity: O(n)
//    // space complexity: O(height)
//    public int largestBSTSubtree(TreeNode root) {
//        int[] max = new int[1];
////        // edge case
////        if (root != null) {
////            max[0] = 1;
////        }
//
//        traverse(root, Integer.MIN_VALUE, Integer.MAX_VALUE, max);
//        return max[0];
//    }
//
//    private int traverse(TreeNode root, int left, int right, int[] max) {
//        // base case
//        if (root == null) {
//            return 0;
//        }
//
//        // recursive case
//        if (root.val > left && root.val < right) {
//            int leftBST = traverse(root.left, left, root.val, max);
//            int rightBST = traverse(root.right, root.val, right, max);
//
//            // case 1: BST
//            // case 2: otherwise
//            if (leftBST != -1 && rightBST != -1) {
//                max[0] = Math.max(max[0], leftBST + rightBST + 1);
//                return leftBST + rightBST + 1;
//            } else {
//                return -1;
//            }
//        } else {
//            int leftBST = traverse(root.left, Integer.MIN_VALUE, Integer.MAX_VALUE, max);
//            int rightBST = traverse(root.right, Integer.MIN_VALUE, Integer.MAX_VALUE, max);
//            max[0] = Math.max(max[0], Math.max(leftBST, rightBST));
//            return -1;
//        }
//    }

    // time complexity: O(n)
    // space complexity: O(height)
    public int largestBSTSubtree(TreeNode root) {
        return traverse(root)[2];
    }

    private int[] traverse(TreeNode root) {
        // base case
        if (root == null) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        if (root.left == null && root.right == null) {
            return new int[]{root.val, root.val, 1};
        }

        // recursive case
        int[] left = traverse(root.left);
        int[] right = traverse(root.right);

        // case 1: BST
        // case 2: otherwise
        if (left[1] < root.val && right[0] > root.val) {
            int leftBound = Math.min(left[0], root.val);
            int rightBound = Math.max(right[1], root.val);
            return new int[]{leftBound, rightBound, left[2] + right[2] + 1};
        } else {
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left[2], right[2])};
        }
    }

    public static void main(String[] args) {
        LargestBSTSubtree test = new LargestBSTSubtree();
//        TreeNode root = new TreeNode(4);
//        TreeNode node1 = new TreeNode(2);
//        TreeNode node2 = new TreeNode(6);
//        TreeNode node3 = new TreeNode(1);
//        TreeNode node4 = new TreeNode(3);
//        TreeNode node5 = new TreeNode(5);
//        root.left = node1;
//        root.right = node2;
//        node1.left = node3;
//        node1.right = node4;
//        node2.left = node5;

        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(11);
        TreeNode node2 = new TreeNode(15);
        TreeNode node3 = new TreeNode(12);
        TreeNode node4 = new TreeNode(8);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(6);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        node5.left = node6;
        System.out.println(test.largestBSTSubtree(root));
    }
}
