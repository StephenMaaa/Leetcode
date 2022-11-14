package DP;

/*
Determine the largest square of 1s in a binary matrix (a binary matrix only contains 0 and 1), return the length of the largest square.

        Assumptions

        The given matrix is not null and guaranteed to be of size N * N, N >= 0
        Examples

        { {0, 0, 0, 0},

        {1, 1, 1, 1},

        {0, 1, 1, 1},

        {1, 0, 1, 1}}

        the largest square of 1s has length of 2
*/

public class LargestSquareOf1s {
//    public int largest(int[][] matrix) {
//        int max = 0;
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                if (i != 0 && j != 0 && matrix[i][j] != 0 && matrix[i - 1][j - 1] != 0 && matrix[i - 1][j] != 0 && matrix[i][j - 1] != 0) {
//                    matrix[i][j] = Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i][j - 1])) + 1;
//                }
//                max = Math.max(max, matrix[i][j]);
//            }
//        }
//        return max;
//    }

    public int largest(int[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i != 0 && j != 0 && matrix[i][j] != 0) {
                    matrix[i][j] = Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i][j - 1])) + 1;
                }
                max = Math.max(max, matrix[i][j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{0,1,1,1},{1,1,0,1},{0,1,0,1},{1,1,1,1}};
        LargestSquareOf1s test = new LargestSquareOf1s();
        System.out.println(test.largest(arr));
    }
}
