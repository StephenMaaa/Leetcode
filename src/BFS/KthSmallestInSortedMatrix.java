package BFS;

/*
Given a matrix of size N x M. For each row the elements are sorted in ascending order, and for each column the elements are also sorted in ascending order. Find the Kth smallest number in it.

        Assumptions

        the matrix is not null, N > 0 and M > 0
        K > 0 and K <= N * M
        Examples

        { {1,  3,   5,  7},

        {2,  4,   8,   9},

        {3,  5, 11, 15},

        {6,  8, 13, 18} }

        the 5th smallest number is 4
        the 8th smallest number is 6
*/

import java.util.Comparator;
import java.util.PriorityQueue;

class Cell {
    int i;
    int j;
    int val;
    public Cell(int i, int j, int val) {
        this.i = i;
        this.j = j;
        this.val = val;
    }
}

public class KthSmallestInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
//                if (o1.val == o2.val) {
//                    return 0;
//                }
//                return o1.val < o2.val ? -1 : 1;
                return o1.val - o2.val;
            }
        });
        minHeap.offer(new Cell(0, 0, matrix[0][0]));
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int count = 0;
        while (!minHeap.isEmpty() && count < k) {
            Cell c = minHeap.poll();
            if (!visited[c.i][c.j]) {
                visited[c.i][c.j] = true;
                count++;
                if (count == k) {
                    return c.val;
                }
                if (c.i < matrix.length - 1) {
                    minHeap.offer(new Cell(c.i + 1, c.j, matrix[c.i + 1][c.j]));
                }
                if (c.j < matrix[0].length - 1) {
                    minHeap.offer(new Cell(c.i, c.j + 1, matrix[c.i][c.j + 1]));
                }
            }
        }
        return matrix[matrix.length - 1][matrix[0].length - 1];
    }

    public static void main(String[] args) {
        KthSmallestInSortedMatrix test = new KthSmallestInSortedMatrix();
        int[][] matrix = new int[][]{ {1,  3,   5,  7},

                {2,  4,   8,   9},

                {3,  5, 11, 15},

                {6,  8, 13, 18} };
        System.out.println(test.kthSmallest(matrix, 1));
    }
}
