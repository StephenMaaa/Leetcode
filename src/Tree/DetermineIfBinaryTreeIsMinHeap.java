package Tree;

/*
Determine if the given binary tree is min heap.
*/

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.ArrayDeque;
import java.util.Deque;

public class DetermineIfBinaryTreeIsMinHeap {
//    // time complexity: O(n)
//    // space complexity: O(height)
//    public boolean isMinHeap(TreeNode root) {
//        // check complete
//
//        return traverse(root, Integer.MIN_VALUE);
//    }
//
//    private boolean traverse(TreeNode root, int parent) {
//        // base case
//        if (root == null) {
//            return true;
//        }
//
//        // recursive case
//        if (root.val >= parent) {
//            return traverse(root.left, root.val) && traverse(root.right, root.val);
//        } else {
//            return false;
//        }
//    }

    // time complexity: O(n)
    // space complexity: O(n)
    public boolean isMinHeap(TreeNode root) {
        // edge case
        if (root == null) {
            return true;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean flag = false;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // case 1: x flag
                // case 2: flag
                if (!flag) {
                    // case 1: x left && x right
                    // case 2: left && x right
                    // case 3: x left && right
                    // case 4: left && right
                    if (node.left == null && node.right == null) {
                        flag = true;
                    } else if (node.right == null) {
                        if (node.left.val >= node.val) {
                            queue.offer(node.left);
                            flag = true;
                        } else {
                            return false;
                        }
                    } else if (node.left == null) {
                        return false;
                    } else {
                        if (node.left.val >= node.val) {
                            queue.offer(node.left);
                        } else {
                            return false;
                        }

                        if (node.right.val >= node.val) {
                            queue.offer(node.right);
                        } else {
                            return false;
                        }
                    }
                } else {
                    // case 1: both null
                    // case 2: otherwise
                    if (node.left == null && node.right == null) {
                        continue;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        DetermineIfBinaryTreeIsMinHeap test = new DetermineIfBinaryTreeIsMinHeap();
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
        System.out.println(test.isMinHeap(root));
    }
}
