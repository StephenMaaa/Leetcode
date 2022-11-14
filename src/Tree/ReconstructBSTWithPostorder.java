package Tree;

/*
Given the postorder traversal sequence of a binary search tree, reconstruct the original tree.

        Assumptions

        The given sequence is not null
        There are no duplicate keys in the binary search tree
        Examples

        postorder traversal = {1, 4, 3, 11, 8, 5}

        the corresponding binary search tree is

        5

        /    \

        3        8

        /   \        \

        1      4        11
*/

import sun.reflect.generics.tree.Tree;

public class ReconstructBSTWithPostorder {
    // time complexity: O(n)
    // space complexity: O(height)
    public TreeNode reconstruct(int[] post) {
        // initialization
        int[] end = new int[1];
        end[0] = post.length - 1;
        return construct(post, end, Integer.MIN_VALUE);
    }

    private TreeNode construct(int[] post, int[] end, int min) {
        // base case (reaches end or left subtree)
        if (end[0] < 0 || post[end[0]] < min) {
            return null;
        }

        TreeNode root = new TreeNode(post[end[0]--]);
        root.right = construct(post, end, root.val);
        root.left = construct(post, end, min);
        return root;
    }

    public static void main(String[] args) {
        ReconstructBSTWithPostorder test = new ReconstructBSTWithPostorder();
        int[] postorder = new int[]{1, 4, 3, 11, 8, 5};
        TreeNode root = test.reconstruct(postorder);
    }
}
