package Tree;

/*
Diagonal sum in a binary tree is the sum of all the node’s data lying through the dashed lines. Given a Binary Tree, print all diagonal sums.

        For the above input tree, output should be:

        { 11, 14, 5 }
*/

import java.util.ArrayList;
import java.util.List;

public class DiagonalSumOfBinaryTree {
    // time complexity: O(n)
    // space complexity: O(height)
    public List<Integer> diagonalSum(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverse(root, 0, res);
        return res;
    }

    private void traverse(TreeNode root, int shift, List<Integer> res) {
        // base case
        if (root == null) {
            return;
        }

        // update
        if (res.size() == shift) {
            res.add(root.val);
        } else {
            res.set(shift, res.get(shift) + root.val);
        }

        // recursive case
        traverse(root.left, shift + 1, res);
        traverse(root.right, shift, res);
    }

    public static void main(String[] args) {
        DiagonalSumOfBinaryTree test = new DiagonalSumOfBinaryTree();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(1);
        TreeNode node8 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node4.left = node7;
        node5.right = node8;
        System.out.println(test.diagonalSum(null));
    }
}
