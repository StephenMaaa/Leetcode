package Tree;

/*
Find distance between two given keys of a Binary Tree, no parent pointers are given. Distance between two nodes is the minimum number of edges to be traversed to reach one node from other.

        Assumptions:

        There are no duplicate keys in the binary tree.
        The given two keys are guaranteed to be in the binary tree.
        The given two keys are different.
        Examples:

        1

        /  \

        2    3

        / \  /  \

        4   5 6   7

        \

        8

        distance(4, 5) = 2

        distance(4, 6) = 4
*/

public class DistanceBetweenTwoNodesInBinaryTree {
    // time complexity: O(n)
    // space complexity: O(height)
    public int distance(TreeNode root, int k1, int k2) {
        // find LCA
        TreeNode lca = lca(root, k1, k2);

        // find relative depths of two nodes to LCA
        int[] d1 = new int[1];
        int[] d2 = new int[1];
        getHeight(lca, k1, 0, d1);
        getHeight(lca, k2, 0, d2);
        return d1[0] + d2[0];
    }

    private TreeNode lca(TreeNode root, int a, int b) {
        // base case
        if (root == null || root.val == a || root.val == b) {
            return root;
        }

        // recursive case
        TreeNode left = lca(root.left, a, b);
        TreeNode right = lca(root.right, a, b);

        // update
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }

    private void getHeight(TreeNode root, int target, int depth, int[] height) {
        // base case
        if (root == null) {
            return;
        }

        if (root.val == target) {
            height[0] = depth;
            return;
        }

        // recursive case
        getHeight(root.left, target, depth + 1, height);
        getHeight(root.right, target, depth + 1, height);
    }

    public static void main(String[] args) {
        DistanceBetweenTwoNodesInBinaryTree test = new DistanceBetweenTwoNodesInBinaryTree();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(6);
        root.right = node1;
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        System.out.println(test.distance(root, 4, 6));
    }
}
