package Tree;

/*
Determine the length of the longest ascending path in the binary tree.

        A valid path is a part of the path from root to any of the leaf nodes.

        Examples:

        5

        /    \

        3        2

        /   \        \

        1      0        11

        the longest ascending path is 2 -> 11, length is 2.
*/

public class LongestAscendingPathBinaryTree {
    // time complexity: O(n)
    // space complexity: O(height)
    public int longest(TreeNode root) {
        int[] max = new int[1];
        traverse(root, Integer.MIN_VALUE, 0, max);
        return max[0];
    }

    private void traverse(TreeNode root, int prev, int count, int[] max) {
        // base case
        if (root == null) {
            return;
        }

        // case 1: root.val > prev
        // case 2: otherwise
        if (root.val > prev) {
            count++;
        } else {
            count = 1;
        }

        // update max
        max[0] = Math.max(max[0], count);

        // check left and right subtrees
        traverse(root.left, root.val, count, max);
        traverse(root.right, root.val, count, max);
    }

    public static void main(String[] args) {
        LongestAscendingPathBinaryTree test = new LongestAscendingPathBinaryTree();
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(11);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        System.out.println(test.longest(null));
    }
}
