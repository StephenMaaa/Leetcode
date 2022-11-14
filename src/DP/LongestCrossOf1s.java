package DP;

/*
Given a matrix that contains only 1s and 0s, find the largest cross which contains only 1s, with the same arm lengths and the four arms joining at the central point.

        Return the arm length of the largest cross.

        Assumptions

        The given matrix is not null, has size of N * M, N >= 0 and M >= 0.
        Examples

        { {0, 0, 0, 0},

        {1, 1, 1, 1},

        {0, 1, 1, 1},

        {1, 0, 1, 1} }

        the largest cross of 1s has arm length 2.
*/

public class LongestCrossOf1s {
    public int largest(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] leftTop = getLeftTop(matrix);
        int[][] rightBottom = getRightBottom(matrix);
        matrix = merge(leftTop, rightBottom);
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, matrix[i][j]);
            }
        }
        return max;
    }

    private int[][] getLeftTop(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int[][] left = new int[row][col];
        int[][] top = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    left[i][j] = matrix[i][j];
                    top[i][j] = matrix[i][j];
                } else if (i == 0) {
                    left[i][j] = matrix[i][j] == 0 ? 0 : left[i][j - 1] + 1;
                    top[i][j] = matrix[i][j];
                } else if (j == 0) {
                    left[i][j] = matrix[i][j];
                    top[i][j] = matrix[i][j] == 0 ? 0 : top[i - 1][j] + 1;
                } else {
                    left[i][j] = matrix[i][j] == 0 ? 0 : left[i][j - 1] + 1;
                    top[i][j] = matrix[i][j] == 0 ? 0 : top[i - 1][j] + 1;
                }
            }
        }
        return merge(left, top);
    }

    private int[][] getRightBottom(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int[][] right = new int[row][col];
        int[][] bottom = new int[row][col];
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (i == row - 1 && j == col - 1) {
                    right[i][j] = matrix[i][j];
                    bottom[i][j] = matrix[i][j];
                } else if (i == row - 1) {
                    right[i][j] = matrix[i][j] == 0 ? 0 : right[i][j + 1] + 1;
                    bottom[i][j] = matrix[i][j];
                } else if (j == col - 1) {
                    right[i][j] = matrix[i][j];
                    bottom[i][j] = matrix[i][j] == 0 ? 0 : bottom[i + 1][j] + 1;
                } else {
                    right[i][j] = matrix[i][j] == 0 ? 0 : right[i][j + 1] + 1;
                    bottom[i][j] = matrix[i][j] == 0 ? 0 : bottom[i + 1][j] + 1;
                }
            }
        }
        return merge(right, bottom);
    }

    private int[][] merge(int[][] arr1, int[][] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                arr1[i][j] = Math.min(arr1[i][j], arr2[i][j]);
            }
        }
        return arr1;
    }



    public static void main(String[] args) {
        LongestCrossOf1s test = new LongestCrossOf1s();
        int[][] arr = new int[][]{{1,1,1,1,1},{1,0,0,1,1},{1,1,1,1,1},{1,1,1,1,0},{0,0,0,1,1}};
        System.out.println(test.largest(arr));
    }
}
