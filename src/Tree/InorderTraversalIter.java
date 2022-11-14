package Tree;

/*
Implement an iterative, in-order traversal of a given binary tree, return the list of keys of each node in the tree as it is in-order traversed.

        Examples

        5

        /    \

        3        8

        /   \        \

        1      4        11

        In-order traversal is [1, 3, 4, 5, 8, 11]

        Corner Cases

        What if the given binary tree is null? Return an empty list in this case.
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class InorderTraversalIter {
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        // edge case
        if (root == null) {
            return ans;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.offerFirst(root);
                root = root.left;
            }

            root = stack.pollFirst();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }

    public static void main(String[] args) {
        InorderTraversalIter test = new InorderTraversalIter();
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(11);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        System.out.println(test.inOrder(root));
    }
}
