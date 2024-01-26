package BFS;

/*
LeetCode 130

Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.

        A region is captured by flipping all 'O's into 'X's in that surrounded region.
*/

import java.util.ArrayDeque;
import java.util.Queue;

public class SurroundedRegions {
    // approach 1: BFS TC: O(mn) SC: O(mn)
    public void solve(char[][] board) {
        // init
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean[][] secured = new boolean[board.length][board[0].length];

        // add 'O' at the border
        for (int i = 0; i < board.length; i++) {
            // check
            if (board[i][0] == 'O') {
                queue.offer(new int[]{i, 0});
                secured[i][0] = true;
            }

            if (board[i][board[0].length - 1] == 'O') {
                queue.offer(new int[]{i, board[0].length - 1});
                secured[i][board[0].length - 1] = true;
            }
        }

        for (int i = 0; i < board[0].length; i++) {
            // check
            if (board[0][i] == 'O') {
                queue.offer(new int[]{0, i});
                secured[0][i] = true;
            }

            if (board[board.length - 1][i] == 'O') {
                queue.offer(new int[]{board.length - 1, i});
                secured[board.length - 1][i] = true;
            }
        }

        // explore
        while (!queue.isEmpty()) {
            int[] entry = queue.poll();
            int x = entry[0];
            int y = entry[1];

            // expand
            for (int[] dir : directions) {
                int col = x + dir[0];
                int row = y + dir[1];

                // check
                if (col >= 0 && col < board.length && row >= 0 && row < board[0].length && board[col][row] == 'O' && !secured[col][row]) {
                    queue.offer(new int[]{col, row});
                    secured[col][row] = true;
                }
            }
        }

        // process board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // check secured
                if (board[i][j] == 'O' && !secured[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void main(String[] args) {
        SurroundedRegions test = new SurroundedRegions();
        char[][] board = new char[][]{{'O', 'X', 'O', 'O', 'O', 'X'}, {'O', 'O', 'X', 'X', 'X', 'O'}, {'X', 'X', 'X', 'X', 'X', 'O'}, {'O', 'O', 'O', 'O', 'X', 'X'}, {'X', 'X', 'O', 'O', 'X', 'O'}, {'O', 'O', 'X', 'X', 'X', 'X'}};
        test.solve(board);
    }
}
