package Tree;

/*
Given a Binary Search Tree with only two nodes swapped. Try to find them and recover the binary search tree.

        Input:

        4

        / \

        2   6

        / \   / \

        1  5 3  7

        Output:       4

        / \

        2   6

        /  \   / \

        1  3   5  7
*/

import java.util.ArrayList;
import java.util.List;

public class RecoverBinarySearchTree {
    public TreeNode recover(TreeNode root) {
        // edge case
        if (root == null) {
            return null;
        }

        // in-order traversal
        List<TreeNode> list = new ArrayList<>();
        traverse(root, list);

        // search tree node A
        int pointerA = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).val > list.get(i + 1).val) {
                pointerA = i;
                break;
            }
        }

        // search tree node B
        int pointerB = 0;
        for (int i = list.size() - 1; i > 0; i--) {
            if (list.get(i).val < list.get(i - 1).val) {
                pointerB = i;
                break;
            }
        }

        // swap
        int temp = list.get(pointerA).val;
        list.get(pointerA).val = list.get(pointerB).val;
        list.get(pointerB).val = temp;
        return root;
    }

    private void traverse(TreeNode root, List<TreeNode> list) {
        // base case
        if (root == null) {
            return;
        }

        traverse(root.left, list);
        list.add(root);
        traverse(root.right, list);
    }

    public static void main(String[] args) {
        RecoverBinarySearchTree test = new RecoverBinarySearchTree();
        TreeNode root = new TreeNode(4);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        root.left = n2;
        root.right = n6;
        n2.left = n1;
        n2.right = n5;
        n6.left = n3;
        n6.right = n7;
        test.recover(null);
        System.out.println(n1.val);
        System.out.println(n3.val);
    }
}
