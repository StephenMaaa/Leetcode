package Tree;

/*
Given a root node of binary search tree, a lower bound and an upper bound, remove nodes that are outside of [lower, upper]. Return the root node after trimming the binary search tree. The root returned may not the same as the given root node. Return root as null if entire tree has been trimmed.

        Example:

        Input: root = [5,2,8,1,3,6,9]   lower = 2, upper = 4

        5

        /    \

        2       8

        /   \    /  \

        1   3   6    9

        Output: [2, null, 3]

        2

        \

        3
*/

public class TrimBST {
    // time complexity: O(n)
    // space complexity: O(height)
    public TreeNode trimBST(TreeNode root, int lower, int upper) {
        // base case
        if (root == null) {
            return null;
        }

        // case 1: root.val > rightBound
        // case 2: root.val < leftBound
        // case 3: in range
        if (root.val > upper) {
            return trimBST(root.left, lower, upper);
        } else if (root.val < lower) {
            return trimBST(root.right, lower, upper);
        } else {
            root.left = trimBST(root.left, lower, upper);
            root.right = trimBST(root.right, lower, upper);
            return root;
        }
    }

    public static void main(String[] args) {
        TrimBST test = new TrimBST();
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(9);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        root = test.trimBST(root, 2, 4);
    }
}
