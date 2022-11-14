package Tree;

/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

        Note:
        You may assume k is always valid, 1 <=k <= BST's total elements.

        Follow up:
        What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
*/

public class KthSmallestElementInBST {
//    // time complexity: O(k)
//    // space complexity: O(height)
//    public int kthSmallest(TreeNode root, int k) {
//        int[] count = new int[1];
//        int[] res = new int[1];
//        traverse(root, k, count, res);
//        return res[0];
//    }
//
//    private void traverse(TreeNode root, int k, int[] count, int[] res) {
//        // base case
//        if (root == null || count[0] > k) {
//            return;
//        }
//
//        // recursive case
//        traverse(root.left, k, count, res);
//
//        count[0]++;
//        if (count[0] == k) {
//            res[0] = root.val;
//            return;
//        }
//
//        traverse(root.right, k, count, res);
//    }

    // approach 1 - Recursion TC: O(n) SC: O(height)
    public int kthSmallest(TreeNode root, int k) {
        int[] count = new int[]{k, 0};
        traverse(root, count);
        return count[1];
    }

    private void traverse(TreeNode root, int[] count) {
        // base case
        if (root == null || count[0] <= 0) {
            return;
        }

        // recursive case
        traverse(root.left, count);

        count[0]--;
        if (count[0] == 0) {
            count[1] = root.val;
            return;
        }

        traverse(root.right, count);
    }

    public static void main(String[] args) {
        KthSmallestElementInBST test = new KthSmallestElementInBST();
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        System.out.println(test.kthSmallest(root, 4));
    }
}
