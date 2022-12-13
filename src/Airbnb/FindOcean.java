package Airbnb;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindOcean {
    // approach 1 - BFS TC: O(mn) SC: O(mn)
    public char[][] findOcean(char[][] board, int i, int j) {
        int rows = board.length;
        int cols = board[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
//        boolean[][] visited = new boolean[rows][cols];
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // edge case
        if (board[i][j] != 'W') {
            return board;
        }
        queue.offer(new int[]{i, j});
//        visited[i][j] = true;

        // BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] entry = queue.poll();
                int x = entry[0];
                int y = entry[1];

                // expand
                for (int[] dir : directions) {
                    int row = x + dir[0];
                    int col = y + dir[1];

                    // check
                    if (row >= 0 && row < rows && col >= 0 && col < cols && board[row][col] == 'W') {
                        queue.offer(new int[]{row, col});
//                        visited[row][col] = true;
                        board[row][col] = 'O';
                    }
                }
            }
        }
        return board;
    }

    public static void main(String[] args) {
        FindOcean test = new FindOcean();
        char[][] graph = {
                {'W','W','W','L','L','L','W'},
                {'W','W','L','L','L','W','W'},
                {'W','L','L','L','L','W','W'},
        };
        test.findOcean(graph, 0, 1);
        for (int i = 0; i < graph.length; i++) {
            System.out.println();
            for (int j = 0; j < graph[0].length; j++) {
                System.out.print(graph[i][j]);
                System.out.print(",");
            }
        }
    }
}
