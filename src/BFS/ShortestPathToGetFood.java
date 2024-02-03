package BFS;

/*
LeetCode 1730

You are starving and you want to eat food as quickly as possible. You want to find the shortest path to arrive at any food cell.

        You are given an m x n character matrix, grid, of these different types of cells:

        '*' is your location. There is exactly one '*' cell.
        '#' is a food cell. There may be multiple food cells.
        'O' is free space, and you can travel through these cells.
        'X' is an obstacle, and you cannot travel through these cells.
        You can travel to any adjacent cell north, east, south, or west of your current location if there is not an obstacle.

        Return the length of the shortest path for you to reach any food cell. If there is no path for you to reach food, return -1.
*/

import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestPathToGetFood {
    // approach 1: BFS TC: O(mn) SC: O(mn)
    public int getFood(char[][] grid) {
        // initialization
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // check origin
                if (grid[i][j] == '*') {
                    queue.offer(new int[]{i, j});
                    grid[i][j] = 'V';
                }
            }
        }

        // BFS
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int index = 0; index < size; index++) {
                int[] entry = queue.poll();
                int i = entry[0];
                int j = entry[1];

                // check food
                if (grid[i][j] == '#') {
                    return count;
                }

                // expand
                for (int[] dir : directions) {
                    int row = i + dir[0];
                    int col = j + dir[1];

                    // check
                    if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] != 'X' && grid[row][col] != 'V') {
                        queue.offer(new int[]{row, col});
                        grid[row][col] = grid[row][col] == '#' ? '#' : 'V';
                    }
                }
            }

            // update
            count++;
        }
        return -1;
    }
}
