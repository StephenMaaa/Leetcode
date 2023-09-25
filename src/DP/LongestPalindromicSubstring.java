package DP;

/*
Given a string S, find the longest palindromic substring in S.

        Assumptions
        There exists one unique longest palindromic substring.
        The input S is not null.
        Examples
        Input:     "abbc"
        Output:  "bb"

        Input:     "abcbcbd"
        Output:  "bcbcb"
*/

public class LongestPalindromicSubstring {
    // time complexity: O(n^2)
    // space complexity: O(n^2)
    public String longestPalindrome4(String input) {
        // edge case
        if (input == null || input.length() == 0) {
            return input;
        }

        // initialization
        int length = input.length();
        boolean[][] check = new boolean[length][length];
        int max = 1;
        for (int i = 0; i < length; i++) {
            // single char
            check[i][i] = true;
        }
        int maxStart = 0;
        int maxEnd = 0;

        for (int interval = 1; interval < length; interval++) {
            for (int i = 0; i < length - interval; i++) {
                int j = i + interval;

                // update check
                if (input.charAt(i) == input.charAt(j)) {
                    if (interval == 1) {
                        check[i][j] = true;
                    } else {
                        check[i][j] = check[i + 1][j - 1];
                    }

                    // update max
                    if (check[i][j] && max < j - i + 1) {
                        max = j - i + 1;
                        maxStart = i;
                        maxEnd = j;
                    }
                }
            }
        }
        return input.substring(maxStart, maxEnd + 1);
    }

    // approach 1 - DP TC: O(n^2) SC: O(n^2)
    public String longestPalindrome2(String s) {
        // edge case
        if (s == null || s.length() == 0) {
            return s;
        }

        boolean[][] checkPalindrome = new boolean[s.length()][s.length()];
        int maxStart = 0;
        int maxEnd = -1;

        for (int interval = 0; interval < s.length(); interval++) {
            for (int i = 0; i < s.length() - interval; i++) {
                int j = i + interval;

                // initialization
                if (interval == 0) {
                    checkPalindrome[i][j] = true;
                    maxStart = i;
                    maxEnd = j;
                    continue;
                }

                // check palindrome
                if (s.charAt(i) == s.charAt(j)) {
                    if (interval == 1) {
                        checkPalindrome[i][j] = true;
                        maxStart = i;
                        maxEnd = j;
                    } else {
                        if (checkPalindrome[i + 1][j - 1]) {
                            checkPalindrome[i][j] = true;
                            maxStart = i;
                            maxEnd = j;
                        }
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }

    // approach 2 - Center Expansion TC: O(n^2) SC: O(1)
    public String longestPalindrome3(String s) {
        // edge case
        if (s == null || s.length() == 0) {
            return s;
        }

        int max = 0;
        int maxStart = 0;
        int maxEnd = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            len1 = Math.max(len1, len2);

            // update max
            if (len1 > max) {
                max = len1;
                maxStart = i - (len1 - 1) / 2;
                maxEnd = i + len1 / 2;
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }

    private int expand(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return end - start -1;
    }

    // approach 1: DP TC: O(n^2) SC: O(n^2)
    public String longestPalindrome(String s) {
        // initialization
        boolean[][] dp = new boolean[s.length()][s.length()];
        int max = 0;
        int maxStart = -1;
        int maxEnd = -1;

        for (int interval = 0; interval < s.length(); interval++) {
            for (int i = 0; i < s.length() - interval; i++) {
                int j = i + interval;

                // check
                if (s.charAt(i) == s.charAt(j)) {
                    // base case: len <= 2
                    // general case: len > 2
                    if (interval <= 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }

                    // update
                    if (dp[i][j] && max < interval + 1) {
                        max = interval + 1;
                        maxStart = i;
                        maxEnd = j;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring test = new LongestPalindromicSubstring();
        System.out.println(test.longestPalindrome("aacabdkacaa"));
    }
}
