package Tree;

/*
Determine if a given binary tree is full.

        A full binary tree is defined as a binary tree in which all nodes have either zero or two child nodes. Conversely, there is no node in a full binary tree, which has one child node.

        If the root is null, return false.
*/

public class DetermineIfBinaryTreeIsFullTree {
    // time complexity: O(n)
    // space complexity: O(height)
    public boolean isFull(TreeNode root) {
        // base case
        if (root == null) {
            return false;
        }

        // recursive case
        // case 1: both null
        // case 2: both not null
        // case 3: only 1 null
        if (root.left == null && root.right == null) {
            return true;
        } else if (root.left != null && root.right != null) {
            return isFull(root.left) && isFull(root.right);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        DetermineIfBinaryTreeIsFullTree test = new DetermineIfBinaryTreeIsFullTree();
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        System.out.println(test.isFull(null));
    }
}
