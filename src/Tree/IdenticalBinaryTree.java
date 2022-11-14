package Tree;

/*
Check if two given binary trees are identical. Identical means the equal valued keys are at the same position in the two binary trees.

        Examples



        5

        /    \

        3        8

        and

        5

        /    \

        3        8

        are identical trees.
*/

public class IdenticalBinaryTree {
    public boolean isIdentical(TreeNode one, TreeNode two) {
        // base case
        if (one == null || two == null) {
            if (one == null && two == null) {
                return true;
            } else {
                return false;
            }
        }

        // recursive case
        if (one.val == two.val) {
            return isIdentical(one.left, two.left) && isIdentical(one.right, two.right);
        } else {
            return false;
        }
    }
}
