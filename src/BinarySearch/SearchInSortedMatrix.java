package BinarySearch;

/*
Given a 2D matrix that contains integers only, which each row is sorted in an ascending order. The first element of next row is larger than (or equal to) the last element of previous row.

        Given a target number, returning the position that the target locates within the matrix. If the target number does not exist in the matrix, return {-1, -1}.

        Assumptions:

        The given matrix is not null, and has size of N * M, where N >= 0 and M >= 0.
        Examples:

        matrix = { {1, 2, 3}, {4, 5, 7}, {8, 9, 10} }

        target = 7, return {1, 2}

        target = 6, return {-1, -1} to represent the target number does not exist in the matrix.
*/

import java.util.Arrays;

public class SearchInSortedMatrix {
    public int[] search(int[][] matrix, int target) {
        int cols = matrix[0].length;
        int rows = matrix.length;
        int i = 0, j = cols * rows - 1;
        while (i <= j) {
            int midCol = (i + (j - i) / 2) % cols;
            int midRow = (i + (j - i) / 2) / cols;
            if (matrix[midRow][midCol] == target) {
                return new int[]{midRow, midCol};
            } else if (matrix[midRow][midCol] < target) {
                i = midRow * cols + midCol + 1;
            } else {
                j = midRow * cols + midCol - 1;
            }
        }
        return new int[]{-1, -1};
    }

    // approach 1 - Binary Search TC: O(logmn) SC: O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length * matrix[0].length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int row = mid / matrix[0].length;
            int col = mid % matrix[0].length;

            // case 1: target == matrix[row][col]
            // case 2: target < matrix[row][col]
            // case 3: target > matrix[row][col]
            if (target == matrix[row][col]) {
                return true;
            } else if (target < matrix[row][col]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchInSortedMatrix test = new SearchInSortedMatrix();
//        int[][] arr = new int[][]{ {1, 2, 3}, {4, 5, 7}, {8, 9, 10} };
        int[][] arr = new int[][]{{1, 2, 3, 4}};
        System.out.println(Arrays.toString(test.search(arr, 2)));
    }
}
