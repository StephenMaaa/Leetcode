package Array;

/*
Rotate an N * N matrix clockwise 90 degrees.

        Assumptions

        The matrix is not null and N >= 0
        Examples

        { {1,  2,  3}

        {8,  9,  4},

        {7,  6,  5} }

        after rotation is

        { {7,  8,  1}

        {6,  9,  2},

        {5,  4,  3} }
*/

import java.util.Arrays;

public class RotateMatrix {
    // approach 1 - Recursion TC: O(n^2) SC: O(n)
    public void rotate(int[][] matrix) {
        // recursion
        traverse(matrix, 0, matrix.length);
    }

    private void traverse(int[][] matrix, int offset, int n) {
        if (offset == n / 2) {
            return;
        }

        for (int i = offset; i < n - offset - 1; i++) {
//            int temp = matrix[offset][i];
//
//            matrix[offset][i] = matrix[i][n - offset - 1];
//
//            matrix[i][n - offset - 1] = matrix[n - offset - 1][n - i - 1];
//
//            matrix[n - offset - 1][n - i - 1] = matrix[n - i - 1][offset];
//
//            matrix[n - i - 1][offset] = temp;

            int temp = matrix[n - i - 1][offset];

            matrix[n - i - 1][offset] = matrix[n - offset - 1][n - i - 1];

            matrix[n - offset - 1][n - i - 1] = matrix[i][n - offset - 1];

            matrix[i][n - offset - 1] = matrix[offset][i];

            matrix[offset][i] = temp;
        }

        traverse(matrix, offset + 1, n);
    }

    // approach 2 - Iteration TC: O(n^2) SC: O(1)
    public void rotate2(int[][] matrix) {
        int size = matrix.length;
        int offset = 0;

        while (size > 1) {
            for (int i = 0; i < size - 1; i++) {
                int temp = matrix[offset][i + offset];
                matrix[offset][i + offset] = matrix[size - i + offset - 1][offset];
                matrix[size - i + offset - 1][offset] = matrix[size + offset - 1][size - i + offset - 1];
                matrix[size + offset - 1][size - i + offset - 1] = matrix[i + offset][size + offset - 1];
                matrix[i + offset][size + offset - 1] = temp;
            }
            size -= 2;
            offset++;
        }
    }

    public static void main(String[] args) {
        RotateMatrix test = new RotateMatrix();
        int[][] matrix = new int[][]{{42,72,13,76,91},{26,21,72,99,16},{86,43,34,15,45},{22,64,90,54,28},{98,23,85,44,89}};
        int[][] matrix2 = new int[][]{{42,72,13,76,91},{26,21,72,99,16},{86,43,34,15,45},{22,64,90,54,28},{98,23,85,44,89}};
        test.rotate2(matrix);

        System.out.println(Arrays.toString(matrix));
    }
}
