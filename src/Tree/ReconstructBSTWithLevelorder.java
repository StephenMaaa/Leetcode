package Tree;

/*
Given the levelorder traversal sequence of a binary search tree, reconstruct the original tree.

        Assumptions

        The given sequence is not null
        There are no duplicate keys in the binary search tree
        Examples

        levelorder traversal = {5, 3, 8, 1, 4, 11}

        the corresponding binary search tree is

        5

        /    \

        3        8

        /   \        \

        1      4        11
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class ReconstructBSTWithLevelorder {
//    // time complexity: O(n)
//    // space complexity: O(n)
//    public TreeNode reconstruct(int[] level) {
//        // edge case
//        if (level.length == 0) {
//            return null;
//        }
//
//        Deque<TreeNode> queue = new ArrayDeque<>();
//        int i = 0;
//        TreeNode root = new TreeNode(level[i++]);
//        queue.offerLast(root);
//
//        while (!queue.isEmpty() && i < level.length) {
//            TreeNode node = queue.pollFirst();
//
//            // check left subtree
//            if (level[i] < node.val) {
//                node.left = new TreeNode(level[i++]);
//                queue.offerLast(node.left);
//            }
//
//            // check right subtree
//            if (i < level.length && level[i] > node.val) {
//                node.right = new TreeNode(level[i++]);
//                queue.offerLast(node.right);
//            }
//        }
//        return root;


    // time complexity: O(n^2)
    // space complexity: O(height)
    public TreeNode reconstruct(int[] level) {
        return construct(level, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode construct(int[] level, int index, int leftBound, int rightBound) {
        // base case
        if (index >= level.length) {
            return null;
        }

        TreeNode root = new TreeNode(level[index]);

        // construct left subtree and right subtree
        for (int i = index + 1; i < level.length; i++) {
            if (root.left == null && level[i] < root.val && level[i] > leftBound) {
                root.left = construct(level, i, leftBound, root.val);
            }

            if (root.right == null && level[i] > root.val && level[i] < rightBound) {
                root.right = construct(level, i, root.val, rightBound);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        ReconstructBSTWithLevelorder test = new ReconstructBSTWithLevelorder();
        int[] levelorder = new int[]{3,2,8,1,5,12,4,7,10,13};
        TreeNode root = test.reconstruct(levelorder);
    }
}
