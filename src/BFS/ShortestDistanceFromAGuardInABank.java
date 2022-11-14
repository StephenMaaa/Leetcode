package BFS;

/*
Given a matrix that is filled with ‘O’, ‘G’, and ‘W’ where ‘O’ represents open space, ‘G’ represents guards and ‘W’ represents walls in a Bank.
        Replace all of the O’s in the matrix with their shortest distance from a guard, without being able to go through any walls.
        Also, replace the guards with 0 and walls with -1 in output matrix.
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestDistanceFromAGuardInABank {
    // approach 1 - BFS TC: O(mn) SC: O(mn)
    public int[][] shortestDistance(char[][] grid) {
        // edge case
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return null;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int[][] minDis = new int[rows][cols];

        // BFS
        Deque<int[]> queue = new ArrayDeque<>();
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // initialization
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 'G') {
                    queue.offer(new int[]{i, j});
                }

                if (grid[i][j] == 'W') {
                    minDis[i][j] = -1;
                }
            }
        }

        // expansion
        while (!queue.isEmpty()) {
            int[] entry = queue.poll();
            int i = entry[0];
            int j = entry[1];

            for (int[] dir : directions) {
                int row = i + dir[0];
                int col = j + dir[1];

                // check
                if (row >= 0 && row < rows && col >= 0 && col < cols && grid[row][col] == 'O' && minDis[row][col] == 0) {
                    queue.offer(new int[]{row, col});
                    minDis[row][col] = minDis[i][j] + 1;
                }
            }
        }
        return minDis;
    }

    public static void main(String[] args) {
        ShortestDistanceFromAGuardInABank test = new ShortestDistanceFromAGuardInABank();
        char[][] grid = new char[][]{{ 'O', 'O', 'O', 'O', 'G' },
                                     { 'O', 'W', 'W', 'O', 'O' },
                                     { 'O', 'O', 'O', 'W', 'O' },
                                     { 'G', 'W', 'W', 'W', 'O' },
                                     { 'O', 'O', 'O', 'O', 'G' }};
        int[][] minDis = test.shortestDistance(grid);
    }
}
