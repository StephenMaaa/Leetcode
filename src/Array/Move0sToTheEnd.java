package Array;

/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

        Note that you must do this in-place without making a copy of the array.
*/

import java.util.Arrays;

public class Move0sToTheEnd {
    public int[] moveZero(int[] array) {
        // Write your solution here
        if (array == null || array.length == 0) {
            return array;
        }

        int i = -1;
        int pivot = array.length - 1;
        for (int j = 0; j < pivot; j++) {
            if (array[j] != 0) {
                i++;
                swap(array, j, i);
            }
        }
        i++;
        swap(array, i, pivot);
        return array;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // approach 1 - Partition TC: O(n) SC: O(1)
    public void moveZeroes(int[] nums) {
        int valid = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, valid++, i);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 0, 5, 6, 0};
        Move0sToTheEnd test = new Move0sToTheEnd();
//        System.out.println(Arrays.toString(test.moveZero(arr)));
        test.moveZeroes(arr);
    }
}
