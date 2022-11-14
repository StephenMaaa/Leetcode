package Recursion;

/*
Given a binary tree, flatten it to a linked list in-place.

        For example,
        Given

        1
        / \
        2   5
        / \   \
        3   4   6
        The flattened tree should look like:

        1
        \
        2
        \
        3
        \
        4
        \
        5
        \
        6
*/

public class FlattenBinaryTreeToLinkedList {
//    public TreeNode flatten(TreeNode root) {
//        TreeNode head = new TreeNode(-1);
//        traverse(root, head);
//        return head.right;
//    }
//
//    private TreeNode traverse(TreeNode root, TreeNode head) {
//        // base case
//        if (root == null) {
//            return head;
//        }
//
//        head.right = new TreeNode(root.key);
//        head = head.right;
//
//        head = traverse(root.left, head);
//        head = traverse(root.right, head);
//        return head;
//    }

    public TreeNode flatten(TreeNode root) {
        TreeNode[] head = new TreeNode[1];
        traverse(root, head);
        return root;
    }

    private void traverse(TreeNode root, TreeNode[] head) {
        // base case
        if (root == null) {
            return;
        }

        traverse(root.right, head);
        traverse(root.left, head);
        root.right = head[0];
        root.left = null;
        head[0] = root;
    }

    public static void main(String[] args) {
        FlattenBinaryTreeToLinkedList test = new FlattenBinaryTreeToLinkedList();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        root.left = node1;
        root.right = node4;
        node1.left = node2;
        node1.right = node3;
        node4.right = node5;
        TreeNode ans = test.flatten(null);
        while (ans != null) {
            System.out.println(ans.key);
            ans = ans.right;
        }
    }
}
