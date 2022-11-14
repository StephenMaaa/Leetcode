package Tree;

/*
Given a binary tree, return its border view. The border view is defined as follow: first get all the border nodes at left side(from root and always go to the left subtree unless the left subtree does not exist until reach a leaf node), then get all the leaf nodes(from left to right), at last get all the border nodes at right side(similar to left border but from bottom to top), the list of border view should not contain duplicate nodes. Note that for the given root, if it has no left sub-tree or right sub-tree, it is considered the left border/right border, but this rule applies to only the input tree not any sub-tree of it.

        Example 1:

        1
        /    \
        2      3
        / \    /  \
        4   5   6  7
        \          \
        9           8
        \
        11

        the border view = [1, 2, 4, 9, 11, 5, 8, 7, 3]

        1, 2, 4, 9, 11 are the left border, 11, 5, 8, 7 are the leaf nodes, 7, 3, 1 are the right border.

        Example 2:

        1
        \
        3
        /  \
        4   5
        \
        6

        the border view = [1 6 5 3]

        In this case, the left border contains only one node [1], because the root doesn't have a left child.

        Example 3:

        1
        /   \
        2      3
        \        \
        4       5
        /
        6

        the border view = [1, 2, 4, 6, 5, 3]

        In this case, the left border contains [1, 2, 4, 6].
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BorderViewOfBinaryTree {
    // time complexity: O(n)
    // space complexity: O(n)
    public List<Integer> borderView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> dup = new HashSet<>();

        // edge case
        if (root == null) {
            return res;
        }

        res.add(root.val);
        dup.add(root.val);

        // traverse leftmost
//        TreeNode curr = root;
//        while (curr != null) {
//            res.add(curr.val);
//            dup.add(curr.val);
//
//            if (curr.left != null) {
//                curr = curr.left;
//            } else {
//                curr = curr.right;
//            }
//        }
        if (root.left != null) {
            traverseLeft(root, res, dup);
        }

        // traverse leaf node
        traverseLeaf(root, res, dup);

        // traverse rightmost
        if (root.right != null) {
            traverseRight(root, res, dup);
        }

        return res;
    }

    private void traverseLeft(TreeNode root, List<Integer> res, Set<Integer> dup) {
        // base case
        if (root == null) {
            return;
        }

        if (!dup.contains(root.val)) {
            res.add(root.val);
            dup.add(root.val);
        }

        // recursive case
        if (root.left != null) {
            traverseLeft(root.left, res, dup);
        } else {
            traverseLeft(root.right, res, dup);
        }
    }

    private void traverseLeaf(TreeNode root, List<Integer> res, Set<Integer> dup) {
        // base case
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            if (!dup.contains(root.val)) {
                res.add(root.val);
                dup.add(root.val);
            }
            return;
        }

        // recursive case
        traverseLeaf(root.left, res, dup);
        traverseLeaf(root.right, res, dup);
    }

    private void traverseRight(TreeNode root, List<Integer> res, Set<Integer> dup) {
        // base case
        if (root == null) {
            return;
        }

        // recursive case
        if (root.right != null) {
            traverseRight(root.right, res, dup);
        } else {
            traverseRight(root.left, res, dup);
        }


        if (!dup.contains(root.val)) {
            res.add(root.val);
            dup.add(root.val);
        }
    }

    public static void main(String[] args) {
        BorderViewOfBinaryTree test = new BorderViewOfBinaryTree();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(6);
        root.right = node1;
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        System.out.println(test.borderView(null));
    }
}
