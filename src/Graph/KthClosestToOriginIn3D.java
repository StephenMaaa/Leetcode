package Graph;

/*
Given three arrays sorted in ascending order. Pull one number from each array to form a coordinate <x,y,z> in a 3D space. Find the coordinates of the points that is k-th closest to <0,0,0>.

        We are using euclidean distance here.

        Assumptions

        The three given arrays are not null or empty, containing only non-negative numbers
        K >= 1 and K <= a.length * b.length * c.length
        Return

        a size 3 integer list, the first element should be from the first array, the second element should be from the second array and the third should be from the third array
        Examples

        A = {1, 3, 5}, B = {2, 4}, C = {3, 6}

        The closest is <1, 2, 3>, distance is sqrt(1 + 4 + 9)

        The 2nd closest is <3, 2, 3>, distance is sqrt(9 + 4 + 9)
*/

import java.util.*;

public class KthClosestToOriginIn3D {
    public class State implements Comparable<State> {
        int x;
        int y;
        int z;
        double dis;
        public State(int x, int y, int z, int[] a, int[] b, int[] c) {
            this.x = x;
            this.y = y;
            this.z = z;
            dis = Math.sqrt(a[x] * a[x] + b[y] * b[y] + c[z] * c[z]);
        }

        @Override
        public int compareTo(State o) {
            return this.dis > o.dis ? 1 : -1;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }

            if (!(o instanceof State)) {
                return false;
            }

            State s = (State) o;
            return (this.x == s.x && this.y == s.y && this.z == s.z);
        }

        @Override
        public int hashCode() {
            return this.x * 31 * 31 + this.y * 31 + this.z;
        }
    }

    public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
        PriorityQueue<State> minHeap = new PriorityQueue<>();
        Set<State> visited = new HashSet<>();
        minHeap.add(new State(0, 0, 0, a, b, c));
        visited.add(new State(0, 0, 0, a, b, c));

        while (k > 1) {
            State s = minHeap.poll();

            if (s.x + 1 < a.length) {
                State n = new State(s.x + 1, s.y, s.z, a, b, c);
                if (!visited.contains(n)) {
                    visited.add(n);
                    minHeap.add(n);
                }
            }

            if (s.y + 1 < b.length) {
                State n = new State(s.x, s.y + 1, s.z, a, b, c);
                if (!visited.contains(n)) {
                    visited.add(n);
                    minHeap.add(n);
                }
            }

            if (s.z + 1 < c.length) {
                State n = new State(s.x, s.y, s.z + 1, a, b, c);
                if (!visited.contains(n)) {
                    visited.add(n);
                    minHeap.add(n);
                }
            }
            k--;
        }
        State res = minHeap.peek();
        return Arrays.asList(a[res.x], b[res.y], c[res.z]);
    }

    public static void main(String[] args) {
        KthClosestToOriginIn3D test = new KthClosestToOriginIn3D();
        int[] a = new int[]{1, 2, 3};
        int[] b = new int[]{2, 4};
        int[] c = new int[]{1, 2};
        System.out.println(test.closest(a, b, c, 10));
    }
}
