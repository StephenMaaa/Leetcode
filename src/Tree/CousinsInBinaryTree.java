package Tree;

/*
Given a binary Tree and the two keys, determine whether the two nodes are cousins of each other or not. Two nodes are cousins of each other if they are at the same level and have different parents.

        Assumptions:

        It is not guranteed the two keys are all in the binary tree.
        There are no duplicate keys in the binary tree.
        Examples:

        6
        /   \
        3     5
        / \   / \

        7   8 1   13
        7 and 1, result is true.
        3 and 5, result is false.
        7 and 5, result is false.
*/

public class CousinsInBinaryTree {
    // time complexity: O(n)
    // space complexity: O(height)
    public boolean isCousin(TreeNode root, int a, int b) {
        TreeNode[] parents = new TreeNode[2];
        int[] levels = new int[2];
        traverse(root, a, b, 0, null, levels, parents);
        if (parents[0] != null && parents[1] != null) {
            return levels[0] == levels[1] && parents[0] != parents[1];
        } else {
            return false;
        }
    }

    private void traverse(TreeNode root, int a, int b, int level, TreeNode parent, int[] levels, TreeNode[] parents) {
        // base case
        if (root == null) {
            return;
        }

        if (root.val == a) {
            levels[0] = level;
            parents[0] = parent;
            return;
        }

        if (root.val == b) {
            levels[1] = level;
            parents[1] = parent;
            return;
        }

        // recursive case
        traverse(root.left, a, b, level + 1, root, levels, parents);
        traverse(root.right, a, b, level + 1, root, levels, parents);
    }

    public static void main(String[] args) {
        CousinsInBinaryTree test = new CousinsInBinaryTree();
        TreeNode root = new TreeNode(6);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(7);
        TreeNode n5 = new TreeNode(8);
        TreeNode n6 = new TreeNode(1);
        TreeNode n7 = new TreeNode(13);
        root.left = n2;
        root.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        System.out.println(test.isCousin(root, 7, 5));
    }
}
