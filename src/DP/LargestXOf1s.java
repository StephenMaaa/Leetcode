package DP;

/*
Given a matrix that contains only 1s and 0s, find the largest X shape which contains only 1s, with the same arm lengths and the four arms joining at the central point.

        Return the arm length of the largest X shape.

        Assumptions

        The given matrix is not null, has size of N * M, N >= 0 and M >= 0.
        Examples

        { {0, 0, 0, 0},

        {1, 1, 1, 1},

        {0, 1, 1, 1},

        {1, 0, 1, 1} }

        the largest X of 1s has arm length 2.
*/

public class LargestXOf1s {
    // time complexity: O(m * n)
    // space complexity: O(m * n)
    public int largest(int[][] matrix) {
        // edge case
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] topX = getTopX(matrix);
        int[][] bottomX = getBottomX(matrix);
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, Math.min(topX[i + 1][j + 1], bottomX[i][j]));
            }
        }
        return max;
    }

    private int[][] getTopX(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] topLeft = new int[m + 1][n + 1];
        int[][] topRight = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                topLeft[i + 1][j + 1] = matrix[i][j] == 0 ? 0 : topLeft[i][j] + matrix[i][j];
                // edge case
                if (j == n - 1) {
                    topRight[i + 1][j + 1] = matrix[i][j];
                } else {
                    topRight[i + 1][j + 1] = matrix[i][j] == 0 ? 0 : topRight[i][j + 2] + matrix[i][j];
                }

            }
        }
        return merge(topLeft, topRight);
    }

    private int[][] getBottomX(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] bottomLeft = new int[m + 1][n + 1];
        int[][] bottomRight = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // edge case
                if (j == 0) {
                    bottomLeft[i][j] = matrix[i][j];
                } else {
                    bottomLeft[i][j] = matrix[i][j] == 0 ? 0 : bottomLeft[i + 1][j - 1] + matrix[i][j];
                }
                bottomRight[i][j] = matrix[i][j] == 0 ? 0 : bottomRight[i + 1][j + 1] + matrix[i][j];
            }
        }
        return merge(bottomLeft, bottomRight);
    }

    private int[][] merge(int[][] m1, int[][] m2) {
        for (int i = 1; i < m1.length; i++) {
            for (int j = 1; j < m2.length; j++) {
                m1[i][j] = Math.min(m1[i][j], m2[i][j]);
            }
        }
        return m1;
    }

    public static void main(String[] args) {
        LargestXOf1s test = new LargestXOf1s();
        int[][] matrix = new int[][]{ {0, 0, 0, 0},

                {1, 1, 1, 1},

                {0, 1, 1, 1},

                {1, 0, 1, 1} };
        System.out.println(test.largest(matrix));
    }
}
