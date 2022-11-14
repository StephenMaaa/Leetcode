package BFS;

/*
Suppose there are 0s and 1s in a matrix. Cell A and Cell B are adjacent if Cell B is above, below, on the left, or on the right of Cell A. The distance between two adjacent cell is 1. Calculate the distance to the closest 0 of each cell.

        Example 1:
        Input:

        1 1 1
        1 0 1
        1 1 1
        Output:
        2 1 2
        1 0 1
        2 1 2
        Example 2:
        Input:

        1 1 1
        0 1 0
        0 0 0
        Output:
        1 2 1
        0 1 0
        0 0 0
        Assumption:

        There are at least one 0 in the given matrix.
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class DistanceToZero {
    // time complexity: O(mn)
    // space complexity: O(mn)
    public int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] minDis = new int[rows][cols];
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[rows][cols];
        int[][] directions = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        // initialization
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                } else {
                    minDis[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        // BFS
        while (!queue.isEmpty()) {
            int[] entry = queue.poll();
            int i = entry[0];
            int j = entry[1];

            // expand
            for (int[] dir : directions) {
                int row = i + dir[0];
                int col = j + dir[1];

                if (row >= 0 && row < rows && col >= 0 && col < cols && !visited[row][col]) {
                    minDis[row][col] = Math.min(minDis[row][col], minDis[i][j] + 1);
                    queue.offer(new int[]{row, col});
                    visited[row][col] = true;
                }
            }
        }
        return minDis;
    }

    public static void main(String[] args) {
        DistanceToZero test = new DistanceToZero();
        int[][] matrix = new int[][]{{1, 1, 1},
                                     {1, 0, 1},
                                     {1, 1, 1}};
        int[][] minDis = test.updateMatrix(matrix);
    }
}
