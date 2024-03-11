package Array;

/*
Given an integer array A and a sliding window of size K, find the maximum value of each window as it slides from left to right.

        Assumptions

        The given array is not null and is not empty

        K >= 1, K <= A.length

        Examples

        A = {1, 2, 3, 2, 4, 2, 1}, K = 3, the windows are {{1,2,3}, {2,3,2}, {3,2,4}, {2,4,2}, {4,2,1}},

        and the maximum values of each K-sized sliding window are [3, 3, 4, 4, 4]
*/

import java.util.*;

public class MaxValuesOfSizeKSlidingWindows {
    public class Cell implements Comparable<Cell> {
        int index;
        int val;
        public Cell(int index, int val) {
            this.index = index;
            this.val = val;
        }

        @Override
        public int compareTo(Cell o) {
            return this.val - o.val;
        }
    }

    // approach 1 - PriorityQueue TC: O(nlogn) SC: O(n)
    public List<Integer> maxWindows(int[] array, int k) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Cell> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < array.length; i++) {
            maxHeap.offer(new Cell(i, array[i]));

            if (i >= k - 1) {
                // get the max in the sliding window
                while (maxHeap.peek().index <= i - k) {
                    maxHeap.poll();
                }
                Cell max = maxHeap.peek();
                res.add(max.val);
            }
        }
        return res;
    }

    // approach 2 - Deque TC: O(n) SC: O(k)
    public List<Integer> maxWindows2(int[] array, int k) {
        List<Integer> res = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < array.length; i++) {
            // maintain a descending deque in the k-size sliding window
            while (!deque.isEmpty() && array[deque.peekLast()] <= array[i]) {
                deque.pollLast();
            }

            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            deque.offerLast(i);

            if (i >= k - 1) {
                res.add(array[deque.peekFirst()]);
            }
        }
        return res;
    }

//    // approach 1 - Sliding Window + Monotonic Stack TC: O(n) SC: O(k)
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        int[] res = new int[nums.length - k + 1];
//
//        // monotonic descending stack
//        Deque<Integer> stack = new ArrayDeque<>();
//        for (int i = 0; i < nums.length; i++) {
//            // clear indexes outside sliding window of size k
//            while (!stack.isEmpty() && stack.peekFirst() <= i - k) {
//                stack.pollFirst();
//            }
//
//            // maintain a montonic descending stack
//            while (!stack.isEmpty() && nums[stack.peekLast()] <= nums[i]) {
//                stack.pollLast();
//            }
//
//            stack.offerLast(i);
//
//            // update
//            if (i >= k - 1) {
//                res[i - k + 1] = nums[stack.peekFirst()];
//            }
//        }
//        return res;
//    }

    // approach 1: Deque (Monotonic Stack) TC: O(n) SC: O(k)
    public int[] maxSlidingWindow(int[] nums, int k) {
        // initialization
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];

        // sliding window
        for (int i = 0; i < nums.length; i++) {
            // remove index outside of sliding window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // maintain a monotonic decreasing stack
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            // add
            deque.offerLast(i);

            // update
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaxValuesOfSizeKSlidingWindows test = new MaxValuesOfSizeKSlidingWindows();
        int[] arr = new int[]{1, 2, 3, 2, 4, 2, 1};
        System.out.println(test.maxWindows2(arr, 3));
    }
}
