package DFS;

/*
Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

        A palindrome string is a string that reads the same backward as forward.
*/

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    // approach 1 - 2D DP + DFS TC: O(2^n) SC: O(n^2)
    public List<List<String>> partition(String s) {
        // 2D DP
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int interval = 0; interval < s.length(); interval++) {
            for (int i = 0; i < s.length() - interval; i++) {
                int j = i + interval;

                // base case
                if (interval == 0) {
                    dp[i][j] = true;
                } else if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = interval == 1 ? true : dp[i + 1][j - 1];
                }
            }
        }

        // DFS
        List<List<String>> res = new ArrayList<>();
        dfs(s, dp, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(String s, boolean[][] dp, int index, List<String> list, List<List<String>> res) {
        // base case
        if (index == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }

        // recursive case
        for (int i = 0; i < s.length() - index; i++) {
            if (dp[index][index + i]) {
                list.add(s.substring(index, index + i + 1));
                dfs(s, dp, index + i + 1, list, res);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        PalindromePartitioning test = new PalindromePartitioning();
        System.out.println(test.partition("a"));
    }
}
