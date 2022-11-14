package BFS;

/*
Given two sorted arrays A and B, of sizes m and n respectively. Define s = a + b, where a is one element from A and b is one element from B. Find the Kth smallest s out of all possible s'.

        Assumptions

        A is not null and A is not of zero length, so as B
        K > 0 and K <= m * n
        Examples

        A = {1, 3, 5}, B = {4, 8}

        1st smallest s is 1 + 4 = 5
        2nd smallest s is 3 + 4 = 7
        3rd, 4th smallest s are 9 (1 + 8, 4 + 5)
        5th smallest s is 3 + 8 = 11
*/

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestSumInTwoSortedArrays {
    public class Cell implements Comparable<Cell> {
        int x;
        int y;
        int val;
        public Cell(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Cell o) {
            return this.val - o.val;
        }
    }
    public int kthSum(int[] A, int[] B, int k) {
        PriorityQueue<Cell> minHeap = new PriorityQueue<>();
        boolean[][] visited = new boolean[A.length][B.length];
        minHeap.offer(new Cell(0, 0, A[0] + B[0]));
        visited[0][0] = true;

        int i = 0;
        while (i < k - 1) {
            Cell c = minHeap.poll();
            if (c.y + 1 < B.length && !visited[c.x][c.y + 1]) {
                minHeap.offer(new Cell(c.x, c.y + 1, A[c.x] + B[c.y + 1]));
                visited[c.x][c.y + 1] = true;
            }
            if (c.x + 1 < A.length && !visited[c.x + 1][c.y]) {
                minHeap.offer(new Cell(c.x + 1, c.y, A[c.x + 1] + B[c.y]));
                visited[c.x + 1][c.y] = true;
            }
            i++;
        }
        return minHeap.peek().val;
    }

    public static void main(String[] args) {
        KthSmallestSumInTwoSortedArrays test = new KthSmallestSumInTwoSortedArrays();
        int[] arr1 = new int[]{1, 3, 5, 8, 9};
        int[] arr2 = new int[]{2, 3, 4, 7};
        System.out.println(test.kthSum(arr1, arr2, 20));
    }
}
