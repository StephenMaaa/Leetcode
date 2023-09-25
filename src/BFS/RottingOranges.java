package BFS;

/*
You are given an m x n grid where each cell can have one of three values:

        0 representing an empty cell,
        1 representing a fresh orange, or
        2 representing a rotten orange.
        Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

        Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
*/

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class RottingOranges {
//    // approach 1 - BFS TC: O(mn) SC: O(mn)
//    public int orangesRotting2(int[][] grid) {
//        Queue<int[]> queue = new ArrayDeque<>();
//        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//        int rows = grid.length;
//        int cols = grid[0].length;
//
//        // initialization
//        int total = 0;
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                if (grid[i][j] == 1) {
//                    total++;
//                }
//
//                if (grid[i][j] == 2) {
//                    queue.offer(new int[]{i, j});
//                }
//            }
//        }
//
//        // BFS
//        int count = 0;
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                int[] entry = queue.poll();
//                int x = entry[0];
//                int y = entry[1];
//
//                // expanding
//                for (int[] dir : directions) {
//                    int row = x + dir[0];
//                    int col = y + dir[1];
//
//                    // check
//                    if (row >= 0 && row < rows && col >= 0 && col < cols && grid[row][col] == 1) {
//                        grid[row][col] = 2;
//                        queue.offer(new int[]{row, col});
//                        total--;
//                    }
//                }
//            }
//            count++;
//        }
//
//        if (count > 0) {
//            count--;
//        }
//        return total == 0 ? count : -1;
//    }

    // approach 1: BFS TC: O(mn) SC: O(mn)
    public int orangesRotting(int[][] grid) {
        // initialization
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // count fresh orange
                if (grid[i][j] == 1) {
                    count++;
                }

                // check rotten orange
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // edge case
        if (count == 0) {
            return 0;
        }

        // BFS
        int step = -1;
        while (!queue.isEmpty()) {
            // explore all
            int size = queue.size();
            for (int index = 0; index < size; index++) {
                int[] entry = queue.poll();
                int i = entry[0];
                int j = entry[1];

                // explore four directions
                for (int[] dir : directions) {
                    int row = i + dir[0];
                    int col = j + dir[1];

                    // check valid entry
                    if (row >= 0 && row < rows && col >= 0 && col < cols && grid[row][col] == 1) {
                        queue.offer(new int[]{row, col});
                        grid[row][col] = 2;
                        count--;
                    }
                }
            }
            step++;
        }
        return count == 0 ? step : -1;
    }

    public static void main(String[] args) {
        RottingOranges test = new RottingOranges();
        int[][] grid = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(test.orangesRotting(grid));
    }
}
