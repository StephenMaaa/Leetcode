package Array;

/*
Given a circular integer array,  find the next greater element of each element in it. If no such an element then give it -1.

        The circular array is represented by a general array, and you should assume that the next element of the last element is the first element.

        Return the results as an integer array and the order of the elements should be consistent with the given array.

        Example:

        Input: nums = [4,2,1,3]

        Output: [-1, 3, 3, 4]

        Explanation: the given circular array is [4,2,1,3,4,2,1,3......]. 4 is the largest element so the next greater element does not exist, then we give it -1. The next greater element of 2, and 1 is 3. The next greater element of 3 is 4.
*/

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterNumberII {
    // time complexity: O(n)
    // space complexity: O(n)
    public int[] nextGreaterElement(int[] nums) {
        int[] res = new int[nums.length];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = nums.length * 2 - 1; i >= 0; i--) {
            // maintain a monotonic ascending stack from top to bottom
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i % nums.length]) {
                deque.pollLast();
            }

            // only update the res after the first cycle
            if (i < nums.length) {
                res[i] = deque.isEmpty() ? -1 : nums[deque.peekLast()];
            }
            deque.offerLast(i % nums.length);
        }
        return res;
    }

    // approach 1 - Stack TC: O(n) SC: O(n)
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length * 2; i++) {
            // maintain a monotonically descending stack
            while (!stack.isEmpty() && nums[stack.peekFirst()] < nums[i % nums.length]) {
                res[stack.pollFirst()] = nums[i % nums.length];
            }

            // only update the first cycle
            if (i < nums.length) {
                stack.offerFirst(i);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        NextGreaterNumberII test = new NextGreaterNumberII();
        int[] arr = new int[]{4, 2, 1, 3};
        System.out.println(Arrays.toString(test.nextGreaterElement(arr)));
    }
}
