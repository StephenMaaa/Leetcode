package Array;

/*
LeetCode 42

Given a non-negative integer array representing the heights of a list of adjacent bars. Suppose each bar has a width of 1. Find the largest amount of water that can be trapped in the histogram.

        Assumptions

        The given array is not null
        Examples

        { 2, 1, 3, 2, 4 }, the amount of water can be trapped is 1 + 1 = 2 (at index 1, 1 unit of water can be trapped and index 3, 1 unit of water can be trapped)
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxWaterTrapped {
//    // approach 1: stack
//    public int maxTrapped(int[] array) {
//        Deque<Integer> stack = new ArrayDeque<>();
//        int total = 0;
//        for (int i = 0; i < array.length; i++) {
//            while (!stack.isEmpty() && array[stack.peekFirst()] <= array[i]) {
//                int prev = array[stack.pollFirst()];
//                // left end
//                if (stack.isEmpty()) {
//                    break;
//                }
//                int dis = i - stack.peekFirst() - 1;
//                total += (Math.min(array[i], array[stack.peekFirst()]) - prev) * dis;
//            }
//            stack.offerFirst(i);
//        }
//        return total;
//    }
//
//    // approach 2: two pointers
//    public int maxTrapped2(int[] array) {
//        int left = 0;
//        int right = array.length - 1;
//        int leftMax = Integer.MIN_VALUE;
//        int rightMax = Integer.MIN_VALUE;
//        int total = 0;
//        while (left <= right) {
//            if (array[left] > array[right]) {
//                if (array[right] > rightMax) {
//                    rightMax = array[right];
//                } else {
//                    total += rightMax - array[right];
//                }
//                right--;
//            } else {
//                if (array[left] > leftMax) {
//                    leftMax = array[left];
//                } else {
//                    total += leftMax - array[left];
//                }
//                left++;
//            }
//        }
//        return total;
//    }

//    // approach 1 - Stack TC: O(n) SC: O(n)
//    public int trap(int[] height) {
//        Deque<Integer> stack = new ArrayDeque<>();
//        int res = 0;
//        for (int i = 0; i < height.length; i++) {
//            // check if water trapped
//            while (!stack.isEmpty() && height[stack.peekFirst()] <= height[i]) {
//                int rightHeight = height[stack.pollFirst()];
//
//                // check if bounded
//                if (stack.isEmpty()) {
//                    continue;
//                }
//
//                int dis = i - stack.peekFirst() - 1;
//                res += dis * (Math.min(height[i], height[stack.peekFirst()]) - rightHeight);
//            }
//            stack.offerFirst(i);
//        }
//        return res;
//    }

//    // approach 2 - Two Pointers TC: O(n) SC: O(1)
//    public int trap2(int[] height) {
//        int res = 0;
//        int left = 0;
//        int right = height.length - 1;
//        int leftBound = -1;
//        int rightBound = -1;
//        while (left < right) {
//            if (height[left] < height[right]) {
//                // check if bounded
//                if (leftBound < height[left]) {
//                    leftBound = height[left];
//                } else {
//                    res += leftBound - height[left];
//                }
//                left++;
//            } else {
//                // check if bounded
//                if (rightBound < height[right]) {
//                    rightBound = height[right];
//                } else {
//                    res += rightBound - height[right];
//                }
//                right--;
//            }
//        }
//        return res;
//    }
//
//    // approach 1: Stack TC: O(n) SC: O(n)
//    public int trap3(int[] height) {
//        Deque<Integer> stack = new ArrayDeque<>();
//        int res = 0;
//
//        // iterate heights
//        for (int i = 0; i < height.length; i++) {
//            // trap
//            while (!stack.isEmpty() && height[stack.peekFirst()] <= height[i]) {
//                // get right bound
//                int rightBound = height[stack.pollFirst()];
//
//                // get left bound
//                // edge case: leak to the left
//                if (stack.isEmpty()) {
//                    continue;
//                }
//
//                int dist = i - stack.peekFirst() - 1;
//                res += dist * (Math.min(height[stack.peekFirst()], height[i]) - rightBound);
//            }
//            stack.offerFirst(i);
//        }
//        return res;
//    }
//
//    // approach 2: Two Pointers TC: O(n) SC: O(1)
//    public int trap(int[] height) {
//        int left = 0;
//        int right = height.length - 1;
//        int leftBound = -1;
//        int rightBound = -1;
//        int res = 0;
//
//        // move two pointers
//        while (left < right) {
//            if (height[left] < height[right]) {
//                // check leftBound
//                if (leftBound < height[left]) {
//                    leftBound = height[left];
//                } else {
//                    res += leftBound - height[left];
//                }
//                left++;
//            } else {
//                // check rightBound
//                if (rightBound < height[right]) {
//                    rightBound = height[right];
//                } else {
//                    res += rightBound - height[right];
//                }
//                right--;
//            }
//        }
//        return res;
//    }

//    // approach 1: Monotonic Stack TC: O(n) SC: O(n)
//    public int trap(int[] height) {
//        // initialization
//        Deque<Integer> stack = new ArrayDeque<>();
//        int count = 0;
//
//        // linear scan
//        for (int i = 0; i < height.length; i++) {
//            // check possible containers
//            while (!stack.isEmpty() && height[stack.peekFirst()] <= height[i]) {
//                // get right bound
//                int rightBound = height[stack.pollFirst()];
//
//                // check edge case: no left bound
//                if (stack.isEmpty()) {
//                    continue;
//                }
//
//                int left = stack.peekFirst();
//
//                // calculate volume
//                count += (i - left - 1) * (Math.min(height[left], height[i]) - rightBound);
//            }
//            stack.offerFirst(i);
//        }
//        return count;
//    }

    // approach 2: Two Pointers TC: O(n) SC: O(1)
    public int trap(int[] height) {
        // initialization
        int left = 0;
        int right = height.length - 1;
        int leftBound = -1;
        int rightBound = -1;
        int count = 0;

        // two pointers scan
        while (left < right) {
            // check left height and right height
            // case 1: left < right -> move right
            // case 2: left >= right -> move left
            if (height[left] < height[right]) {
                // check leftBound
                // case 1: left < leftBound -> update volume
                // case 2: left >= leftBound -> update leftBound
                if (height[left] < leftBound) {
                    count += leftBound - height[left];
                } else {
                    leftBound = height[left];
                }
                left++;
            } else {
                // check rightBound
                // case 1: right < rightBound -> update volume
                // case 2: right >= rightBound -> update rightBound
                if (height[right] < rightBound) {
                    count += rightBound - height[right];
                } else {
                    rightBound = height[right];
                }
                right--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MaxWaterTrapped test = new MaxWaterTrapped();
        int[] arr = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(test.trap(arr));
    }
}
