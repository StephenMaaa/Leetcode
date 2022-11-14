package Tree;

/*
Given a binary search tree, a target number and an integer k, return k closest elements to the target. 1 <= K <= number of nodes in the tree.

        Note:

        In case of same distance, smaller number is considered closer.
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class KClosestElementsInBST {
    // time complexity: O(n)
    // space complexity: O(height)
    public List<Integer> kClosestBST(TreeNode root, int target, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        traverse(root, target, k, queue);
        return new ArrayList<>(queue);
    }

    private void traverse(TreeNode root, int target, int k, Deque<Integer> queue) {
        // base case
        if (root == null) {
            return;
        }

        // recursive case
        traverse(root.left, target, k, queue);

        if (queue.size() < k) {
            queue.offerLast(root.val);
        } else {
            if (Math.abs(target - queue.peekFirst()) >= Math.abs(target - root.val)) {
                queue.pollFirst();
                queue.offerLast(root.val);
            } else {
                return;
            }
        }

        traverse(root.right, target, k, queue);
    }

    public static void main(String[] args) {
        KClosestElementsInBST test = new KClosestElementsInBST();
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
        System.out.println(test.kClosestBST(root, 4, 3));
    }
}
