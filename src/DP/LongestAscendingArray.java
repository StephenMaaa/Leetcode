package DP;

/*
Given an unsorted array, find the length of the longest subarray in which the numbers are in ascending order.

        Assumptions

        The given array is not null
        Examples

        {7, 2, 3, 1, 5, 8, 9, 6}, longest ascending subarray is {1, 5, 8, 9}, length is 4.

        {1, 2, 3, 3, 4, 4, 5}, longest ascending subarray is {1, 2, 3}, length is 3.
*/

import java.util.Arrays;

public class LongestAscendingArray {
    public int longest(int[] array) {
        int curr = 0;
        int max = 0;

        for (int i = 0; i < array.length; i++) {
            if (i == 0 || array[i - 1] < array[i]) {
                curr++;
            } else {
                curr = 1;
            }

            max = Math.max(max, curr);
        }
        return max;
    }

    public int[] longestWithIndex(int[] array) {
        int curr = 0;
        int max = 0;

        // track the range of the longest ascending array
        int start = 0;
        int end = 0;
        int maxStart = 0;
        int maxEnd = 0;

        for (int i = 0; i < array.length; i++) {
            if (i == 0 || array[i - 1] < array[i]) {
                curr++;
            } else {
                curr = 1;
                start = i;
            }

            if (max < curr) {
                maxStart = start;
                maxEnd = i;
            }
            max = Math.max(max, curr);
        }
        return new int[]{maxStart, maxEnd};
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 2, 6, 3, 4, 7, 5};
        LongestAscendingArray test = new LongestAscendingArray();
        System.out.println(test.longest(arr));
    }
}
