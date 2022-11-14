package Tree;

/*
Given the root of a binary search tree and a node p in it, return the in-order successor of that node in the BST. If the given node has no in-order successor in the tree, return null.

        The successor of a node p is the node with the smallest key greater than p.val.
*/

public class InorderSuccessorInBST {
//    TreeNode prev;
//    TreeNode successor;

//    // approach 1 - Iteration + Recursion TC: O(n) SC: O(height)
//    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
//        // check right successor
//        if (p.right != null) {
//            p = p.right;
//            while (p.left != null) {
//                p = p.left;
//            }
//            return p;
//        }
//
//        // check parent
//        traverse(root, p);
//        return successor;
//    }
//
//    private void traverse(TreeNode root, TreeNode p) {
//        // base case
//        if (root == null) {
//            return;
//        }
//
//        // recursive case
//        traverse(root.left, p);
//
//        // check
//        if (prev == p) {
//            successor = root;
//        }
//
//        prev = root;
//        traverse(root.right, p);
//    }

    // approach 2 - Binary Search TC: O(height) SC: O(1)
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        while (root != null) {
            if (root.val > p.val) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return successor;
    }

    public static void main(String[] args) {
        InorderSuccessorInBST test = new InorderSuccessorInBST();
        TreeNode root = new TreeNode(5);
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(6);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(1);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n3.left = n5;
        TreeNode res = test.inorderSuccessor(root, n5);
    }
}
