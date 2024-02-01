package BFS;

/*
LeetCode 417

Given an m * n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.

        Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

        Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean. The order of returned grid coordinates does not matter.


        Example:

        Given the following 4 * 4 matrix:

        Pacific   ~   ~    ~   ~

        ~      1    2    2   (3)   *

        ~      3    2    3   (4)   *

        ~      2    4   (5)   3   *

        ~      (6)  (7)   1   4   *

        *    *    *    *  Atlantic

        Output: [0,3],[1,3],[2,2],[3,0],[3,1]
*/

import java.util.*;

public class PacificAtlanticFlow {
//    // time complexity: O(mn)
//    // space complexity: O(mn)
//    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
//        List<List<Integer>> res = new ArrayList<>();
//        // edge case
//        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
//            return res;
//        }
//
//        int rows = matrix.length;
//        int cols = matrix[0].length;
//        int[][] pacific = generatePacific(matrix);
//        int[][] atlantic = generateAtlantic(matrix);
//
//        // check
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                if (pacific[i][j] == 1 && atlantic[i][j] == 1) {
//                    res.add(Arrays.asList(i, j));
//                }
//            }
//        }
//        return res;
//    }
//
//    private int[][] generatePacific(int[][] matrix) {
//        // BFS
//        int rows = matrix.length;
//        int cols = matrix[0].length;
//        int[][] pacific = new int[rows][cols];
//        Deque<int[]> queue = new ArrayDeque<>();
//        boolean[][] visited = new boolean[rows][cols];
//        int[][] directions = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
//
//        // initialization
//        for (int i = 0; i < cols; i++) {
//            if (!visited[0][i]) {
//                pacific[0][i] = 1;
//                queue.add(new int[]{0, i});
//                visited[0][i] = true;
//            }
//        }
//
//        for (int i = 0; i < rows; i++) {
//            if (!visited[i][0]) {
//                pacific[i][0] = 1;
//                queue.offer(new int[]{i, 0});
//                visited[i][0] = true;
//            }
//        }
//
//        while (!queue.isEmpty()) {
//            int[] entry = queue.poll();
//            int i = entry[0];
//            int j = entry[1];
//
//            // expand
//            for (int[] dir : directions) {
//                int row = i + dir[0];
//                int col = j + dir[1];
//                if (row >= 0 && row < rows && col >= 0 && col < cols && matrix[i][j] <= matrix[row][col] && !visited[row][col]) {
//                    pacific[row][col] = 1;
//                    queue.offer(new int[]{row, col});
//                    visited[row][col] = true;
//                }
//            }
//        }
//        return pacific;
//    }
//
//    private int[][] generateAtlantic(int[][] matrix) {
//        // BFS
//        int rows = matrix.length;
//        int cols = matrix[0].length;
//        int[][] atlantic = new int[rows][cols];
//        Deque<int[]> queue = new ArrayDeque<>();
//        boolean[][] visited = new boolean[rows][cols];
//        int[][] directions = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
//
//        // initialization
//        for (int i = cols - 1; i >= 0; i--) {
//            if (!visited[rows - 1][i]) {
//                atlantic[rows - 1][i] = 1;
//                queue.add(new int[]{rows - 1, i});
//                visited[rows - 1][i] = true;
//            }
//        }
//
//        for (int i = rows - 1; i >= 0; i--) {
//            if (!visited[i][cols - 1]) {
//                atlantic[i][cols - 1] = 1;
//                queue.offer(new int[]{i, cols - 1});
//                visited[i][cols - 1] = true;
//            }
//        }
//
//        while (!queue.isEmpty()) {
//            int[] entry = queue.poll();
//            int i = entry[0];
//            int j = entry[1];
//
//            // expand
//            for (int[] dir : directions) {
//                int row = i + dir[0];
//                int col = j + dir[1];
//                if (row >= 0 && row < rows && col >= 0 && col < cols && matrix[i][j] <= matrix[row][col] && !visited[row][col]) {
//                    atlantic[row][col] = 1;
//                    queue.offer(new int[]{row, col});
//                    visited[row][col] = true;
//                }
//            }
//        }
//        return atlantic;
//    }

    // approach 1: BFS TC: O(mn) SC: O(mn)
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // initialization for pacific
        int rows = heights.length;
        int cols = heights[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[rows][cols];
        int[][] directions = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        // top left to bottom right
        for (int i = 0; i < rows; i++) {
            queue.offer(new int[]{i, 0});
            visited[i][0] = true;
        }

        for (int j = 0; j < cols; j++) {
            queue.offer(new int[]{0, j});
            visited[0][j] = true;
        }

        // BFS
        while (!queue.isEmpty()) {
            int[] entry = queue.poll();
            int i = entry[0];
            int j = entry[1];

            // check neighbors
            for (int[] dir : directions) {
                int row = i + dir[0];
                int col = j + dir[1];

                // check
                if (row >= 0 && row < rows && col >= 0 && col < cols && heights[i][j] <= heights[row][col] && !visited[row][col]) {
                    queue.offer(new int[]{row, col});
                    visited[row][col] = true;
                }
            }
        }

        // initialization for atlantic
        boolean[][] visited2 = new boolean[rows][cols];

        // bottom right to top left
        for (int i = 0; i < rows; i++) {
            queue.offer(new int[]{i, cols - 1});
            visited2[i][cols - 1] = true;
        }

        for (int j = 0; j < cols; j++) {
            queue.offer(new int[]{rows - 1, j});
            visited2[rows - 1][j] = true;
        }

        // BFS
        while (!queue.isEmpty()) {
            int[] entry = queue.poll();
            int i = entry[0];
            int j = entry[1];

            // check neighbors
            for (int[] dir : directions) {
                int row = i + dir[0];
                int col = j + dir[1];

                // check
                if (row >= 0 && row < rows && col >= 0 && col < cols && heights[i][j] <= heights[row][col] && !visited2[row][col]) {
                    queue.offer(new int[]{row, col});
                    visited2[row][col] = true;
                }
            }
        }

        // process
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // check
                if (visited[i][j] && visited2[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res; 
    }

    public static void main(String[] args) {
        PacificAtlanticFlow test = new PacificAtlanticFlow();
        int[][] matrix = new int[][]{{1, 2, 2, 3},
                                     {3, 2, 3, 4},
                                     {2, 4, 5, 3},
                                     {6, 7, 1, 4}};
        System.out.println(test.pacificAtlantic(matrix)); 
    }
}
