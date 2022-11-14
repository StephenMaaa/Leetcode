package BinarySearch;
import Tree.TreeNode;
/*
In a binary search tree, find the node containing the closest number to the given target number.

        Assumptions:

        The given root is not null.
        There are no duplicate keys in the binary search tree.
        Examples:

        5

        /    \

        2      11

        /    \

        6     14

        closest number to 4 is 5

        closest number to 10 is 11

        closest number to 6 is 6
*/

public class ClosestNumberInBST {
    public int closest(TreeNode root, int target) {
        int min = Integer.MAX_VALUE;
        TreeNode minNode = null;
        while (root != null) {
            // case 1: val == target
            // case 2: val < target
            // case 3: val > target
            if (root.val == target) {
                return target;
            } else {
                if (min > Math.abs(root.val - target)) {
                    min = Math.abs(root.val - target);
                    minNode = root;
                }
                if (root.val < target) {
                    root = root.right;
                } else {
                    root = root.left;
                }
            }
        }
        return minNode.val;
    }

//    private void bs(TreeNode root, int target, int[] min, TreeNode minNode) {
//        // base case
//        if (root == null) {
//            return;
//        }
//
//        if ()
//    }
}
