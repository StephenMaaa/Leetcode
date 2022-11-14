package BFS;

/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values, from left to right. Only need to return lowest level

        Example:

        Given the below binary tree

        5

        /        \

        3          8

        /    \           \

        1       4         11

        return its bottom-up level order traversal as:

        [1, 4, 11],
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LevelOrderTraversalII {
    // time complexity: O(n)
    // space complexity: O(n)
    public List<Integer> levelOrderBottom(TreeNode root) {
        // edge case
        if (root == null) {
            return new ArrayList<>();
        }

        // BFS
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        List<Integer> res = new ArrayList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            res = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                res.add(node.key);

                // add left and right subtrees
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LevelOrderTraversalII test = new LevelOrderTraversalII();
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
        node2.left = node5;
        System.out.println(test.levelOrderBottom(root));
    }
}
