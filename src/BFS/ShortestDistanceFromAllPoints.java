package BFS;

/*
You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:

        Each 0 marks an empty land which you can pass by freely.
        Each 1 marks a building which you cannot pass through.
        Each 2 marks an obstacle which you cannot pass through.
        For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):

        1 - 0 - 2 - 0 - 1
        |   |   |   |   |
        0 - 0 - 0 - 0 - 0
        |   |   |   |   |
        0 - 0 - 1 - 0 - 0
        The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.

        Note:
        There will be at least one building. If it is not possible to build such house according to the above rules, return -1.
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestDistanceFromAllPoints {
//    public int shortestDistance(int[][] grid) {
//        int rows = grid.length;
//        int cols = grid[0].length;
//        int[][] minDis = new int[rows][cols];
//
//        // BFS
//        Deque<int[]> queue = new ArrayDeque<>();
//        int[][] visited = new int[rows][cols];
//        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//
//        // initialization
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
////                minDis[i][j] = 1;
//                if (grid[i][j] == 1) {
//                    queue.offer(new int[]{i, j});
//                    visited[i][j] = 1;
////                    minDis[i][j] = 0;
//                }
//            }
//        }
//        int size = queue.size();
//        int dis = 0;
//        while (!queue.isEmpty()) {
//            int[] entry = queue.poll();
//            int i = entry[0];
//            int j = entry[1];
////            visited[i][j] = 1;
//
//            // expand
//            for (int[] dir : directions) {
//                int row = i + dir[0];
//                int col = j + dir[1];
//
//                // check
//                if (row >= 0 && row < rows && col >= 0 && col < cols && grid[row][col] == 0 && visited[row][col] < size && visited[row][col] < visited[i][j]) {
//                    visited[row][col]++;
//                    minDis[row][col] += minDis[i][j] + 1;
//                    queue.offer(new int[]{row, col});
//                }
//            }
//        }
//
//        // update min
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                if (grid[i][j] == 0) {
//                    min = Math.min(min, minDis[i][j]);
//                }
//            }
//        }
//        return min;
//    }

    // time complexity: O(kmn)
    // space complexity: O(kmn)
    public int shortestDistance(int[][] grid) {
        // edge case
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int[][] nestedMin = new int[rows][cols];

        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        // BFS
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    if (!bfs(grid, nestedMin, new int[]{i, j}, count)) {
                        return -1;
                    }
                }
            }
        }

        // update min
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0 && nestedMin[i][j] > 0) {
                    min = Math.min(min, nestedMin[i][j]);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private boolean bfs(int[][] grid, int[][] nestedMin, int[] start, int count) {
        // BFS
        int rows = grid.length;
        int cols = grid[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        int[][] minDis = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // initialization
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

                // check
                if (row >= 0 && row < rows && col >= 0 && col < cols && grid[row][col] == 0 && !visited[row][col]) {
                    visited[row][col] = true;
                    minDis[row][col] += minDis[i][j] + 1;
                    queue.offer(new int[]{row, col});
                }
            }
        }

        // update
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0 && minDis[i][j] == 0) {
                    return false;
                }
                nestedMin[i][j] += minDis[i][j];
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ShortestDistanceFromAllPoints test = new ShortestDistanceFromAllPoints();
//        int[][] grid = new int[][]{{1, 0, 2, 0, 1},
//                                   {0, 0, 2, 0, 0},
//                                   {0, 0, 1, 0, 0}};
        int[][] grid = new int[][]{{1, 1},
                                   {0, 1}};
        System.out.println(test.shortestDistance(grid));
    }
}
