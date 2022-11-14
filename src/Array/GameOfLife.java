package Array;

/*
According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

        The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

        Any live cell with fewer than two live neighbors dies as if caused by under-population.
        Any live cell with two or three live neighbors lives on to the next generation.
        Any live cell with more than three live neighbors dies, as if by over-population.
        Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
        The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.
*/

public class GameOfLife {
    // approach 1 - Arrays TC: O(mn) SC: O(1)
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int[][] directions = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int n = checkNeighbor(board, i, j, directions);

                // check
                if (board[i][j] == 1 && (n < 2 || n > 3)) {
                    board[i][j] = -1;
                } else if (board[i][j] == 0 && n == 3) {
                    board[i][j] = 2;
                }
            }
        }

        // flip -1 to 0 and 2 to 1
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                } else if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private int checkNeighbor(int[][] board, int i, int j, int[][] directions) {
        int n = 0;
        for (int[] dir : directions) {
            int row = i + dir[0];
            int col = j + dir[1];

            if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
                continue;
            }

            if (board[row][col] == 1 || board[row][col] == -1) {
                n++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        GameOfLife test = new GameOfLife();
        int[][] board = new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        test.gameOfLife(board);
    }
}
