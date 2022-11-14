package Tree;

/*
Given a binary tree, insert one row of TreeNodes at given depth d of value v.

        For TreeNodes originally at depth d, if it is left child of its parent, then it will become left child of new inserted node; if it is right child of its parent, then it will become right child of new inserted node.

        The depth of root is 1.

        Suppose root =  [1,2,3,4,5]



        Example 1:

        Input: root = [1,2,3,4,5]; v = 0; d = 1

        Output: [0,1,null,2,3,4,5]
*/

public class InsertRowToTree {
    // time complexity: O(n)
    // space complexity: O(height)
    public TreeNode insertRow(TreeNode root, int v, int d) {
        return traverse(root, 1, v, d);
    }

    private TreeNode traverse(TreeNode root, int level, int v, int d) {
        // case 1: d == 1
        // base case
        // case 2: level == d - 1
        // case 3: otherwise
        if (d == 1) {
            TreeNode newNode = new TreeNode(v);
            newNode.left = root;
            return newNode;
        } else if (root == null) {
            return null;
        } else if (level == d - 1) {
            TreeNode newLeft = new TreeNode(v);
            TreeNode newRight = new TreeNode(v);
            newLeft.left = root.left;
            newRight.right = root.right;
            root.left = newLeft;
            root.right = newRight;
            return root;
        } else {
            root.left = traverse(root.left, level + 1, v, d);
            root.right = traverse(root.right, level + 1, v, d);
            return root;
        }
    }

    public static void main(String[] args) {
        InsertRowToTree test = new InsertRowToTree();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        root = test.insertRow(root, 0, 3);
    }
}
