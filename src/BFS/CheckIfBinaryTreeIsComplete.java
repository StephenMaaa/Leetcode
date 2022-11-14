package BFS;

/*
Check if a given binary tree is completed. A complete binary tree is one in which every level of the binary tree is completely filled except possibly the last level. Furthermore, all nodes are as far left as possible.

        Examples

        5

        /    \

        3        8

        /   \

        1      4

        is completed.

        5

        /    \

        3        8

        /   \        \

        1      4        11

        is not completed.

        Corner Cases

        What if the binary tree is null? Return true in this case.
*/

import java.util.ArrayDeque;
import java.util.Queue;

public class CheckIfBinaryTreeIsComplete {
//    public boolean isCompleted(TreeNode root) {
//        // edge case
//        if (root == null) {
//            return true;
//        }
//
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        queue.offer(root);
//        int level = 0;
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            boolean checked = false;
//            for (int i = 0; i < size; i++) {
//                TreeNode node = queue.poll();
//
//                // case 1: left empty, right exists
//                // case 2: left node not complete (empty / only left child), right node complete
//                if (node.left == null) {
//                    if (node.right == null) {
//                        checked = true;
//                    } else {
//                        return false;
//                    }
//                } else {
//                    if (node.right == null) {
//                        checked = true;
//                    } else {
//                        if (checked) {
//                            return false;
//                        }
//                    }
//                }
//
//                if (node.left != null) {
//                    queue.offer(node.left);
//                }
//                if (node.right != null) {
//                    queue.offer(node.right);
//                }
//            }
//
//            // check complete level
//            if (queue.size() > 0 && size != (int) Math.pow(2, level)) {
//                return false;
//            }
//            level++;
//        }
//        return true;
//    }

    public boolean isCompleted(TreeNode root) {
        // edge case
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean checked = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // case 1: left empty, right exists
            // case 2: left node not complete (empty / only left child), right node complete
            if (node.left == null) {
                checked = true;
            } else if (checked) {
                return false;
            } else {
                queue.offer(node.left);
            }

            if (node.right == null) {
                checked = true;
            } else if (checked) {
                return false;
            } else {
                queue.offer(node.right);
            }
        }
        return true;
    }
}
