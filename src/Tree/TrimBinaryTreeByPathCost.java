package Tree;

/*
Given a binary tree, the path cost from the root node to each leaf node is defined to be the number of levels that the leaf is on.

        For example, in the following binary tree, the node 5 has its path cost to be 3, and node 8 has its path cost to be 4.

        1

        /       \

        2             3

        /     \             \

        4          5             6

        /   \                      /

        7      8                  9

        Given a binary tree, try to delete all the nodes that have no paths whose cost is >= k that go through it. In the above example, node 5 will be deleted  for k = 4.
*/

public class TrimBinaryTreeByPathCost {
    // time complexity: O(n)
    // space complexity: O(height)
    public TreeNode trimTree(TreeNode root, int k) {
        return trim(root, 0, k);
    }

    private TreeNode trim(TreeNode root, int level, int k) {
        // base case
        if (root == null) {
            return null;
        }

        level++;
        root.left = trim(root.left, level, k);
        root.right = trim(root.right, level, k);

        // case 1: tree node with path >= k
        // case 2: otherwise
        if (root.left == null && root.right == null && level < k) {
            return null;
        } else {
            return root;
        }
    }

    public static void main(String[] args) {
        TrimBinaryTreeByPathCost test = new TrimBinaryTreeByPathCost();
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        node4.left = node7;
        node4.right = node8;
        node6.left = node9;
        root = test.trimTree(root, 5);
    }
}
