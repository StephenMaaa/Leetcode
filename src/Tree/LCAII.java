package Tree;

/*
Given two keys in a binary search tree, find their lowest common ancestor.

        Assumptions

        There is no parent pointer for the nodes in the binary search tree

        There are no duplicate keys in the binary search tree

        The given two nodes are guaranteed to be in the binary search tree

        Examples

        5

        /   \

        2     12

        /  \      \

        1    3      14

        The lowest common ancestor of 1 and 14 is 5

        The lowest common ancestor of 1 and 3 is 2
*/

public class LCAII {
//    public TreeNode lca(TreeNode root, int p, int q) {
//        // base case
//        if (root == null || root.val == p || root.val == q) {
//            return root;
//        }
////        if (root.val < p && root.val < q) {
////            return lca(root.right, p, q);
////        }
////        if (root.val > p && root.val > p) {
////            return lca(root.left, p, q);
////        }
//
//        TreeNode left = lca(root.left, p, q);
//        TreeNode right = lca(root.right, p, q);
//
//        if (left != null && right != null) {
//            return root;
//        }
//        return left == null ? right : left;
//    }

    public TreeNode lca(TreeNode root, int p, int q) {
        // iterative
        int min = Math.min(p, q);
        int max = Math.max(p, q);

        while (root != null) {
            if (root.val < min) {
                root = root.right;
            } else if (root.val > max) {
                root = root.left;
            } else {
                return root;
            }
        }
        return null;
    }
}
