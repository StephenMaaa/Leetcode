package Tree;

/*
LeetCode 117

Given a binary tree

        struct Node {
        int val;
        Node *left;
        Node *right;
        Node *next;
        }
        Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

        Initially, all next pointers are set to NULL.
*/

import java.util.ArrayList;
import java.util.List;

public class PopulatingNextRightPointersInEachNodeII {
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

    // approach 1: Iteration - Level-order Traversal TC: O(n) SC: O(n)
    public Node connect(Node root) {
        // edge case
        if (root == null) {
            return root;
        }

        // init
        List<Node> level = new ArrayList<>();
        level.add(root);

        // BFS - level-order traversal
        while (level.size() > 0) {
            Node last = null;
            List<Node> nextLevel = new ArrayList<>();

            for (Node node : level) {
                // set next pointer
                if (last != null) {
                    last.next = node;
                }
                last = node;

                // expand left and right subtrees
                if (node.left != null) {
                    nextLevel.add(node.left);
                }

                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }

            // update level
            level = nextLevel;
        }
        return root;
    }

    // approach 2: Advanced Iteration + Level-order Traversal TC: O(n) SC: O(1)
    public Node connect2(Node root) {
        // init
        Node level = root;

        // BFS - level-order traversal
        Node nextLevel = new Node();
        Node next = nextLevel;
        while (level != null) {
            // expand left and right subtrees
            if (level.left != null) {
                next.next = level.left;
                next = next.next;
            }

            if (level.right != null) {
                next.next = level.right;
                next = next.next;
            }

            // move to the next
            level = level.next;

            // update next level
            if (level == null) {
                level = nextLevel.next;
                nextLevel = new Node();
                next = nextLevel;
            }
        }
        return root;
    }
}
