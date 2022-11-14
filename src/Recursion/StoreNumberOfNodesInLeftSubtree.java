package Recursion;

/*
Given a binary tree, count the number of nodes in each node’s left subtree, and store it in the numNodesLeft field.

        Examples

        1(6)

        /          \

        2(3)        3(0)

        /      \

        4(1)     5(0)

        /        \        \

        6(0)     7(0)   8(0)

        The numNodesLeft is shown in parentheses.
*/

public class StoreNumberOfNodesInLeftSubtree {
    public void numNodesLeft(TreeNodeLeft root) {
        findNodesLeft(root);
    }

    private int findNodesLeft(TreeNodeLeft root) {
        // base case
        if (root == null) {
            return 0;
        }

        int left = findNodesLeft(root.left);
        int right = findNodesLeft(root.right);
        root.numNodesLeft = left;
        return left + right + 1;
    }
}
