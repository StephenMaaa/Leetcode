package Tree;

/*
Given K nodes in a binary tree, find their lowest common ancestor.

        Assumptions

        K >= 2

        There is no parent pointer for the nodes in the binary tree

        The given K nodes are guaranteed to be in the binary tree

        Examples

        5

        /   \

        9     12

        /  \      \

        2    3      14

        The lowest common ancestor of 2, 3, 14 is 5

        The lowest common ancestor of 2, 3, 9 is 9
*/

import java.util.List;

public class LCAIV {
    // same as LCA with 2 nodes
    public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
        // base case
        if (root == null || nodes.contains(root)) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, nodes);
        TreeNode right = lowestCommonAncestor(root.right, nodes);

        // case 1: both not null
        if (left != null && right != null) {
            return root;
        }
        // case 2: at least one null
        return left == null ? right : left;
    }
}
