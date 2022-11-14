package Tree;

/*
Given two nodes in a K-nary tree, find their lowest common ancestor.

        Assumptions

        -There is no parent pointer for the nodes in the K-nary tree.

        -The given two nodes are guaranteed to be in the K-nary tree.

        Examples



        5

        /   \

        9   12

        / | \      \

        1 2   3      14



        The lowest common ancestor of 2 and 14 is 5.

        The lowest common ancestor of 2 and 9 is 9.
*/

import java.util.ArrayList;
import java.util.List;

public class LCAV {
    public KnaryTreeNode lowestCommonAncestor(KnaryTreeNode root, KnaryTreeNode a, KnaryTreeNode b) {
        // base case
        if (root == null || root == a || root == b) {
            return root;
        }

        KnaryTreeNode valid = null;
        for (KnaryTreeNode child : root.children) {
            // case 1: all null
            // case 2: only 1 non-null
            // case 3: 2 non-null
            KnaryTreeNode node = lowestCommonAncestor(child, a, b);
            if (valid == null && node != null) {
                valid = node;
            } else if (valid != null && node != null) {
                return root;
            }
        }
        return valid;
    }
}
