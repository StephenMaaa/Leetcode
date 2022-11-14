package DP;

/*
Given an array with all integers,  a sub-sequence of it is called Bitonic if it is first sorted in an ascending order, then sorted in a descending order. How can you find the length of the longest bitonic subsequence.

        Assumptions:

        The given array is not null.
        Corner Cases:

        A subsequence, sorted in increasing order is considered Bitonic with the decreasing part as empty. Similarly, decreasing order sequence is considered Bitonic with the increasing part as empty.
        Examples:

        {1, 3, 2, 1, 4, 6, 1}, the longest bitonic sub sequence is {1, 3, 4, 6, 1}, length is 5.
*/

import java.util.Arrays;

public class LongestBitonicSequence {
    // time complexity: O(n^2)
    // space complexity: O(n)
    public int longestBitonic(int[] array) {
        // edge case
        if (array == null || array.length == 0) {
            return 0;
        }

        int[] ascendingMax = new int[array.length];
        int[] descendingMax = new int[array.length];
        Arrays.fill(ascendingMax, 1);
        Arrays.fill(descendingMax, 1);
        int check = 0;

        // update ascending max
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]) {
                    ascendingMax[i] = Math.max(ascendingMax[i], ascendingMax[j] + 1);
                }
            }
            check = Math.max(check, ascendingMax[i]);
        }

        // update descending max
        for (int i = array.length - 2; i >= 0; i--) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[i]) {
                    descendingMax[i] = Math.max(descendingMax[i], descendingMax[j] + 1);
                }
            }
            check = Math.max(check, descendingMax[i]);
        }

        // edge case
        if (check == 1) {
            return check;
        }

        // find max
        int max = Math.max(ascendingMax[array.length - 1], descendingMax[0]);

        for (int i = 0; i < array.length - 1; i++) {
            max = Math.max(max, ascendingMax[i] + descendingMax[i + 1]);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestBitonicSequence test = new LongestBitonicSequence();
        int[] arr = new int[]{1, 1, 1, 1};
        System.out.println(test.longestBitonic(arr));
    }
}
