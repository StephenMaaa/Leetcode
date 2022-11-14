package DP;

/*
There is a robot on top left corner of the matrix, it can only move down or right. The matrix is represented by either 0(path) or 1(obstacle). For obstacle, robot can not move through. Find the number of possible ways for robot to move to right down corner.

        Input:    [

        [0,0,0],

        [0,1,0],

        [0,0,0]

        ]

        Output: 2

        You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m-1][n-1]). The robot can only move either down or right at any point in time.

        An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.

        Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

        The testcases are generated so that the answer will be less than or equal to 2 * 10^9.
*/

import java.util.ArrayDeque;
import java.util.Queue;

public class UniquePathsII {
    // time complexity: O(mn)
    // space complexity: O(mn)
    public int possiblepath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] steps = new int[m][n];
        steps[0][0] = 1 - matrix[0][0];

        // BFS
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];
        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] entry = queue.poll();
            int i = entry[0];
            int j = entry[1];

            // update steps at entry [i, j]
            if (matrix[i][j] == 0) {
                steps[i][j] += i > 0 ? steps[i - 1][j] : 0;
                steps[i][j] += j > 0 ? steps[i][j - 1] : 0;
            }

            // expand right and bottom entries
            if (i + 1 < m && !visited[i + 1][j]) {
                queue.offer(new int[]{i + 1, j});
                visited[i + 1][j] = true;
            }

            if (j + 1 < n && !visited[i][j + 1]) {
                queue.offer(new int[]{i, j + 1});
                visited[i][j + 1] = true;
            }
        }
        return steps[m - 1][n - 1];
    }

    // approach 1 - 2D DP TC: O(mn) SC: O(mn)
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] counts = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    counts[i + 1][j + 1] = 1 - obstacleGrid[i][j];
                    continue;
                }

                // case 1: obstacle
                // case 2: path
                if (obstacleGrid[i][j] == 1) {
                    counts[i + 1][j + 1] = 0;
                } else {
                    counts[i + 1][j + 1] = counts[i + 1][j] + counts[i][j + 1];
                }
            }
        }
        return counts[m][n];
    }

    // approach 3 - 1D DP TC: O(mn) SC: O(n)
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] counts = new int[n];
        counts[0] = 1 - obstacleGrid[0][0];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    counts[j] = 0;
                } else if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    counts[j] += counts[j - 1];
                }
            }
        }
        return counts[n - 1];
    }

    public static void main(String[] args) {
        UniquePathsII test = new UniquePathsII();
        int[][] matrix = new int[][]{{0, 1, 0}};
        System.out.println(test.uniquePathsWithObstacles(matrix));
    }
}
