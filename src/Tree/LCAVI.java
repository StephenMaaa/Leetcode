package Tree;

/*
Given M nodes in a K-nary tree, find their lowest common ancestor.

        Assumptions

        - M >= 2.

        - There is no parent pointer for the nodes in the K-nary tree.

        - The given M nodes are guaranteed to be in the K-nary tree.

        Examples

        5

        /   \

        9   12

        / | \      \

        1 2 3     14



        The lowest common ancestor of 2, 3, 14 is 5.

        The lowest common ancestor of 2, 3, 9 is 9.
*/

import java.util.List;

public class LCAVI {
    // same logic as LCAV (Knary tree with 2 nodes)
    public KnaryTreeNode lowestCommonAncestor(KnaryTreeNode root, List<KnaryTreeNode> nodes) {
        // base case
        if (root == null || nodes.contains(root)) {
            return root;
        }

        KnaryTreeNode valid = null;
        for (KnaryTreeNode child : root.children) {
            // case 1: all null
            // case 2: only 1 non-null
            // case 3: at least 2 non-null
            KnaryTreeNode node = lowestCommonAncestor(child, nodes);
            if (valid == null && node != null) {
                valid = node;
            } else if (valid != null && node != null) {
                return root;
            }
        }
        return valid;
    }
}
