package Tree;

/*
Given two nodes in a binary tree (with parent pointer available), find their lowest common ancestor.

        Assumptions

        There is parent pointer for the nodes in the binary tree

        The given two nodes are not guaranteed to be in the binary tree

        Examples

        5

        /   \

        9     12

        /  \      \

        2    3      14

        The lowest common ancestor of 2 and 14 is 5

        The lowest common ancestor of 2 and 9 is 9

        The lowest common ancestor of 2 and 8 is null (8 is not in the tree)
*/

/*
Given two nodes in a binary tree, find their lowest common ancestor (the given two nodes are not guaranteed to be in the binary tree).

        Return null If any of the nodes is not in the tree.

        Assumptions

        There is no parent pointer for the nodes in the binary tree

        The given two nodes are not guaranteed to be in the binary tree
*/

public class LCAIII {
    // original LCA algorithm + check
    public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
        // Write your solution here.
        TreeNodeP root = one;
        while (root.parent != null) {
            root = root.parent;
        }
        TreeNodeP lca = lca(root, one, two);

        // check in the same tree
        if (lca == one && lca(lca, two, two) == null) {
            lca = null;
        } else if (lca == two && lca(lca, one, one) == null) {
            lca = null;
        }
        return lca;
    }

    private TreeNodeP lca(TreeNodeP root, TreeNodeP one, TreeNodeP two) {
        // base case
        if (root == null || root == one || root == two) {
            return root;
        }

        TreeNodeP left = lca(root.left, one, two);
        TreeNodeP right = lca(root.right, one, two);

        // case 1: both not null
        if (left != null && right != null) {
            return root;
        }
        // case 2: at least one null
        return left == null ? right : left;
    }

    public TreeNode lowestCommonAncestor(TreeNode root,
                                         TreeNode one, TreeNode two) {
        // find LCA
        TreeNode lca = lca2(root, one, two);

        // check existence
        if (lca == one && lca2(lca, two, two) == null) {
            lca = null;
        } else if (lca == two && lca2(lca, one, one) == null) {
            lca = null;
        }
        return lca;
    }

    private TreeNode lca2(TreeNode root, TreeNode one, TreeNode two) {
        // base case
        if (root == null || root == one || root == two) {
            return root;
        }

        // recursive case
        TreeNode left = lca2(root.left, one, two);
        TreeNode right = lca2(root.right, one, two);

        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }

    public static void main(String[] args) {
        LCAIII test = new LCAIII();
        TreeNode root = new TreeNode(5);
        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(12);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(14);
        TreeNode n6 = new TreeNode(8);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.right = n5;
        System.out.println(test.lowestCommonAncestor(root, n3, n6).val);
    }
}
