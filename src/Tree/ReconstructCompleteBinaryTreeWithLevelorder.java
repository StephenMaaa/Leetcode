package Tree;

/*
How to re construct a complete binary tree from its level-order traversal sequence only.

        Assumptions:

        The given level-order is not null.
        Examples:

        {1, 2, 3} -->

        1

        /   \

        2     3
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class ReconstructCompleteBinaryTreeWithLevelorder {
    // time complexity: O(n)
    // space complexity: O(height)
    public TreeNode construct(int[] level) {
        // edge case
        if (level == null || level.length == 0) {
            return null;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        int i = 0;
        TreeNode root = new TreeNode(level[i++]);
        deque.offerLast(root);

        while (!deque.isEmpty() && i < level.length) {
            TreeNode node = deque.pollFirst();

            // update subtrees
            node.left = new TreeNode(level[i++]);
            deque.offerLast(node.left);
            if (i < level.length) {
                node.right = new TreeNode(level[i++]);
                deque.offerLast(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        ReconstructCompleteBinaryTreeWithLevelorder test = new ReconstructCompleteBinaryTreeWithLevelorder();
        int[] levelorder = new int[]{5, 3, 8, 1, 4, 11};
        TreeNode root = test.construct(levelorder);
    }
}
