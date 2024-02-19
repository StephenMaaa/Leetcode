package Tree;

/*
LeetCode 105

Given the preorder and inorder traversal sequence of a binary tree, reconstruct the original tree.

        Assumptions

        The given sequences are not null and they have the same length
        There are no duplicate keys in the binary tree
        Examples

        preorder traversal = {5, 3, 1, 4, 8, 11}

        inorder traversal = {1, 3, 4, 5, 8, 11}

        the corresponding binary tree is

        5

        /    \

        3        8

        /   \        \

        1      4        11
*/

import java.util.HashMap;
import java.util.Map;

public class ReconstructBinaryTreeWithPreorderAndInorder {
//    // time complexity: O(n)
//    // space complexity: O(height)
//    public TreeNode reconstruct(int[] inOrder, int[] preOrder) {
//        // initialization
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < inOrder.length; i++) {
//            map.put(inOrder[i], i);
//        }
//        TreeNode root = construct(0, inOrder.length - 1, 0, preOrder.length - 1, inOrder, preOrder, map);
//        return root;
//    }
//
//    private TreeNode construct(int inStart, int inEnd, int preStart, int preEnd, int[] inorder, int[] preorder, Map<Integer, Integer> map) {
//        // base case
//        if (inStart > inEnd) {
//            return null;
//        }
//
//        TreeNode root = new TreeNode(preorder[preStart]);
//        int mid = map.get(preorder[preStart]);
//        root.left = construct(inStart, mid - 1, preStart + 1, preStart + mid - inStart, inorder, preorder, map);
//        root.right = construct(mid + 1, inEnd, preStart + mid - inStart + 1, preEnd, inorder, preorder, map);
//        return root;
//    }

    // approach 1: Traversal TC: O(n) SC: O(n)
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // initialization
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(0, inorder.length - 1, 0, preorder.length - 1, inorder, preorder, map);
    }

    private TreeNode build(int inStart, int inEnd, int preStart, int preEnd, int[] inorder, int[] preorder, Map<Integer, Integer> map) {
        // base case
        if (inStart > inEnd) {
            return null;
        }

        // recursive case
        TreeNode root = new TreeNode(preorder[preStart]);
        int mid = map.get(preorder[preStart]);
        root.left = build(inStart, mid - 1, preStart + 1, preStart + mid - inStart, inorder, preorder, map);
        root.right = build(mid + 1, inEnd, preStart + mid - inStart + 1, preEnd, inorder, preorder, map);
        return root;
    }

    public static void main(String[] args) {
        ReconstructBinaryTreeWithPreorderAndInorder test = new ReconstructBinaryTreeWithPreorderAndInorder();
        int[] inorder = new int[]{};
        int[] preorder = new int[]{};
//        System.out.println(test.reconstruct(inorder, preorder));
        TreeNode root = test.buildTree(inorder, preorder);
    }
}
