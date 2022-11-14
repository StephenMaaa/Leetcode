package DP;

/*
Given an array A[0]...A[n-1] of integers, count the number of ascending subsequences.

        In case that the result is larger than 32-bit integer, return the result in 10^9+7 modulo.

        Assumptions

        A is not null
        Examples
        Input: A = {1,2,3}
        Output: 7
        Explanation: [1],[2],[3],[1,2],[1,3],[2,3],[1,2,3]
*/

import java.util.Arrays;

public class CountAscendingSubsequences {
    public int numIncreasingSubsequences(int[] a) {
        int total = 0;
        int[] countArr = new int[a.length];
        Arrays.fill(countArr, 1);

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    countArr[i] += countArr[j];
                }
            }
            total += countArr[i];
        }
        return total;
    }

    public static void main(String[] args) {
        CountAscendingSubsequences test = new CountAscendingSubsequences();
        int[] arr = new int[]{2, 1};
        System.out.println(test.numIncreasingSubsequences(arr));
    }
}
