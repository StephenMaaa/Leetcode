package DP;

/*
Determine the largest square surrounded by a bunch of matches (each match is either horizontal or vertical), return the length of the largest square.

        The input is a matrix of points. Each point has one of the following values:

        0 - there is no match to its right or bottom.

        1 - there is a match to its right.

        2 - there is a match to its bottom.

        3 - there is a match to its right, and a match to its bottom.



        Assumptions

        The given matrix is guaranteed to be of size M * N, where M, N >= 0
*/

public class LargestSquareOfMatches {
    public int largestSquareOfMatches(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[][] left = new int[m + 1][n + 2];
        int[][] top = new int[m + 1][n + 2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // update left and top matrices
                if (matrix[i][j] == 1) {
                    left[i + 1][j + 1] = left[i + 1][j] + 1;
                } else if (matrix[i][j] == 2) {
                    top[i + 1][j + 1] = top[i][j + 1] + 1;
                } else if (matrix[i][j] == 3) {
                    left[i + 1][j + 1] = left[i + 1][j] + 1;
                    top[i + 1][j + 1] = top[i][j + 1] + 1;
                }

                int maxLen = Math.min(left[i + 1][j + 1], top[i][j + 2]);
                for (int k = maxLen; k > max; k--) {
                    // check the square
                    if (left[i - k + 1][j + 1] >= k && top[i][j - k + 2] >= k) {
                        max = k;
                        break;
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LargestSquareOfMatches test = new LargestSquareOfMatches();
        int[][] matrix = new int[][]{
                {3, 1, 1, 3, 0, 1, 1, 0},

                {2, 0, 0, 2, 0, 0, 0, 0},

                {3, 1, 3, 0, 0, 0, 0, 0},

                {2, 0, 2, 0, 0, 0, 0, 0},

                {1, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(test.largestSquareOfMatches(matrix));
    }
}
