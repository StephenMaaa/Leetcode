package Graph;

/*
Find the Kth smallest number s such that s = 3 ^ x * 5 ^ y * 7 ^ z, x > 0 and y > 0 and z > 0, x, y, z are all integers.

        Assumptions

        K >= 1
        Examples

        the smallest is 3 * 5 * 7 = 105
        the 2nd smallest is 3 ^ 2 * 5 * 7 = 315
        the 3rd smallest is 3 * 5 ^ 2 * 7 = 525
        the 5th smallest is 3 ^ 3 * 5 * 7 = 945
*/

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class KthSmallestWith357AsFactors {
    public class State implements Comparable<State> {
        int x;
        int y;
        int z;
        int s;
        public State(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
            s = (int)(Math.pow(3, x) * Math.pow(5, y) * Math.pow(7, z));
        }

        @Override
        public int compareTo(State o) {
            return this.s - o.s;
        }
    }

    // time complexity: O(klogn)
    // space complexity: O(k)
    public long kth(int k) {
        PriorityQueue<State> minHeap = new PriorityQueue<>();
        Set<Integer> visited = new HashSet<>();
        minHeap.add(new State(1, 1, 1));
        visited.add(3 * 5 * 7);

        while (k > 1) {
            State state = minHeap.poll();

            if (!visited.contains(state.s * 3)) {
                visited.add(state.s * 3);
                minHeap.add(new State(state.x + 1, state.y, state.z));
            }
            if (!visited.contains(state.s * 5)) {
                visited.add(state.s * 5);
                minHeap.add(new State(state.x, state.y + 1, state.z));
            }
            if (!visited.contains(state.s * 7)) {
                visited.add(state.s * 7);
                minHeap.add(new State(state.x, state.y, state.z + 1));
            }
            k--;
        }
        return minHeap.peek().s;
    }

    public static void main(String[] args) {
        KthSmallestWith357AsFactors test = new KthSmallestWith357AsFactors();
        System.out.println(test.kth(40));
    }
}
