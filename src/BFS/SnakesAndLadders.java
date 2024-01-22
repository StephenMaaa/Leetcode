package BFS;

/*
LeetCode 909

You are given an n x n integer matrix board where the cells are labeled from 1 to n2 in a Boustrophedon style starting from the bottom left of the board (i.e. board[n - 1][0]) and alternating direction each row.

        You start on square 1 of the board. In each move, starting from square curr, do the following:

        Choose a destination square next with a label in the range [curr + 1, min(curr + 6, n2)].
        This choice simulates the result of a standard 6-sided die roll: i.e., there are always at most 6 destinations, regardless of the size of the board.
        If next has a snake or ladder, you must move to the destination of that snake or ladder. Otherwise, you move to next.
        The game ends when you reach the square n2.
        A board square on row r and column c has a snake or ladder if board[r][c] != -1. The destination of that snake or ladder is board[r][c]. Squares 1 and n2 do not have a snake or ladder.

        Note that you only take a snake or ladder at most once per move. If the destination to a snake or ladder is the start of another snake or ladder, you do not follow the subsequent snake or ladder.

        For example, suppose the board is [[-1,4],[-1,3]], and on the first move, your destination square is 2. You follow the ladder to square 3, but do not follow the subsequent ladder to 4.
        Return the least number of moves required to reach the square n2. If it is not possible to reach the square, return -1.
*/

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class SnakesAndLadders {
    // approach 1: BFS TC: O(mn) SC: O(mn)
    public int snakesAndLadders(int[][] board) {
        // initialization
        int n = board.length * board.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        visited[0] = true;

        // BFS
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int index = queue.poll();

                // check
                if (index == n - 1) {
                    return count;
                }

                // expand
                for (int j = index + 1; j < Math.min(index + 7, n); j++) {
                    // check
                    int next = j;
                    int[] nextEntry = getIndex(next, board.length);

                    // teleport
                    if (board[nextEntry[0]][nextEntry[1]] != -1) {
                        next = board[nextEntry[0]][nextEntry[1]] - 1;
                    }

                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }

            // increment
            count++;
        }
        return -1;
    }

    private int[] getIndex(int i, int n) {
        int row = n - i / n - 1;
        int col;
        if ((n - row - 1) % 2 == 0) {
            col = i % n;
        } else {
            col = n - i % n - 1;
        }
        return new int[]{row, col};
    }

    public static void main(String[] args) {
        SnakesAndLadders test = new SnakesAndLadders();
        int[][] board = new int[][]{{-1, 4},
                                    {-1,3}};
        System.out.println(test.snakesAndLadders(board));
    }
}
