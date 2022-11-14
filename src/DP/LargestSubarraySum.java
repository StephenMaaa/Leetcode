package DP;

/*
Given an unsorted integer array, find the subarray that has the greatest sum. Return the sum.

        Assumptions

        The given array is not null and has length of at least 1.
        Examples

        {2, -1, 4, -2, 1}, the largest subarray sum is 2 + (-1) + 4 = 5

        {-2, -1, -3}, the largest subarray sum is -1
*/

import java.util.Arrays;

public class LargestSubarraySum {
    public int largestSum(int[] array) {
        int max = Integer.MIN_VALUE ;
        int count = 0;
        int globalMaxL = 0;
        int globalMaxR = 0;
        int currL = 0;
        int currR = 0;
        for (int i = 0; i < array.length; i++) {
            if (count > 0) {
                currR = i;
                count += array[i];
            } else {
                currL = i;
                count = array[i];
            }
            globalMaxL = max < count ? currL : globalMaxL;
            globalMaxR = max < count ? currR : globalMaxR;
            max = Math.max(max, count);
        }
        System.out.println(array[globalMaxL] + " " + array[globalMaxR]);
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, -1, 4, -2, 1};
        LargestSubarraySum test = new LargestSubarraySum();
        System.out.println(test.largestSum(arr));
    }
}
