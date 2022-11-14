package Tree;

/*
Given the postorder and inorder traversal sequence of a binary tree, reconstruct the original tree.

        Assumptions

        The given sequences are not null and they have the same length
        There are no duplicate keys in the binary tree
        Examples

        postorder traversal = {1, 4, 3, 11, 8, 5}

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

public class ReconstructBinaryTreeWithPostorderAndInorder {
    // time complexity: O(n)
    // space complexity: O(height)
    public TreeNode reconstruct(int[] inOrder, int[] postOrder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }

        return construct(inOrder, postOrder, 0, inOrder.length - 1, 0, postOrder.length - 1, map);
    }

    private TreeNode construct(int[] inOrder, int[] postOrder, int inStart, int inEnd, int postStart, int postEnd, Map<Integer, Integer> map) {
        // base case
        if (inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postOrder[postEnd]);
        int mid = map.get(postOrder[postEnd]);
        root.right = construct(inOrder, postOrder, mid + 1, inEnd, postEnd - inEnd + mid, postEnd - 1, map);
        root.left = construct(inOrder, postOrder, inStart, mid - 1, postStart, postEnd - inEnd + mid - 1, map);
        return root;
    }

    public static void main(String[] args) {
        ReconstructBinaryTreeWithPostorderAndInorder test = new ReconstructBinaryTreeWithPostorderAndInorder();
        int[] postorder = new int[]{1, 4, 3, 11, 8, 5};
        int[] inorder = new int[]{1, 3, 4, 5, 8, 11};
        TreeNode root = test.reconstruct(inorder, postorder);
    }
}
