package Tree;

/*
Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

        If two nodes are in the same row and column, the order should be from left to right.

        Examples:

        Given binary tree [3,9,20,null,null,15,7],
        3
        /\
        /  \
        9  20
        /\
        /  \
        15   7
        return its vertical order traversal as:

        [9,3,15,20,7]
        Given binary tree [3,9,8,4,0,1,7],
        3
        /\
        /  \
        9   8
        /\  /\
        /  \/  \
        4  01   7
        return its vertical order traversal as:

        [4,9,3,0,1,8,7]
        Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
        3
        /\
        /  \
        9   8
        /\  /\
        /  \/  \
        4  01   7
          /\
         /  \
        5   2
        return its vertical order traversal as:

        [4,9,5,3,0,1,8,2,7]
*/

import java.util.*;

public class VerticalOrderTraversal {
    // time complexity: O(n)
    // space complexity: O(n)
    public List<Integer> verticalOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        traverse(root, map);

        for (int key : map.keySet()) {
            res.addAll(map.get(key));
        }
        return res;
    }

//    private void traverse(TreeNode root, int center, TreeMap<Integer, List<Integer>> map) {
//        // base case
//        if (root == null) {
//            return;
//        }
//
//        // recursive case
//        if (!map.containsKey(center)) {
//            map.put(center, new ArrayList<>());
//        }
//        map.get(center).add(root.val);
//
//        traverse(root.left, center - 1, map);
//        traverse(root.right, center + 1, map);
//    }

    private void traverse(TreeNode root, TreeMap<Integer, List<Integer>> map) {
        // edge case
        if (root == null) {
            return;
        }

        // BFS
        Deque<TreeNode> queue = new ArrayDeque<>();
        Deque<Integer> centerQueue = new ArrayDeque<>();
        queue.offer(root);
        centerQueue.offer(0);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int center = centerQueue.poll();

                if (!map.containsKey(center)) {
                    map.put(center, new ArrayList<>());
                }
                map.get(center).add(node.val);

                // add left and right subtrees
                if (node.left != null) {
                    queue.offer(node.left);
                    centerQueue.offer(center - 1);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                    centerQueue.offer(center + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        VerticalOrderTraversal test = new VerticalOrderTraversal();
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
        System.out.println(test.verticalOrder(null));
    }
}
