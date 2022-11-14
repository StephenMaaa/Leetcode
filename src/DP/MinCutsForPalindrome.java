package DP;

/*
Given a string, a partitioning of the string is a palindrome partitioning if every substring of the partition is a palindrome. Determine the fewest cuts needed for a palindrome partitioning of a given string.

        Assumptions

        The given string is not null
        Examples

        “a | babbbab | bab | aba” is a palindrome partitioning of “ababbbabbababa”.

        The minimum number of cuts needed is 3.
*/

import java.util.Arrays;

public class MinCutsForPalindrome {
    public int minCuts(String input) {
        char[] arr = input.toCharArray();
        int[] minArr = new int[arr.length + 1];
        Arrays.fill(minArr, -1);
        minArr[0] = 0;

        for (int i = 1; i < arr.length + 1; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (minArr[j] != -1 && checkPalindrome(arr, i, j)) {
                    if (j == 0) {
                        min = 0;
                    } else {
                        min = Math.min(min, minArr[j] + 1);
                    }
                }
            }
            minArr[i] = min;
        }

        return minArr[arr.length];
    }

    private boolean checkPalindrome(char[] arr, int i, int j) {
        for (int a = 0; a < (i - j) / 2; a++) {
            if (arr[j + a] != arr[i - a - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MinCutsForPalindrome test = new MinCutsForPalindrome();
        System.out.println(test.minCuts(""));
    }
}
