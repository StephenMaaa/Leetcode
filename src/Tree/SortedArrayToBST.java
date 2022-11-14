package Tree;

/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
        For testing purpose, please make sure for any node in the result, its left sub-tree should have equal or only one more node than its right sub-tree.

        Example:
        Given ascending order array: [1, 3, 4, 5, 8, 11]

        return Binary Search Tree is

        5

        /        \

        3          11

        /     \      /

        1       4    8
*/

public class SortedArrayToBST {
    // time complexity: O(n)
    // space complexity: O(height)
    public TreeNode sortedArrayToBST(int[] num) {
        return construct(num, 0, num.length - 1);
    }

    private TreeNode construct(int[] num, int left, int right) {
        // base case
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        if (right - mid > mid - left) {
            mid++;
        }

        TreeNode root = new TreeNode(num[mid]);
        root.left = construct(num, left, mid - 1);
        root.right = construct(num, mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        SortedArrayToBST test = new SortedArrayToBST();
        int[] arr = new int[]{};
        TreeNode root = test.sortedArrayToBST(arr);
    }
}
