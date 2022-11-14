package Array;

/*
Given a sorted integer array, remove duplicate elements. For each group of elements with the same value keep only one of them. Do this in-place, using the left side of the original array and maintain the relative order of the elements of the array. Return the array after deduplication.

        Assumptions

        The array is not null
        Examples

        {1, 2, 2, 3, 3, 3} → {1, 2, 3}
*/

import java.util.Arrays;

public class ArrayDedup {
    // time complexity: O(n)
    // space complexity: O(1)
    public int[] dedup(int[] array) {
        int valid = 0;
        for (int i = 0; i < array.length; i++) {
            // case 1: arr[i] first appearance
            if (i == 0 || array[valid - 1] != array[i]) {
                array[valid++] = array[i];
            }
            // case 2: duplicate
        }
//        int[] ans = new int[valid];
//        for (int i = 0; i < valid; i++) {
//            ans[i] = array[i];
//        }
//        return ans;
        return Arrays.copyOf(array, valid);
    }

    // time complexity: O(n)
    // space complexity: O(1)
    public int removeDuplicates(int[] nums) {
        int valid = 0;
        for (int i = 0; i < nums.length; i++) {
            // case 1: no dup
            // case 2: dup
            if (valid == 0 || nums[valid - 1] != nums[i]) {
                nums[valid++] = nums[i];
            }
        }
        return valid;
    }

    public static void main(String[] args) {
        ArrayDedup test = new ArrayDedup();
        int[] arr = new int[]{1, 2, 2, 3, 3, 3};
        System.out.println(Arrays.toString(test.dedup(arr)));
    }
}
