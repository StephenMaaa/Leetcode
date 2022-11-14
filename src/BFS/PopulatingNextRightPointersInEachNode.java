package BFS;

/*
You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class PopulatingNextRightPointersInEachNode {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    // approach 1 - BFS TC: O(n) SC: O(n)
    public Node connect(Node root) {
        Deque<Node> queue = new ArrayDeque<>();

        // edge case
        if (root == null) {
            return null;
        }

        queue.offerFirst(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Node next = null;

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                node.next = next;
                next = node;

                // add left and right nodes
                if (node.right != null) {
                    queue.offer(node.right);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
            }
        }
        return root;
    }

    // approach 2 - DFS TC: O(n) SC: O(logn)
    public Node connect2(Node root) {
        // base case
        if (root == null) {
            return null;
        }

        // recursive case
        // connect left
        if (root.left != null) {
            root.left.next = root.right;
        }

        // connect right
        if (root.right != null && root.next != null) {
            root.right.next = root.next.left;
        }

        connect(root.left);
        connect(root.right);
        return root;
    }
}
