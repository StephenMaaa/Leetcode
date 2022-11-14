package Recursion;

/*
Given a binary tree where all the right nodes are leaf nodes, flip it upside down and turn it into a tree with left leaf nodes as the root.

        Examples

        1

        /    \

        2        5

        /   \

        3      4

        is reversed to

        3

        /    \

        2        4

        /   \

        1      5
*/

public class ReverseBinaryTreeUpsideDown {
    public TreeNode reverse(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }

        TreeNode left = reverse(root.left);
        root.left.left = root;
        root.left.right = root.right;
        root.left = null;
        root.right = null;
        return left;
    }

    public TreeNode reverse2(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode ref = root;
        while (ref.left != null) {
            ref = ref.left;
        }
        reverseNode(root);
        return ref;
    }

    private TreeNode reverseNode(TreeNode root) {
        // base case
        if (root.left == null) {
            return root;
        }

        TreeNode left = reverseNode(root.left);
        left.left = root;
        left.right = root.right;
        root.left = null;
        root.right = null;
        return root;
    }

    public static void main(String[] args) {
        ReverseBinaryTreeUpsideDown test = new ReverseBinaryTreeUpsideDown();
        TreeNode root = new TreeNode(41);
        TreeNode a = new TreeNode(18);
        TreeNode b = new TreeNode(41);
        TreeNode c = new TreeNode(37);
        TreeNode d = new TreeNode(20);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        System.out.println(test.reverse(null));
    }
}
