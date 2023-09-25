package Tree;

/*
Given a Binary Tree, return the right view of it. Right view of a Binary Tree is list of nodes visible when tree is visited from Right side, the order of the nodes in the list should be from top to bottom level of the original tree.

        Examples:
        1
        /    \
        2      3
        / \    /  \
        4   5   6  7
        /            \
        9             8

        /  \

        10  11

        the right view =  [1, 3, 7, 8, 11]
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class RightViewOfBinaryTree {
    // approach 1 - BFS TC: O(n) SC: O(n)
    public List<Integer> rightView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        // edge case
        if (root == null) {
            return res;
        }

        // BFS
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // add left and right subtrees
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }

                // add the last node in every level
                if (i == size - 1) {
                    res.add(node.val);
                }
            }
        }
        return res;
    }

//    // approach 2 - DFS TC: O(n) SC: O(height)
//    public List<Integer> rightSideView(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        dfs(root, 0, res);
//        return res;
//    }
//
//    private void dfs(TreeNode root, int level, List<Integer> res) {
//        // base case
//        if (root == null) {
//            return;
//        }
//
//        // recursive case
//        if (level == res.size()) {
//            res.add(root.val);
//        }
//        dfs(root.right, level + 1, res);
//        dfs(root.left, level + 1, res);
//    }

    // approach 1: BFS TC: O(n) SC: O(n)
    public List<Integer> rightSideView2(TreeNode root) {
        // initialization
        List<Integer> res = new ArrayList<>();

        // edge case
        if (root == null) {
            return res;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        // BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // add left and right subtrees
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }

                // add the rightmost
                if (i == size - 1) {
                    res.add(node.val);
                }
            }
        }
        return res;
    }

    // approach 2: DFS TC: O(n) SC: O(height)
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res; 
    }

    private void dfs(TreeNode root, int level, List<Integer> res) {
        // base case
        if (root == null) {
            return;
        }

        if (level == res.size()) {
            res.add(root.val);
        }

        // recursive case
        // explore the right subtree first
        dfs(root.right, level + 1, res);
        dfs(root.left, level + 1, res);
    }

    public static void main(String[] args) {
        RightViewOfBinaryTree test = new RightViewOfBinaryTree();
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(5);
        TreeNode node8 = new TreeNode(2);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node4.right = node8;
        node5.left = node7;
        System.out.println(test.rightSideView(null));
    }
}
