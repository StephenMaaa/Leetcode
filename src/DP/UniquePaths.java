package DP;

/*
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

        Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

        The test cases are generated so that the answer will be less than or equal to 2 * 10^9.
*/

public class UniquePaths {
//     // approach 1 - Combination TC: O(n) SC: O(1)
//     public int uniquePaths(int m, int n) {
//         // combination C(n, r) = n! / r! (n - r)!
//         long res = 1;
//         int length = m + n - 2;
//         int r = Math.max(m, n);
//         int j = 1;
//         for (int i = r; i <= length; i++, j++) {
//             res *= i;
//             res /= j;
//         }
//         return (int) res;
//     }
//
//    // approach 2 - DP TC: O(mn) SC: O(mn)
//    public int uniquePaths2(int m, int n) {
//        int[][] counts = new int[m][n];
//
//        for (int i = 0; i < m; i++) {
//            counts[i][0] = 1;
//        }
//
//        for (int j = 0; j < n; j++) {
//            counts[0][j] = 1;
//        }
//
//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//                counts[i][j] = counts[i - 1][j] + counts[i][j - 1];
//            }
//        }
//        return counts[m - 1][n - 1];
//    }

    // approach 1: DP TC: O(mn) SC: O(mn)
    public int uniquePaths(int m, int n) {
        // initialization
        int[][] dp = new int[m][n];

        // base case
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // update rule: dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1]; 
    }
}
