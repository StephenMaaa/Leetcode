package BFS;

/*
Get the list of keys in a given binary tree layer by layer in zig-zag order.

        Examples

        5

        /    \

        3        8

        /   \        \

        1     4        11

        the result is [5, 3, 8, 11, 4, 1]

        Corner Cases

        What if the binary tree is null? Return an empty list in this case.
*/

import java.util.*;

public class ZigZagLevelTraversal {
    public List<Integer> zigZag(TreeNode root) {
        // edge case: empty tree
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int level = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                if (level % 2 == 0) {
                    TreeNode node = deque.pollLast();
                    ans.add(node.key);
                    if (node.right != null) {
                        deque.offerFirst(node.right);
                    }
                    if (node.left != null) {
                        deque.offerFirst(node.left);
                    }
                } else {
                    TreeNode node = deque.pollFirst();
                    ans.add(node.key);
                    if (node.left != null) {
                        deque.offerLast(node.left);
                    }
                    if (node.right != null) {
                        deque.offerLast(node.right);
                    }
                }
            }
            level++;
        }
        return ans;
    }
}
