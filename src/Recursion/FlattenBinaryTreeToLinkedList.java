package Recursion;

/*
LeetCode 114

Given a binary tree, flatten it to a linked list in-place.

        For example,
        Given

        1
        / \
        2   5
        / \   \
        3   4   6
        The flattened tree should look like:

        1
        \
        2
        \
        3
        \
        4
        \
        5
        \
        6
*/

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Queue;

public class FlattenBinaryTreeToLinkedList {
//    public TreeNode flatten(TreeNode root) {
//        TreeNode head = new TreeNode(-1);
//        traverse(root, head);
//        return head.right;
//    }
//
//    private TreeNode traverse(TreeNode root, TreeNode head) {
//        // base case
//        if (root == null) {
//            return head;
//        }
//
//        head.right = new TreeNode(root.key);
//        head = head.right;
//
//        head = traverse(root.left, head);
//        head = traverse(root.right, head);
//        return head;
//    }

//    public TreeNode flatten(TreeNode root) {
//        TreeNode[] head = new TreeNode[1];
//        traverse(root, head);
//        return root;
//    }
//
//    private void traverse(TreeNode root, TreeNode[] head) {
//        // base case
//        if (root == null) {
//            return;
//        }
//
//        traverse(root.right, head);
//        traverse(root.left, head);
//        root.right = head[0];
//        root.left = null;
//        head[0] = root;
//    }

    // approach 1: Recursion TC: O(n) SC: O(height)
    public void flatten2(TreeNode root) {
        TreeNode[] head = new TreeNode[]{new TreeNode(0)};
        traverse(root, head);
    }

    private void traverse(TreeNode root, TreeNode[] head) {
        // base case
        if (root == null) {
            return;
        }

        // recursive case
        // preorder traversal
        head[0].right = root;
        head[0] = root;
//        System.out.println(root.key);
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;

        traverse(left, head);
        traverse(right, head);
    }

    // approach 2: Iteration TC: O(n) SC: O(n)
    public void flatten3(TreeNode root) {
        // edge case
        if (root == null) {
            return;
        }

        TreeNode head = new TreeNode(0);
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.offerFirst(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pollFirst();
            head.right = node;
            head = node;

            // expand
            if (node.right != null) {
                stack.offerFirst(node.right);
            }

            if (node.left != null) {
                stack.offerFirst(node.left);
            }
            node.left = null;
        }
    }

    // approach 3: Advanced Iteration TC: O(n) SC: O(1)
    public void flatten(TreeNode root) {
        while (root != null) {
            // case 1: valid left
            // case 2: invalid
            if (root.left != null) {
                // find rightmost node
                TreeNode rightmost = root.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }

                // append right node to the rightmost
                rightmost.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }

    public static void main(String[] args) {
        FlattenBinaryTreeToLinkedList test = new FlattenBinaryTreeToLinkedList();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        root.left = node1;
        root.right = node4;
        node1.left = node2;
        node1.right = node3;
        node4.right = node5;
        test.flatten(root);
//        while (ans != null) {
//            System.out.println(ans.key);
//            ans = ans.right;
//        }
    }
}
