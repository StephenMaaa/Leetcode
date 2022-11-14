import java.util.*;

public class KPairsWithSmallestSums {
    public class Cell implements Comparable<Cell> {
        int a;
        int b;

        public Cell(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Cell other) {
            if (this.a + this.b == other.a + other.b) {
                return 0;
            }
            return this.a + this.b < other.a + other.b ? -1 : 1;
        }
    }

//    public class MyComparator implements Comparator<Cell> {
//        public int compare(Cell m, Cell n) {
//            if (m.a + m.b == n.a + n.b) {
//                return 0;
//            }
//            return m.a + m.b < n.a + n.b ? 1 : -1;
//        }
//    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Cell> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                Cell c = new Cell(nums1[i], nums2[j]);
                if (maxHeap.size() < k) {
                    maxHeap.offer(c);
                } else {
                    if (maxHeap.peek().compareTo(c) == 1) {
                        maxHeap.poll();
                        maxHeap.offer(c);
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            Cell c = maxHeap.poll();
            List<Integer> list = new ArrayList<>();
            list.add(c.a);
            list.add(c.b);
            ans.add(list);
        }
        return ans;
    }
}
