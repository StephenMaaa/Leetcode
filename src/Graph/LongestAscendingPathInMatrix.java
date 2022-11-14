package Graph;

/*
Given an integer matrix, find the length of the longest ascending path.

        From a cell, there are 4 directions to reach a neighbor(up, down, left, right).

        Examples:

        { {1, 2, 3},

        {4, 2, 6},

        {7, 1, 9} }

        The longest ascending path is 1 -> 2 -> 3 -> 6 -> 9, length is 5
*/

import java.util.ArrayDeque;
import java.util.Queue;

public class LongestAscendingPathInMatrix {
    // time complexity: O(mn)
    // space complexity: O(mn)
    public int longest(int[][] matrix) {
        // edge case
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] steps = new int[rows][cols];

        // generate indegrees matrix
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][] indegrees = generateIndegrees(matrix, directions);

        // initialize queue
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (indegrees[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        // topological sort
        while (!queue.isEmpty()) {
            int[] entry = queue.poll();
            int i = entry[0];
            int j = entry[1];

            // update steps for neighbors
            for (int[] dir : directions) {
                int row = i + dir[0];
                int col = j + dir[1];
                if (row >= 0 && row < rows && col >= 0 && col < cols && matrix[row][col] > matrix[i][j]) {
                    steps[row][col] = Math.max(steps[row][col], steps[i][j] + 1);

                    // update indegrees for neighbors
                    if (--indegrees[row][col] == 0) {
                        queue.offer(new int[]{row, col});
                    }
                }
            }
        }

        // find max steps
        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                max = Math.max(max, steps[i][j]);
            }
        }
        return max + 1;
    }

    private int[][] generateIndegrees(int[][] matrix, int[][] directions) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] indegrees = new int[rows][cols];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // update indegrees from neigbhors
                for (int[] dir : directions) {
                    int row = i + dir[0];
                    int col = j + dir[1];
                    if (row >= 0 && row < rows && col >= 0 && col < cols && matrix[row][col] < matrix[i][j]) {
                        indegrees[i][j]++;
                    }
                }
            }
        }
        return indegrees;
    }

    // approach 1 - Graph (Topological Sort) TC: O(mn) SC: O(mn)
    public int longestIncreasingPath(int[][] matrix) {
        // initialization
        int rows = matrix.length;
        int cols = matrix[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] max = new int[rows][cols];
        int[][] indegrees = new int[rows][cols];
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // generate indegrees matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // check neighbors
                for (int[] dir : directions) {
                    int row = i + dir[0];
                    int col = j + dir[1];
                    if (row >= 0 && row < rows && col >= 0 && col < cols && matrix[i][j] > matrix[row][col]) {
                        indegrees[i][j]++;
                    }
                }
            }
        }

        // initialize queue
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // add to queue if indegree == 0
                if (indegrees[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // BFS
        while (!queue.isEmpty()) {
            int[] entry = queue.poll();
            int i = entry[0];
            int j = entry[1];

            // expanding
            for (int[] dir : directions) {
                int row = i + dir[0];
                int col = j + dir[1];

                // check
                if (row >= 0 && row < rows && col >= 0 && col < cols && matrix[i][j] < matrix[row][col]) {
                    max[row][col] = Math.max(max[row][col], max[i][j] + 1);

                    // check and update indegree
                    if (--indegrees[row][col] == 0) {
                        queue.offer(new int[]{row, col});
                    }
                }
            }
        }

        // find max
        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res = Math.max(res, max[i][j]);
            }
        }
        return res + 1; 
    }

    public static void main(String[] args) {
        LongestAscendingPathInMatrix test = new LongestAscendingPathInMatrix();
        int[][] matrix = new int[][]{ {1, 2, 3},
                                      {4, 111, 6},
                                      {7, 11, 9} };
        System.out.println(test.longest(matrix));
    }
}
