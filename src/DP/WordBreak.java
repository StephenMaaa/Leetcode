package DP;

/*
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

        Note that the same word in the dictionary may be reused multiple times in the segmentation.
*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    // approach 1: DP TC: O(n^2) SC: O(n)
    public boolean wordBreak(String s, List<String> wordDict) {
        // initialization
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        // update rule: dp[i] == true if dp[i - j] && s[j : i] == word
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                // check
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        WordBreak test = new WordBreak();
        List<String> list = Arrays.asList("leet", "code");
        System.out.println(test.wordBreak("leetcode", list));
    }
}
