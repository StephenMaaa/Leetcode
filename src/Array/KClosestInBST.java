package Array;

/*
In a binary search tree, find k nodes containing the closest numbers to the given target number. return them in sorted array

        Assumptions:

        The given root is not null.
        There are no duplicate keys in the binary search tree.
        Examples:

        5

        /    \

        2      11

        /    \

        6     14

        closest number to 4 is 5

        closest number to 10 is 11

        closest number to 6 is 6
*/

import Tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class KClosestInBST {
    public int[] closestKValues(TreeNode root, double target, int k) {
        // inorder traversal + sliding window
        Deque<Integer> slidingWindow = new ArrayDeque<>();
        traverse(root, target, k, slidingWindow);
        int[] ans = new int[slidingWindow.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = slidingWindow.poll();
        }
        return ans;
    }

    private void traverse(TreeNode root, double target, int k, Deque<Integer> slidingWindow) {
        // base case
        if (root == null) {
            return;
        }

        traverse(root.left, target, k, slidingWindow);
        if (slidingWindow.size() < k) {
            slidingWindow.offer(root.val);
            traverse(root.right, target, k, slidingWindow);
        } else if (Math.abs(slidingWindow.peek() - target) > Math.abs(root.val - target)) {
            slidingWindow.poll();
            slidingWindow.offer(root.val);
            traverse(root.right, target, k, slidingWindow);
        }
    }
}
