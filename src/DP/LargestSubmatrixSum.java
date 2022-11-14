package DP;

/*
Given a matrix that contains integers, find the submatrix with the largest sum.

        Return the sum of the submatrix.

        Assumptions

        The given matrix is not null and has size of M * N, where M >= 1 and N >= 1
        Examples

        { {1, -2, -1, 4},

        {1, -1,  1, 1},

        {0, -1, -1, 1},

        {0,  0,  1, 1} }

        the largest submatrix sum is (-1) + 4 + 1 + 1 + (-1) + 1 + 1 + 1 = 7.
*/

public class LargestSubmatrixSum {
    // time complexity: O(n^3)
    // space complexity: O(n^2)
    public int largest(int[][] matrix) {
        // populate 1D sum matrix
        int[][] colSum = generate1DSum(matrix);
        int max = Integer.MIN_VALUE;

        for (int topRow = 0; topRow < matrix.length; topRow++) {
            for (int bottomRow = topRow; bottomRow < matrix.length; bottomRow++) {
                // generate 2D sum array for that matrix between topRow and bottomRow
                int[] prefixSum = generate2DSum(matrix, colSum, topRow, bottomRow);
                max = Math.max(max, largestSubArraySum(prefixSum));
            }
        }
        return max;
    }

    private int[][] generate1DSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] rowSum = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i][j] = i == 0 ? matrix[i][j] : rowSum[i - 1][j] + matrix[i][j];
            }
        }
        return rowSum;
    }

    private int[] generate2DSum(int[][] matrix, int[][] rowSum, int topRow, int bottomRow) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] prefixSum = new int[n];
        for (int i = 0; i < n; i++) {
            prefixSum[i] = rowSum[bottomRow][i] - rowSum[topRow][i] + matrix[topRow][i];
        }
        return prefixSum;
    }

    private int largestSubArraySum(int[] arr) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            // case 1: sum > 0
            // case 2: otherwise
            if (sum > 0) {
                sum += arr[i];
            } else {
                sum = arr[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        LargestSubmatrixSum test = new LargestSubmatrixSum();
        int[][] matrix = new int[][]{{2, -1, 2, 1, -3},
                                     {0, -2, -1, 2, 1},
                                     {3, 2, 1, -3, -2}};
        System.out.println(test.largest(matrix));
    }
}
