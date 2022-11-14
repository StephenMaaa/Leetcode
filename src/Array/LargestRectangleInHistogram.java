package Array;

/*
Given a non-negative integer array representing the heights of a list of adjacent bars. Suppose each bar has a width of 1. Find the largest rectangular area that can be formed in the histogram.

        Assumptions

        The given array is not null or empty
        Examples

        { 2, 1, 3, 3, 4 }, the largest rectangle area is 3 * 3 = 9(starting from index 2 and ending at index 4)
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram {
    // time complexity: O(n)
    // space complexity: O(n)
    public int largest(int[] array) {
        // maintain an ascending stack
        Deque<Integer> stack = new ArrayDeque<>();
        int max = 0;

        for (int i = 0; i <= array.length; i++) {
            // right bound
            int rightHeight = i == array.length ? 0 : array[i];

            // calculate area
            while (!stack.isEmpty() && array[stack.peekFirst()] >= rightHeight) {
                int height = array[stack.pollFirst()];
                int leftBound = stack.isEmpty() ? -1 : stack.peekFirst();
                int area = height * (i - leftBound - 1);
                max = Math.max(max, area);
            }
            stack.offerFirst(i);
        }
        return max;
    }

    // approach 1 - Monotonic Stack TC: O(n) SC: O(n)
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int max = 0;

        for (int i = 0; i <= heights.length; i++) {
            int rightHeight = i == heights.length ? 0 : heights[i];

            // maintain a monotonic ascending stack
            while (!stack.isEmpty() && heights[stack.peekFirst()] > rightHeight) {
                int height = heights[stack.pollFirst()];
                int leftBound = stack.isEmpty() ? -1 : stack.peekFirst();

                // update max
                max = Math.max(max, height * (i - leftBound - 1));
            }
            stack.offerFirst(i);
        }
        return max;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram test = new LargestRectangleInHistogram();
        int[] arr = new int[]{1, 2, 1, 2};
        System.out.println(test.largestRectangleArea(arr)); 
    }
}
