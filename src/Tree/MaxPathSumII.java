package Tree;

public class MaxPathSumII {
//    public int maxPath(AverageOfLevels.TreeNode root) {
//        int[] max = new int[1];
//        max[0] = Integer.MIN_VALUE;
//        // edge case: only one root?
//        if (root.left != root.right) {
//            findMax(root, max);
//        }
//        return max[0];
//    }
//
//    private int findMax(AverageOfLevels.TreeNode root, int[] max) {
//        // base case
//        if (root == null) {
//            return Integer.MIN_VALUE;
//        }
//        if (root.left == null && root.right == null) {
//            return root.val;
//        }
//
//        int left = findMax(root.left);
//        int right = findMax(root.right);
//        if (root.left != null && root.right != null) {
//            max[0] = Math.max(max[0], left + right + root.val);
//        }
//        return Math.max(left, right) + root.val;
//    }
}
