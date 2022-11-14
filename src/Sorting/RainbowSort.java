package Sorting;

/*
Medium
        Given an array of balls, where the color of the balls can only be Red, Green or Blue, sort the balls such that all the Red balls are grouped on the left side, all the Green balls are grouped in the middle and all the Blue balls are grouped on the right side. (Red is denoted by -1, Green is denoted by 0, and Blue is denoted by 1).

        Examples

        {0} is sorted to {0}
        {1, 0} is sorted to {0, 1}
        {1, 0, 1, -1, 0} is sorted to {-1, 0, 0, 1, 1}
        Assumptions

        The input array is not null.
        Corner Cases

        What if the input array is of length zero? In this case, we should not do anything as well.
*/

import java.util.Arrays;

public class RainbowSort {
    public int[] rainbowSort(int[] array) {
        // Write your solution here
        int red = 0, green = 0, blue = array.length - 1;
        int i = 0;
        while (i <= blue) {
            if (array[i] == -1) {
                green++;
                swap(array, i++, red++);
            } else if (array[i] == 0) {
                i++;
                green++;
            } else {
                swap(array, i, blue--);
            }
        }
        return array;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // approach 1 - Pointers TC: O(n) SC: O(1)
    public void sortColors(int[] nums) {
        int pointer0 = 0;
        int pointer1 = 0;
        int pointer2 = nums.length - 1;
        while (pointer1 <= pointer2) {
            // case 1: 0
            // case 2: 1
            // case 3: 2
            if (nums[pointer1] == 0) {
                swap(nums, pointer0, pointer1);
                pointer0++;
                pointer1++;
            } else if (nums[pointer1] == 1) {
                pointer1++;
            } else {
                swap(nums, pointer1, pointer2);
                pointer2--;
            }
        }
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{1, 0, 1, -1, 0};
        int[] arr = new int[]{2, 0, 1};
        RainbowSort test = new RainbowSort();
//        System.out.println(Arrays.toString(test.rainbowSort(arr)));
        test.sortColors(arr);
    }
}
