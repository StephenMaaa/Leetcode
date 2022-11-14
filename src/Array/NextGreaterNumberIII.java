package Array;

/*
Given an integer n, find the smallest integer that is larger than n and consists the same digits as n. If there is no such result, or the result is larger than the max value of 32-bit integer, then return -1.

        Example 1:

        Input: 1

        Output: -1

        Example 2:

        Input: 12

        Output: 21
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class NextGreaterNumberIII {
//    // time complexity: O(n)
//    // space complexity: O(1)
//    public int nextGreaterElement(int n) {
//        Deque<Character> stack = new ArrayDeque<>();
//        char[] nums = Integer.toString(n).toCharArray();
//        for (int i = nums.length - 1; i >= 0; i--) {
//            // case 1: nums[i] >= stack.top
//            // case 2: otherwise
//            if (stack.isEmpty() || stack.peekLast() <= nums[i]) {
//                stack.offerLast(nums[i]);
//            } else {
//                int minLarger = Integer.MAX_VALUE;
//                int minIndex = i;
//                int count = 0;
//                while (!stack.isEmpty()) {
//                    char digit = stack.pollLast();
//                    // update smallest larger digit
//                    if (digit > nums[i] && digit <= minLarger) {
//                        minLarger = digit;
//                        minIndex = nums.length - count - 1;
//                    }
//                    nums[nums.length - count - 1] = digit;
//                    count++;
//                }
//
//                // swap the current digit with the smallest larger digit
//                swap(nums, i, minIndex);
//                break;
//            }
//        }
//        int res = Integer.valueOf(new String(nums));
//        return res == n ? -1 : res;
//    }

//    // approach 1 - Stack TC: O(1) SC: O(1)
//    public int nextGreaterElement(int n) {
//        // generate int array
//        char[] arr = String.valueOf(n).toCharArray();
//        Deque<Character> stack = new ArrayDeque<>();
//        for (int i = arr.length - 1; i >= 0; i--) {
//            // maintain a monotonically descending stack
//            if (stack.isEmpty() || stack.peekFirst() <= arr[i]) {
//                stack.offerFirst(arr[i]);
//            } else {
//                int minGreater = Integer.MAX_VALUE;
//                int minIndex = arr.length - 1;
//                int index = arr.length - 1;
//
//                // reorder the element
//                while (!stack.isEmpty()) {
//                    char val = stack.pollFirst();
//
//                    // update the min greater element
//                    if (val > arr[i] && val <= minGreater) {
//                        minGreater = val;
//                        minIndex = index;
//                    }
//                    arr[index--] = val;
//                }
//
//                // swap current element with the min greater element
//                swap(arr, i, minIndex);
//                break;
//            }
//        }
//        long res = Long.valueOf(new String(arr));
//        // check overflow and invalid case
//        return res > Integer.MAX_VALUE || (int) res == n ? -1 : (int) res;
//    }

    // approach 2 - Arrays TC: O(1) SC: O(1)
    public int nextGreaterElement(int n) {
        // generate int array
        char[] arr = String.valueOf(n).toCharArray();

        // find the first fall-down index
        int i;
        for (i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                break;
            }
        }

        // swap the index with the min greater element
        if (i < 0) {
            return -1;
        } else {
            int index = arr.length - 1;
            while (arr[i] >= arr[index]) {
                index--;
            }
            swap(arr, i, index);
        }

        // reverse the array after the fall-down index
        i++;
        int end = arr.length - 1;
        while (i < end) {
            swap(arr, i++, end--);
        }

        // check overflow
        long res = Long.valueOf(new String(arr));
        return res > Integer.MAX_VALUE ? -1 : (int) res;
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        NextGreaterNumberIII test = new NextGreaterNumberIII();
        System.out.println(test.nextGreaterElement(12222333));
    }
}
