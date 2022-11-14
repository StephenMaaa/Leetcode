package Array;

/*
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

        You must do it in place.
*/

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeros {
    // approach 1 - Set TC: O(mn) SC: O(m + n)
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();

        // fill
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }

        // update
        for (int row : rowSet) {
            for (int i = 0; i < cols; i++) {
                matrix[row][i] = 0;
            }
        }

        for (int col : colSet) {
            for (int i = 0; i < rows; i++) {
                matrix[i][col] = 0;
            }
        }
    }

    // approach 2 - In-place TC: O(mn) SC: O(1)
    public void setZeroes2(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean flag = false;

        // fill
        for (int i = 0; i < rows; i++) {
            // case: col 0 setter
            if (matrix[i][0] == 0) {
                flag = true;
            }

            for (int j = 1; j < cols; j++) {
                // case: M[i][j] == 0
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // update
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }

            if (flag) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        SetMatrixZeros test = new SetMatrixZeros();
        int[][] matrix = new int[][]{{-4, -2147483648, 6, -7, 0},
                                     {-8, 6, -8, -6, 0},
                                     {2147483647, 2, -9, -6, -10}};
        test.setZeroes2(matrix);
    }
}
