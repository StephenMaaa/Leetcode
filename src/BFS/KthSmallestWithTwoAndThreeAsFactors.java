package BFS;

/*
Find the Kth smallest number s such that s = 2 ^ x * 3 ^ y, x >= 0 and y >= 0, x and y are all integers.

        Assumptions

        K >= 1
        Examples

        the smallest is 1
        the 2nd smallest is 2
        the 3rd smallest is 3
        the 5th smallest is 2 * 3 = 6
        the 6th smallest is 2 ^ 3 * 3 ^ 0 = 8
*/

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class KthSmallestWithTwoAndThreeAsFactors {
    public class Cell implements Comparable<Cell> {
        int x;
        int y;
        int product;
        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
            product = (int) (Math.pow(2, x) * Math.pow(3, y));
        }

        @Override
        public int compareTo(Cell o) {
            return this.product - o.product;
        }
    }

    public int kth(int k) {
        PriorityQueue<Cell> pq = new PriorityQueue<>();
        Set<Integer> visited = new HashSet<>();
        pq.offer(new Cell(0, 0));
        visited.add(1);

        int count = 1;
        while (count < k) {
            Cell c = pq.poll();

            // push to pq
            if (!visited.contains(c.product * 2)) {
                pq.offer(new Cell(c.x + 1, c.y));
                visited.add(c.product * 2);
            }

            if (!visited.contains(c.product * 3)) {
                pq.offer(new Cell(c.x, c.y + 1));
                visited.add(c.product * 3);
            }

            count++;
        }
        return pq.peek().product;
    }

    public static void main(String[] args) {
        KthSmallestWithTwoAndThreeAsFactors test = new KthSmallestWithTwoAndThreeAsFactors();
        System.out.println(test.kth(0));
    }
}
