package DP;

/*
Given an integer array, what is the minimum number of operations to convert it to an ascending array.

        One operation you can move one element of the array to another position.



        Examples:

        {1, 3, 2, 4}, the least moves needed is 1, move 2 to the middle of 1 and 3.
*/

import java.util.Arrays;

public class LeastMovesToAscendingArray {
    // time complexity: O(n^2)
    // space complexity: O(n)
    public int leastMoves(int[] array) {
        // find longest ascending subsequence
        int[] maxCounts = new int[array.length];
        Arrays.fill(maxCounts, 1);
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]) {
                    maxCounts[i] = Math.max(maxCounts[i], maxCounts[j] + 1);
                }
            }
            max = Math.max(max, maxCounts[i]);
        }

        // only 1 way to sort the rest
        return array.length - max;
    }

    public static void main(String[] args) {
        LeastMovesToAscendingArray test = new LeastMovesToAscendingArray();
        int[] arr = new int[]{1, 3, 2, 4};
        System.out.println(test.leastMoves(arr));
    }
}
