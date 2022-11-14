package DP;

/*
Given a string s, return the longest palindrome subsequence.

        Example: s = "abca"

        Output: 3

        Explanation: The longest palindrome subsequences could be "aba" or "aca".
*/

import java.util.Arrays;

public class LongestPalindromeSubsequence {
    // time complexity: O(n^2)
    // space complexity: O(n^2)
    public int longestPalindrome(String input) {
        // edge case
        if (input == null || input.length() == 0) {
            return 0;
        }

        int length = input.length();
        int[][] maxCounts = new int[length][length];

        for (int interval = 0; interval < length; interval++) {
            for (int i = 0; i < length - interval; i++) {
                // initialization
                if (interval == 0) {
                    maxCounts[i][i] = 1;
                    continue;
                }

                int j = i + interval;

                // case 1: arr[i] == arr[j]
                // case 2: otherwise
                if (input.charAt(i) == input.charAt(j)) {
                    maxCounts[i][j] = interval == 1 ? 2 : maxCounts[i + 1][j - 1] + 2;
                } else {
                    maxCounts[i][j] = Math.max(maxCounts[i + 1][j], maxCounts[i][j - 1]);
                }
            }
        }
        return maxCounts[0][length - 1];
    }

    // approach 1 - DP TC: O(n^2) SC: O(n^2)
    public int longestPalindromeSubseq(String s) {
        // edge case
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[][] checkPalindrome = new int[s.length()][s.length()];

        for (int interval = 0; interval < s.length(); interval++) {
            for (int i = 0; i < s.length() - interval; i++) {
                int j = i + interval;

                // initialization
                if (interval == 0) {
                    checkPalindrome[i][j] = 1;
                    continue;
                }

                // check palindrome
                if (s.charAt(i) == s.charAt(j)) {
                    checkPalindrome[i][j] = interval == 1 ? 2 : checkPalindrome[i + 1][j - 1] + 2;
                } else {
                    checkPalindrome[i][j] = Math.max(checkPalindrome[i + 1][j], checkPalindrome[i][j - 1]);
                }
            }
        }
        return checkPalindrome[0][s.length() - 1];
    }

    public static void main(String[] args) {
        LongestPalindromeSubsequence test = new LongestPalindromeSubsequence();
        System.out.println(test.longestPalindromeSubseq("bbbab"));
    }
}
