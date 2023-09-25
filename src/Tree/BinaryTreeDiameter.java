package Tree;

/*
Given a binary tree in which each node contains an integer number. The diameter is defined as the longest distance from one leaf node to another leaf node. The distance is the number of nodes on the path.

        If there does not exist any such paths, return 0.

        Examples

        5

        /    \

        2      11

        /    \

        6     14

        The diameter of this tree is 4 (2 → 5 → 11 → 14)
*/

public class BinaryTreeDiameter {
    public int diameter(TreeNode root) {
        int[] max = new int[1];
        traverse(root, max);
        return max[0];
    }

    private int traverse2(TreeNode root, int[] max) {
        // base case
        if (root == null) {
            return 0;
        }

        // recursive case
        int left = traverse(root.left, max);
        int right = traverse(root.right, max);

        // update max
        if (root.left != null && root.right != null) {
            max[0] = Math.max(max[0], left + right + 1);
        }
        return Math.max(left, right) + 1;
    }

    // approach 1: Recursion TC: O(n) SC: O(height)
    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = new int[1];
        traverse(root, max);
        return max[0];
    }

    private int traverse(TreeNode root, int[] max) {
        // base case
        if (root == null) {
            return 0;
        }

        // recursive case
        int left = traverse(root.left, max);
        int right = traverse(root.right, max);

        // update
        max[0] = Math.max(max[0], left + right);

        return Math.max(left, right) + 1;
    }


    public static void main(String[] args) {
        BinaryTreeDiameter test = new BinaryTreeDiameter();
        TreeNode root = new TreeNode(1);
//        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
//        TreeNode n7 = new TreeNode(7);
        root.right = n2;
        n2.right = n3;
        n3.left = n5;
        n3.right = n4;
        System.out.println(test.diameterOfBinaryTree(root));
    }
}
