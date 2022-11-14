package Tree;

/*
Given a binary tree in which each node contains an integer number. Determine if there exists a path (the path can only be from one node to itself or to any of its descendants), the sum of the numbers on the path is the given target number.

        Examples

        5

        /    \

        2      11

        /    \

        6     14

        /

        3

        If target = 17, There exists a path 11 + 6, the sum of the path is target.

        If target = 20, There exists a path 11 + 6 + 3, the sum of the path is target.

        If target = 10, There does not exist any paths sum of which is target.

        If target = 11, There exists a path only containing the node 11.
*/

import java.util.HashSet;
import java.util.Set;

public class PathSumToTargetII {
    public boolean exist(TreeNode root, int target) {
        // edge case
        if (root == null) {
            return false;
        }

        Set<Integer> paths = new HashSet<>();
        paths.add(0);
        return findPath(root, target, 0, paths);
    }

    // preorder traversal
    private boolean findPath(TreeNode root, int target, int sum, Set<Integer> paths) {
        // base case
        sum += root.val;
        if (paths.contains(sum - target)) {
            return true;
        }

        boolean remove = paths.add(sum);

        // base case
        if (root.left != null && findPath(root.left, target, sum, paths)) {
            return true;
        }
        if (root.right != null && findPath(root.right, target, sum, paths)) {
            return true;
        }

        // remove to the top level
        if (remove) {
            paths.remove(sum);
        }
        return false;
    }

//    private boolean findPath(TreeNode root, int target, int sum, Set<Integer> paths) {
//        // base case
//        if (root == null) {
//            return false;
//        }
//
//        sum += root.val;
//        boolean remove = paths.add(sum);
//
//        // base case
//        if (root.left == null && root.right == null) {
//            if (paths.contains(sum - target)) {
//                return true;
//            }
//        } else if (findPath(root.left, target, sum, paths) || findPath(root.right, target, sum, paths)) {
//            return true;
//        }
//
//        // remove to the top level
//        if (remove) {
//            paths.remove(sum);
//        }
//        return false;
//    }

    public static void main(String[] args) {
        PathSumToTargetII test = new PathSumToTargetII();
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(11);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        System.out.println(test.exist(root, 7));
    }
}
