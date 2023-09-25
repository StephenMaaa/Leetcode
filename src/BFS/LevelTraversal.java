package BFS;

/*
Get the list of list of keys in a given binary tree layer by layer. Each layer is represented by a list of keys and the keys are traversed from left to right.

        Examples

        5

        /    \

        3        8

        /   \        \

        1     4        11

        the result is [ [5], [3, 8], [1, 4, 11] ]

        Corner Cases

        What if the binary tree is null? Return an empty list of list in this case.
*/

import Airbnb.TravelBuddy;

import java.util.*;

public class LevelTraversal {
    public List<List<Integer>> layerByLayer(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int count = queue.size();
            while (count > 0) {
                TreeNode node = queue.poll();
                list.add(node.key);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                count--;
            }
            ans.add(list);
        }
        return ans;
    }

    // approach 1: BFS TC: O(n) SC: O(n)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        // edge case
        if (root == null) {
            return res;
        }

        // initialization
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        
        // BFS
        while (!queue.isEmpty()) {
            // explore current level
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.key);

                // explore left and right child
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            // add current level
            res.add(list);
        }
        return res;
    }
}
