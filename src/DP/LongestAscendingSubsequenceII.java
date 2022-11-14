package DP;

/*
Given an array A[0]...A[n-1] of integers, find out the longest ascending subsequence. If there are multiple results, then return any valid result.

        Assumptions

        A is not null
        Examples
        Input: A = {5, 2, 6, 3, 4, 7, 5}
        Output: [2,3,4,5]
        Because [2, 3, 4, 5] is one of the longest ascending subsequences.
*/

import java.util.Arrays;

public class LongestAscendingSubsequenceII {
    // time complexity: O(n^2)
    // space complexity: O(n)
    public int[] longest(int[] a) {
        int[] maxCounts = new int[a.length];
        Arrays.fill(maxCounts, 1);
        int max = 0;
        int index = -1;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    maxCounts[i] = Math.max(maxCounts[i], maxCounts[j] + 1);
                }
            }

            if (max < maxCounts[i]) {
                max = maxCounts[i];
                index = i;
            }
        }

        int[] res = new int[max];
        // track backward
        for (int i = index; i >= 0; i--) {
            if (maxCounts[i] == max) {
                res[max - 1] = a[i];
                max--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongestAscendingSubsequenceII test = new LongestAscendingSubsequenceII();
        int[] arr = new int[]{};
        System.out.println(Arrays.toString(test.longest(arr)));
    }
}
