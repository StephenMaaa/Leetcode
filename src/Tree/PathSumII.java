package Tree;

/*
LeetCode 113 

Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.

        A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
*/

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    // approach 1: Recursion TC: O(n) SC: O(n)
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        traverse(root, targetSum, path, res);
        return res;
    }

    private void traverse(TreeNode root, int sum, List<Integer> path, List<List<Integer>> res) {
        // base case
        if (root == null) {
            return;
        }

        // recursive case
        path.add(root.val);

        // traverse left and right
        traverse(root.left, sum - root.val, path, res);
        traverse(root.right, sum - root.val, path, res);

        // check
        if (root.left == null && root.right == null && root.val == sum) {
            res.add(new ArrayList<>(path));
        }

        path.remove(path.size() - 1);
    }
}
