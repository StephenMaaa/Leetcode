package DP;

/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.You can only move either down or right at any point in time.

        Input: [

        [5, 1, 2, 4],

        [4, 1, 0, 1],

        [0, 3, 7, 6]

        ]

        Output: 14
*/

public class MinimumPathSum {
    // time complexity: O(mn)
    // space complexity: O(mn)
    public int miniSum(int[][] grid) {
        // edge case
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[][] minCosts = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    minCosts[i][j] = grid[i][j];
                } else if (i == 0) {
                    minCosts[i][j] = minCosts[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    minCosts[i][j] = minCosts[i - 1][j] + grid[i][j];
                } else {
                    minCosts[i][j] = Math.min(minCosts[i - 1][j], minCosts[i][j - 1]) + grid[i][j];
                }
            }
        }
        return minCosts[m - 1][n - 1];
    }

//    // approach 1 - 2D DP TC: O(mn) SC: O(mn)
//    public int minPathSum(int[][] grid) {
//        int m = grid.length;
//        int n = grid[0].length;
//        int[][] dp = new int[m + 1][n + 1];
//
//        // initialization
//        for (int i = 2; i < m + 1; i++) {
//            dp[i][0] = Integer.MAX_VALUE;
//        }
//        for (int i = 2; i < n + 1; i++) {
//            dp[0][i] = Integer.MAX_VALUE;
//        }
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                dp[i + 1][j + 1] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
//            }
//        }
//        return dp[m][n];
//    }

    // approach 2 - in-place 2D DP TC: O(mn) SC: O(1)
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    grid[i][j] += grid[i][j - 1];
                } else if (j == 0) {
                    grid[i][j] += grid[i - 1][j];
                } else {
                    grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
                }
            }
        }
        return grid[m - 1][n - 1]; 
    }

    public static void main(String[] args) {
        MinimumPathSum test = new MinimumPathSum();
        int[][] matrix = new int[][]{{1, 2, 6}};
        System.out.println(test.minPathSum(matrix));
    }
}
