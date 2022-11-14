package BFS;

/*
Given a 2d grid map of 1s (land) and 0s (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

        Example 1:

        11110
        11010
        11000
        00000
        Answer: 1

        Example 2:

        11000
        11000
        00100
        00011
        Answer: 3
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class NumberOfIslands {
    // time complexity: O(mn)
    // space complexity: O(mn)
    public int numIslands(char[][] grid) {
        // edge case
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // BFS
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    bfs(grid, visited, new int[]{i, j});
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, boolean[][] visited, int[] start) {
        Deque<int[]> queue = new ArrayDeque<>();
        int[][] directions = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        queue.offer(start);
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] entry = queue.poll();
            int i = entry[0];
            int j = entry[1];

            // expand
            for (int[] dir : directions) {
                int row = i + dir[0];
                int col = j + dir[1];
                if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == '1' && !visited[row][col]) {
                    queue.offer(new int[]{row, col});
                    visited[row][col] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        NumberOfIslands test = new NumberOfIslands();
        char[][] grid = new char[][]{{'1', '1', '1', '1', '0'},
                                     {'1', '1', '0', '1', '0'},
                                     {'1', '1', '0', '0', '0'},
                                     {'0', '0', '0', '0', '0'}};
        System.out.println(test.numIslands(grid));
    }
}
