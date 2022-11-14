package Array;

/*
Given two integer arrays all and partial without duplicate numbers, array partial is subset of array all. For each number in partial, find the first number on its right in all that greater than it. If no such number existed, then assign the result to -1.

        Example 1:

        Input: all = [3,4,1,2]    partial = [4,1,2]

        Output: [-1, 2, -1]

        Example 2:

        Input: all = [1, 2, 3, 4] partial = [4,1,2]

        Output: [-1, 2, 3]
*/

import java.util.*;

public class NextGreaterNumber {
//    // time complexity: O(n)
//    // space complexity: O(n)
//    public int[] nextGreaterElement(int[] partial, int[] all) {
//        // initialization
//        Map<Integer, Integer> map = new HashMap<>();
//        Deque<Integer> deque = new ArrayDeque<>();
//        int[] indexingArr = new int[all.length];
//        for (int i = all.length - 1; i >= 0; i--) {
//            map.put(all[i], i);
//
//            // maintain a monotonic ascending stack from top to bottom
//            while (!deque.isEmpty() && all[deque.peekLast()] < all[i]) {
//                deque.pollLast();
//            }
//
//            indexingArr[i] = deque.isEmpty() ? -1 : all[deque.peekLast()];
//            deque.offerLast(i);
//        }
//
//        int[] res = new int[partial.length];
//        for (int i = 0; i < partial.length; i++) {
//            res[i] = indexingArr[map.get(partial[i])];
//        }
//        return res;
//    }

    // approach 1 - Stack + Map TC: O(n) SC: O(n)
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums2.length; i++) {
            // add to index map
            map.put(nums2[i], -1);

            // maintain a monotonically descending stack
            while (!stack.isEmpty() && nums2[stack.peekFirst()] < nums2[i]) {
                map.put(nums2[stack.pollFirst()], nums2[i]);
            }
            stack.offerFirst(i);
        }

        // populate
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }

    public static void main(String[] args) {
        NextGreaterNumber test = new NextGreaterNumber();
        int[] all = new int[]{3, 4, 1, 2};
        int[] partial = new int[]{4, 1, 2};
        System.out.println(Arrays.toString(test.nextGreaterElement(partial, all)));
    }
}
