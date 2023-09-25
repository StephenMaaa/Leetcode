package Tree;

/*
Given two nodes in a binary tree, find their lowest common ancestor.

        Assumptions

        There is no parent pointer for the nodes in the binary tree

        The given two nodes are guaranteed to be in the binary tree

        Examples

        5

        /   \

        9     12

        /  \      \

        2    3      14

        The lowest common ancestor of 2 and 14 is 5

        The lowest common ancestor of 2 and 9 is 9
*/

public class LCA {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode one, TreeNode two) {
        // base case: root == null | root == one | root == two
        if (root == null || root == one || root == two) {
            return root;
        }

        TreeNode left = lowestCommonAncestor2(root.left, one, two);
        TreeNode right = lowestCommonAncestor2(root.right, one, two);

        // case 1: left != null && right != null
        if (left != null && right != null) {
            return root;
        }

        // case 2: at least one of LCA children is null (1 null || 2 nulls)
        return left == null ? right : left;
    }

    // approach 1: Recursion TC: O(n) SC: O(height)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if (root == null || root == p || root == q) {
            return root;
        }

        // recursive case
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // check
        // case 1: both empty -> no ancestor
        // case 2: 1 empty -> the non-empty node is ancestor
        // case 3: no empty -> the current node is ancestor
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}
