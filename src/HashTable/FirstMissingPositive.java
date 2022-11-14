package HashTable;

/*
Given an unsorted integer array nums, return the smallest missing positive integer.

        You must implement an algorithm that runs in O(n) time and uses constant extra space.



        Example 1:

        Input: nums = [1,2,0]
        Output: 3
        Explanation: The numbers in the range [1,2] are all in the array.
        Example 2:

        Input: nums = [3,4,-1,1]
        Output: 2
        Explanation: 1 is in the array but 2 is missing.
        Example 3:

        Input: nums = [7,8,9,11,12]
        Output: 1
        Explanation: The smallest positive integer 1 is missing.
*/

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {
//    // approach 1 - Set TC: O(n) SC: O(n)
//    public int firstMissingPositive(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] > 0) {
//                set.add(nums[i]);
//            }
//        }
//
//        int count = 1;
//        while (true) {
//            if (!set.contains(count)) {
//                break;
//            }
//            count++;
//        }
//        return count;
//    }

    // approach 2 - Swap TC: O(n) SC: O(1)
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // switch until found
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        // check
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        FirstMissingPositive test = new FirstMissingPositive();
        int[] arr = new int[]{7, 8, 9, 11, 12};
        System.out.println(test.firstMissingPositive(arr));
    }
}
