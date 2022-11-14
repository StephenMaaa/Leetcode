package DFS;

/*
You are given an m x n integer array grid where grid[i][j] could be:

        1 representing the starting square. There is exactly one starting square.
        2 representing the ending square. There is exactly one ending square.
        0 representing empty squares we can walk over.
        -1 representing obstacles that we cannot walk over.
        Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
*/

public class UniquePathsIII {
    // approach 1 - DFS TC: O(4^mn) SC: O(mn)
    public int uniquePathsIII(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[] res = new int[1];
        boolean[][] visited = new boolean[rows][cols];
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // locate the starting index
        int count = 0;
        int startRow = 0;
        int startCol = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    count++;
                } else if (grid[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        dfs(grid, startRow, startCol, count, directions, visited, res);
        return res[0];
    }

    private void dfs(int[][] grid, int i, int j, int count, int[][] directions, boolean[][] visited, int[] res) {
        // base case
        if (grid[i][j] == 2) {
            if (count == 0) {
                res[0]++;
            }
            return;
        }

        // recursive case
        for (int[] dir : directions) {
            int row = i + dir[0];
            int col = j + dir[1];

            // check
            if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && (grid[row][col] == 0 || grid[row][col] == 2) && !visited[row][col]) {
                visited[row][col] = true;
                if (grid[row][col] == 0) {
                    dfs(grid, row, col, count - 1, directions, visited, res);
                } else {
                    dfs(grid, row, col, count, directions, visited, res);
                }
                visited[row][col] = false;
            }
        }
    }

    public static void main(String[] args) {
        UniquePathsIII test = new UniquePathsIII();
        int[][] grid = new int[][]{{1, 0, 0, 0},
                                   {0, 0, 0, 0},
                                   {0, 0, 2, -1}};
        System.out.println(test.uniquePathsIII(grid)); 
    }
}
