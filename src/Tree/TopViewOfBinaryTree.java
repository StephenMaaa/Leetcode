package Tree;

/*
Given a binary tree, get the top view of it. The nodes in the output list should be from left to right. A node x belongs to the output if x is the topmost node at its column.

        Examples:

        1
        /   \
        2     3
        / \   / \
        4  (5,6)  7

        the top view is [4, 2, 1, 3, 7]
*/

import java.util.*;

public class TopViewOfBinaryTree {
    // time complexity: O(n)
    // space complexity: O(n)
    public List<Integer> topView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        // edge case
        if (root == null) {
            return res;
        }

        // BFS
        Deque<TreeNode> queue = new ArrayDeque<>();
        Deque<Integer> centerQueue = new ArrayDeque<>();
        Map<Integer, Integer> map = new TreeMap<>();
        queue.offer(root);
        centerQueue.offer(0);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int center = centerQueue.poll();

            // check if node is on the top view
            if (!map.containsKey(center)) {
                map.put(center, node.val);
            }

            // expand left and right subtrees
            if (node.left != null) {
                queue.offer(node.left);
                centerQueue.offer(center - 1);
            }

            if (node.right != null) {
                queue.offer(node.right);
                centerQueue.offer(center + 1);
            }
        }

        // process
        for (int key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }

    public static void main(String[] args) {
        TopViewOfBinaryTree test = new TopViewOfBinaryTree();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        System.out.println(test.topView(null));
    }
}
