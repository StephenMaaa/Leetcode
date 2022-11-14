package Array;

/*
Merge K sorted array into one big sorted array in ascending order.

        Assumptions

        The input arrayOfArrays is not null, none of the arrays is null either.
*/

import java.util.PriorityQueue;

public class MergeKSortedArrays {
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

    public int[] merge(int[][] arrayOfArrays) {
        PriorityQueue<Cell> minHeap = new PriorityQueue<>();
        int length = 0;

        // initialize
        for (int i = 0; i < arrayOfArrays.length; i++) {
            if (arrayOfArrays[i].length > 0) {
                length += arrayOfArrays[i].length;
                minHeap.offer(new Cell(i, 0, arrayOfArrays[i][0]));
            }
        }

        int[] ans = new int[length];
        int i = 0; 
        while (!minHeap.isEmpty()) {
            Cell c = minHeap.poll();
            ans[i++] = c.val;
            if (c.y + 1 < arrayOfArrays[c.x].length) {
                c.y++;
                c.val = arrayOfArrays[c.x][c.y];
                minHeap.offer(c);
            }
        }
        return ans;
    }
}
