package Tree;

/*
Given a binary tree, find the length of the longest consecutive sequence path.

        The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

        For example,

        1
        \
        3
        / \
        2   4
        \
        5
        Longest consecutive sequence path is 3-4-5, so return 3.

        2
        \
        3
        /
        2
        /
        1
        Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
*/

public class BinaryTreeLongestConsecutiveSequence {
//    // time complexity: O(n)
//    // space complexity: O(height)
//    public int longestConsecutive(TreeNode root) {
//        int[] max = new int[1];
//        traverse(root, Integer.MAX_VALUE, 0, max);
//        return max[0];
//    }
//
//    private void traverse(TreeNode root, int prev, int count, int[] max) {
//        // base case
//        if (root == null) {
//            return;
//        }
//
//        // case 1: consecutive
//        // case 2: otherwise
//        if (root.val == prev + 1) {
//            count++;
//        } else {
//            count = 1;
//        }
//
//        max[0] = Math.max(max[0], count);
//
//        // check left and right subtrees
//        traverse(root.left, root.val, count, max);
//        traverse(root.right, root.val, count, max);
//    }

    // approach 1 - Recursion TC: O(n) SC: O(height)
    public int longestConsecutive(TreeNode root) {
        int[] max = new int[1];
        int prev = root == null ? 0 : root.val + 1;
        traverse(root, 0, prev, max);
        return max[0];
    }

    private void traverse(TreeNode root, int count, int prev, int[] max) {
        // base case
        if (root == null) {
            return;
        }

        // recursive case
        if (root.val == prev + 1) {
            count++;
        } else {
            count = 1;
        }

        // update max
        max[0] = Math.max(max[0], count);

        // traverse left and right subtrees
        traverse(root.left, count, root.val, max);
        traverse(root.right, count, root.val, max);
    }

    public static void main(String[] args) {
        BinaryTreeLongestConsecutiveSequence test = new BinaryTreeLongestConsecutiveSequence();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node2.right = node3;
        node3.right = node4;
        System.out.println(test.longestConsecutive(null));
    }
}
