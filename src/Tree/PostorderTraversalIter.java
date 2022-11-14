package Tree;

/*
Implement an iterative, post-order traversal of a given binary tree, return the list of keys of each node in the tree as it is post-order traversed.

        Examples

        5

        /    \

        3        8

        /   \        \

        1      4        11

        Post-order traversal is [1, 4, 3, 11, 8, 5]

        Corner Cases

        What if the given binary tree is null? Return an empty list in this case.
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PostorderTraversalIter {
    public List<Integer> postOrder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        // edge case
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            ans.add(0, node.val);

            if (node.left != null) {
                queue.offerFirst(node.left);
            }
            if (node.right != null) {
                queue.offerFirst(node.right);
            }
        }
        return ans;
    }
}
