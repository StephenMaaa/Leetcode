package Tree;

/*
Given the preorder traversal sequence of a binary search tree, reconstruct the original tree.

        Assumptions

        The given sequence is not null
        There are no duplicate keys in the binary search tree
        Examples

        preorder traversal = {5, 3, 1, 4, 8, 11}

        The corresponding binary search tree is

        5

        /    \

        3        8

        /   \        \

        1      4        11
*/

public class ReconstructBSTWithPreorder {
    // time complexity: O(n)
    // space complexity: O(height)
    public TreeNode reconstruct(int[] pre) {
        int[] start = new int[1];
        return construct(pre, start, Integer.MAX_VALUE);
    }

    private TreeNode construct(int[] pre, int[] start, int max) {
        // base case
        if (start[0] >= pre.length || pre[start[0]] > max) {
            return null;
        }

        TreeNode root = new TreeNode(pre[start[0]++]);
        root.left = construct(pre, start, root.val);
        root.right = construct(pre, start, max);
        return root;
    }

    public static void main(String[] args) {
        ReconstructBSTWithPreorder test = new ReconstructBSTWithPreorder();
        int[] preorder = new int[]{};
        TreeNode root = test.reconstruct(preorder);
    }
}
