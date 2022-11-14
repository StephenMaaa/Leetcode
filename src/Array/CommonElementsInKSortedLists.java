package Array;

/*
Find all common elements in K sorted lists.



        Assumptions

        The input and its elements are not null, and support fast random access.

        There could be duplicate elements in each of the lists.



        Examples

        Input = {{1, 2, 2, 3}, {2, 2, 3, 5}, {2, 2, 4}}, the common elements are {2, 2}.
*/

import java.util.*;

public class CommonElementsInKSortedLists {
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

    // approach 1: minHeap
    public List<Integer> commonElementsInKSortedArrays(List<List<Integer>> input) {
        PriorityQueue<Cell> minHeap = new PriorityQueue<>();
        List<Integer> ans = new ArrayList<>();
        // initialize
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < input.size(); i++) {
            List<Integer> list = input.get(i);
            if (list != null && list.size() > 0) {
                max = Math.max(max, list.get(0));
                minHeap.offer(new Cell(i, 0, list.get(0)));
            }
        }

        Deque<Cell> temp = new ArrayDeque<>();
        while (minHeap.size() == input.size()) {
            // check the same element
            if (minHeap.peek().val == max) {
                ans.add(minHeap.peek().val);
                for (int i = 0; i < input.size(); i++) {
                    Cell c = minHeap.poll();
                    if (c.y + 1 < input.get(c.x).size()) {
                        c.y++;
                        c.val = input.get(c.x).get(c.y);
                        max = Math.max(max, c.val);
                        temp.offer(c);
                    }
                }

                while (!temp.isEmpty()) {
                    minHeap.offer(temp.poll());
                }
            } else {
                Cell c = minHeap.poll();
                if (c.y + 1 < input.get(c.x).size()) {
                    c.y++;
                    c.val = input.get(c.x).get(c.y);
                    max = Math.max(max, c.val);
                    minHeap.offer(c);
                }
            }
        }
        return ans;
    }

    // approach 2: iterative + set
    public List<Integer> commonElementsInKSortedArrays2(List<List<Integer>> input) {
        List<Integer> ans = input.get(0);
        for (int i = 1; i < input.size(); i++) {
            if (ans == null || input.get(i) == null) {
                return new ArrayList<>();
            }
            ans = findCommon(ans, input.get(i));
        }
        return ans;
    }

    private List<Integer> findCommon(List<Integer> a, List<Integer> b) {
        List<Integer> ans = new ArrayList<>();
        int pointerA = 0;
        int pointerB = 0;
        while (pointerA < a.size() && pointerB < b.size()) {
            if (a.get(pointerA) == b.get(pointerB)) {
                ans.add(a.get(pointerA));
                pointerA++;
                pointerB++;
            } else if (a.get(pointerA) < b.get(pointerB)) {
                pointerA++;
            } else {
                pointerB++;
            }
        }
        return ans;
    }
}
