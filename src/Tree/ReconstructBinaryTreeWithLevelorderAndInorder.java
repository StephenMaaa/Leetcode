package Tree;

/*
Given the levelorder and inorder traversal sequence of a binary tree, reconstruct the original tree.

        Assumptions

        The given sequences are not null and they have the same length
        There are no duplicate keys in the binary tree
        Examples

        levelorder traversal = {5, 3, 8, 1, 4, 11}

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

public class ReconstructBinaryTreeWithLevelorderAndInorder {
    // time complexity: O(n^2)
    // space complexity: O(height)
    public TreeNode reconstruct(int[] inOrder, int[] levelOrder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }

        return construct(inOrder, levelOrder, 0, inOrder.length - 1, 0, map);
    }

    private TreeNode construct(int[] inOrder, int[] levelOrder, int inStart, int inEnd, int index, Map<Integer, Integer> map) {
        // base case
        if (inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(levelOrder[index]);
        int mid = map.get(root.val);

        // construct left and right subtrees
        for (int i = index + 1; i < levelOrder.length; i++) {
            int inOrderIndex = map.get(levelOrder[i]);

            // check if levelOrder[i] is in inOrder range of left subtree
            if (root.left == null && inOrderIndex >= inStart && inOrderIndex <= mid - 1) {
                root.left = construct(inOrder, levelOrder, inStart, mid - 1, i, map);
            }

            // check if levelOrder[i] is in inOrder range of right subtree
            if (root.right == null && inOrderIndex >= mid + 1 && inOrderIndex <= inEnd) {
                root.right = construct(inOrder, levelOrder, mid + 1, inEnd, i, map);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        ReconstructBinaryTreeWithLevelorderAndInorder test = new ReconstructBinaryTreeWithLevelorderAndInorder();
        int[] levelorder = new int[]{5, 3, 8, 1, 4, 11};
        int[] inorder = new int[]{1, 3, 4, 5, 8, 11};
        TreeNode root = test.reconstruct(inorder, levelorder);
    }
}
