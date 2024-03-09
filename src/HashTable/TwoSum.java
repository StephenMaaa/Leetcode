package HashTable;

/*
LeetCode 1

Determine if there exist two elements in a given array, the sum of which is the given target number.

        Assumptions

        The given array is not null and has length of at least 2
        ​Examples

        A = {1, 2, 3, 4}, target = 5, return true (1 + 4 = 5)

        A = {2, 4, 2, 1}, target = 4, return true (2 + 2 = 4)

        A = {2, 4, 1}, target = 4, return false
*/

import java.util.*;

public class TwoSum {
//    public boolean existSum(int[] array, int target) {
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < array.length; i++) {
//            if (set.contains(array[i])) {
//                return true;
//            }
//            set.add(target - array[i]);
//        }
//        return false;
//    }

    // approach 1: Map TC: O(n) SC: O(n)
    public int[] twoSum(int[] nums, int target) {
        // initialization
        Map<Integer, Integer> map = new HashMap<>();

        // search
        for (int i = 0; i < nums.length; i++) {
            // check
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }

            // update
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum test = new TwoSum();
        int[] arr = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(test.twoSum(arr, 6)));
    }
}
