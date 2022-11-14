package DFS;

/*
Given a 2D board and a word, find if the word exists in the grid.The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

        Input: board = [

        [“ABCE”],

        [“SFCS”],

        [“ADEE”]

        ]

        Output: Word = “ABCCED”   return true

        Word = “SEE”      return true

        Word = “ABCB”      return false
*/

public class WordSearch {
    // time complexity: O(mn * 4^k)
    // space complexity: O(mn)
    public boolean isWord(char[][] board, String word) {
        // edge case
        if (word == null || word.length() == 0) {
            return false;
        }

        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        boolean[] status = new boolean[1];
        int[][] directions = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (word.charAt(0) == board[i][j]) {
                    visited[i][j] = true;
                    dfs(board, word, 1, i, j, status, directions, visited);
                    visited[i][j] = false;

                    // check
                    if (status[0]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void dfs(char[][] board, String word, int index, int i, int j, boolean[] status, int[][] directions, boolean[][] visited) {
        // base case
        if (word.length() == index) {
            status[0] = true;
            return;
        }

        // recursive case
        for (int[] dir : directions) {
            int row = i + dir[0];
            int col = j + dir[1];

            // check
            if (!status[0] && row >= 0 && row < board.length && col >= 0 && col < board[0].length && word.charAt(index) == board[row][col] && !visited[row][col]) {
                visited[row][col] = true;
                dfs(board, word, index + 1, row, col, status, directions, visited);
                visited[row][col] = false;
            }
        }
    }

    public static void main(String[] args) {
        WordSearch test = new WordSearch();
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'},
                                      {'S', 'F', 'C', 'S'},
                                      {'A', 'D', 'E', 'E'}};
        System.out.println(test.isWord(board, ""));
    }
}
