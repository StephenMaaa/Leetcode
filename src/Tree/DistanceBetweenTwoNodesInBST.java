package Tree;

public class DistanceBetweenTwoNodesInBST {
    // time complexity: O(n)
    // space complexity: O(1)
    public int getDistance(TreeNode root, TreeNode a, TreeNode b) {
        // find LCA
        int min = Math.min(a.val, b.val);
        int max = Math.max(a.val, b.val);
        while (root != null) {
            if (root.val < min) {
                root = root.right;
            } else if (root.val > max) {
                root = root.left;
            } else {
                break;
            }
        }

//        int[] heightA = new int[1];
//        int[] heightB = new int[1];
//        get(root, a, heightA, 0);
//        get(root, b, heightB, 0);
//        return heightA[0] + heightB[0];
        return getHeight(root, a) + getHeight(root, b);
    }

    private void get(TreeNode root, TreeNode node, int[] height, int count) {
        // base case
        if (root == null) {
            return;
        }
        if (root == node) {
            height[0] = count;
            return;
        }

        get(root.left, node, height, count + 1);
        get(root.right, node, height, count + 1);
    }

    private int getHeight(TreeNode root, TreeNode node) {
        int count = 0;
        while (root != null) {
            if (root == node) {
                return count;
            } else if (root.val < node.val) {
                root = root.right;
            } else if (root.val > node.val) {
                root = root.left;
            }

            count++;
        }
        return -1;
    }

    public static void main(String[] args) {
        DistanceBetweenTwoNodesInBST test = new DistanceBetweenTwoNodesInBST();
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        System.out.println(test.getDistance(root, node3, node6));
    }
}
