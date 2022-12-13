package Airbnb;

/*
On an 2 x 3 board, there are five tiles labeled from 1 to 5, and an empty square represented by 0. A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.

        The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].

        Given the puzzle board board, return the least number of moves required so that the state of the board is solved. If it is impossible for the state of the board to be solved, return -1.
*/

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class SlidingPuzzle {
    public class Node {
        String board;
        int x;
        int y;

        public Node(int x, int y, String board) {
            this.x = x;
            this.y = y;
            this.board = board;
        }
    }

    // approach 1 - BFS TC: O((mn)!mn) SC: O((mn)!mn)
    public int slidingPuzzle(int[][] board) {
        String dst = "123450";
        String start = "";
        int x = 0;
        int y = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                start += board[i][j];

                // get zero index
                if (board[i][j] == 0) {
                    x = i;
                    y = j;
                }
            }
        }

        // BFS
        Deque<Node> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        queue.offer(new Node(x, y, start));
        visited.add(start);

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();

                // check dst
                if (node.board.equals(dst)) {
                    return step;
                }

                // expand
                for (int[] dir : directions) {
                    int row = node.x + dir[0];
                    int col = node.y + dir[1];

                    // check
                    if (row >= 0 && row < board.length && col >= 0 && col < board[0].length) {
                        // generate next board
                        String nextBoard = swap(node.board, node.x, node.y, row, col, board[0].length);

                        if (!visited.contains(nextBoard)) {
                            queue.offer(new Node(row, col, nextBoard));
                            visited.add(nextBoard);
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private String swap(String board, int x1, int y1, int x2, int y2, int rows) {
        char[] arr = board.toCharArray();
        char temp = arr[x1 * rows + y1];
        arr[x1 * rows + y1] = arr[x2 * rows + y2];
        arr[x2 * rows + y2] = temp;
        return new String(arr);
    }

    public static void main(String[] args) {
        SlidingPuzzle test = new SlidingPuzzle();
        int[][] board = new int[][]{{1, 2, 3}, {4, 0, 5}};
        System.out.println(test.slidingPuzzle(board));
    }
}
