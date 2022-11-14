package BFS;

/*
You are given a m x n 2D grid initialized with these three possible values.

        -1 - A wall or an obstacle. 0 - A gate. INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647. Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

        For example, given the 2D grid:

        INF  -1  0  INF
        INF INF INF  -1
        INF  -1 INF  -1
        0  -1 INF INF
        After running your function, the 2D grid should be:

        3  -1   0   1
        2   2   1  -1
        1  -1   2  -1
        0  -1   3   4
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class WallsAndGates {
    // approach 1 - BFS TC: O(mn) SC: O(mn)
    public void wallsAndGates(int[][] rooms) {
        // BFS

        // initialization
        int rows = rooms.length;
        int cols = rooms[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // explore
        while (!queue.isEmpty()) {
            int[] entry = queue.poll();
            int i = entry[0];
            int j = entry[1];

            for (int[] dir : directions) {
                int row = i + dir[0];
                int col = j + dir[1];

                // check
                if (row >= 0 && row < rows && col >= 0 && col < cols && rooms[row][col] == Integer.MAX_VALUE) {
                    rooms[row][col] = rooms[i][j] + 1;
                    queue.offer(new int[]{row, col});
                }
            }
        }
    }

    public static void main(String[] args) {
        WallsAndGates test = new WallsAndGates();
        int max = Integer.MAX_VALUE;
        int[][] rooms = new int[][]{{max, -1, 0, max},
                                    {max, max, max, -1},
                                    {max, -1, max, -1},
                                    {0, -1, max, max}};
        test.wallsAndGates(rooms);
    }
}
