package BinarySearch;
import Tree.TreeNode;

/*
In a binary search tree, find the node containing the largest number smaller than the given target number.

        If there is no such number, return -2^31.

        Assumptions:

        The given root is not null.
        There are no duplicate keys in the binary search tree.
        Examples

        5

        /    \

        2      11

        /    \

        6     14

        largest number smaller than 1 is Integer.MIN_VALUE(Java) or INT_MIN(c++)

        largest number smaller than 10 is 6

        largest number smaller than 6 is 5
*/

public class LargestNumberSmallerInBST {
    public int largestSmaller(TreeNode root, int target) {
        int min = Integer.MAX_VALUE;
        TreeNode minNode = new TreeNode(Integer.MIN_VALUE);
        while (root != null) {
            // case 1: val == target - 1 return
            // case 2: val < target go right
            // case 3: val > target left
            if (root.val == target - 1) {
                return root.val;
            } else if (root.val < target) {
                if (min > target - root.val) {
                    min = target - root.val;
                    minNode = root;
                }
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return minNode.val;
    }
}
