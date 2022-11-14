package DP;

/*
Determine the largest square surrounded by 1s in a binary matrix (a binary matrix only contains 0 and 1), return the length of the largest square.



        Assumptions

        The given matrix is guaranteed to be of size M * N, where M, N >= 0



        Examples

        {{1, 0, 1, 1, 1},

        {1, 1, 1, 1, 1},

        {1, 1, 0, 1, 0},

        {1, 1, 1, 1, 1},

        {1, 1, 1, 0, 0}}



        The largest square surrounded by 1s has length of 3.
*/

public class LargestSquareSurroundedByOne {
//    public int largestSquareSurroundedByOne(int[][] matrix) {
//        int max = 0;
//        int M = matrix.length;
//        int N = matrix[0].length;
//        int[][] left = new int[M][N];
//        int[][] top = new int[M][N];
//        for (int i = 0; i < M; i++) {
//            for (int j = 0; j < N; j++) {
//                if (matrix[i][j] == 1) {
//                    if (i == 0 && j == 0) {
//                        left[i][j] = matrix[i][j];
//                        top[i][j] = matrix[i][j];
//                    } else if (i == 0) {
//                        left[i][j] = left[i][j - 1] + 1;
//                        top[i][j] = matrix[i][j];
//                    } else if (j == 0) {
//                        left[i][j] = matrix[i][j];
//                        top[i][j] = top[i - 1][j] + 1;
//                    } else {
//                        left[i][j] = left[i][j - 1] + 1;
//                        top[i][j] = top[i - 1][j] + 1;
//                    }
//
//                    int maxLen = Math.min(left[i][j], top[i][j]);
//                    for (int k = maxLen; k > max; k--) {
//                        if (left[i - k + 1][j] >= maxLen && top[i][j - k + 1] >= maxLen) {
//                            max = k;
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//        return max;
//    }

    public int largestSquareSurroundedByOne(int[][] matrix) {
        int max = 0;
        int M = matrix.length;
        int N = matrix[0].length;
        int[][] left = new int[M + 1][N + 1];
        int[][] top = new int[M + 1][N + 1];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 1) {
                    left[i + 1][j + 1] = left[i + 1][j] + 1;
                    top[i + 1][j + 1] = top[i][j + 1] + 1;

                    int maxLen = Math.min(left[i + 1][j + 1], top[i + 1][j + 1]);
                    for (int k = maxLen; k > max; k--) {
                        if (left[i - k + 2][j + 1] >= k && top[i + 1][j - k + 2] >= k) {
                            max = k;
                            break;
                        }
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LargestSquareSurroundedByOne test = new LargestSquareSurroundedByOne();
        int[][] matrix = new int[][]{{0,1,1,1,1,0,0,1,1,0,1,1},{1,0,1,0,1,1,1,0,0,1,1,1},{0,1,1,0,1,1,1,1,0,1,1,1},{1,0,1,0,1,1,0,1,1,1,0,1},{0,1,1,0,0,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1,0,1,1,1},{1,1,1,1,1,1,0,1,0,1,0,1},{1,1,1,0,1,1,1,1,0,1,1,1},{1,1,1,0,0,0,0,1,0,1,1,0},{1,1,1,1,0,1,1,1,1,0,0,0},{1,1,1,1,1,0,1,1,0,1,1,0},{1,1,1,1,1,1,1,1,1,1,0,1},{1,1,1,1,1,1,0,1,1,1,0,1},{1,0,1,0,1,1,1,1,1,1,1,1},{1,0,1,0,1,1,0,1,0,1,0,0},{0,0,1,1,0,1,1,0,1,1,1,1},{1,1,0,0,1,1,1,1,1,1,1,1},{1,1,1,1,1,0,1,0,1,1,1,1},{1,1,1,1,1,1,1,0,1,1,1,1}};
        System.out.println(test.largestSquareSurroundedByOne(matrix));
    }
}
