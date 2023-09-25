package HashTable;

/*
LeetCode 217

Given an array of integers, find if the array contains any duplicates.
        Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
*/

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
//    public boolean containsDuplicate(int[] nums) {
//        // edge case
//        if (nums == null || nums.length == 0) {
//            return false;
//        }
//
//        // XOR arr
//        int res = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            res ^= nums[i];
//        }
//    }

//    // time complexity: O(n)
//    // space complexity: O(n)
//    public boolean containsDuplicate(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (set.contains(nums[i])) {
//                return true;
//            }
//            set.add(nums[i]);
//        }
//        return false;
//    }

    // approach 1: Set TC: O(n) SC: O(n)
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int val : nums) {
            // check
            if (set.contains(val)) {
                return true;
            }

            // update
            set.add(val);
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate test = new ContainsDuplicate();
        int[] arr = new int[]{};
        System.out.println(test.containsDuplicate(arr));
    }
}
