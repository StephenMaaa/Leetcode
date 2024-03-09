package Array;

/*
LeetCode 167

Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

        Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

        The tests are generated such that there is exactly one solution. You may not use the same element twice.

        Your solution must use only constant extra space.
*/

import java.util.Arrays;

public class TwoSumII {
    // approach 1: Two Pointers TC: O(n) SC: O(1)
    public int[] twoSum(int[] numbers, int target) {
        // initialization
        int left = 0;
        int right = numbers.length - 1;

        // search
        while (left < right) {
            int sum = numbers[left] + numbers[right];

            // check
            // case 1: sum == target -> match
            // case 2: sum < target
            // case 3: sum > target
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return null; 
    }

    public static void main(String[] args) {
        TwoSumII test = new TwoSumII();
        int[] arr = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(test.twoSum(arr, 9)));
    }
}
