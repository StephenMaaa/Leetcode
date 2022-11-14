package DFS;

/*
Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.

        Note that the same word in the dictionary may be reused multiple times in the segmentation.
*/

import java.util.*;

public class WordBreakII {
//    // approach 1 - Brute-Force DFS TC: O(n * n^n) SC: O(n * n^n)
//    public List<String> wordBreak(String s, List<String> wordDict) {
//        List<String> res = new ArrayList<>();
//        Set<String> set = new HashSet<>(wordDict);
//        dfs(s, new ArrayList<>(), 0, set, res);
//        return res;
//    }
//
//    private void dfs(String s, List<String> list, int index, Set<String> set, List<String> res) {
//        // base case
//        if (index == s.length()) {
//            res.add(String.join(" ", list));
//            return;
//        }
//
//        // recursive case
//        for (int i = 0; i < s.length() - index; i++) {
//            String str = s.substring(index, index + i + 1);
//            if (set.contains(str)) {
//                list.add(str);
//                dfs(s, list, index + i + 1, set, res);
//                list.remove(list.size() - 1);
//            }
//        }
//    }

    // approach 2 - DP + DFS TC: O(n * 2^n) SC: O(n * 2^n)
    public List<String> wordBreak2(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();

        // DP
        // preprocess
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        // DFS
        if (dp[s.length()]) {
            dfs(s, new ArrayDeque<>(), s.length(), dp, set, res);
        }
        return res;
    }

    private void dfs(String s, Deque<String> deque, int index, boolean[] dp, Set<String> set, List<String> res) {
        // base case
        if (index == 0) {
            res.add(String.join(" ", deque));
            return;
        }

        // recursive case
        for (int i = index - 1; i >= 0; i--) {
            String str = s.substring(i, index);
            if (dp[i] && set.contains(str)) {
                deque.offerFirst(str);
                dfs(s, deque, i, dp, set, res);
                deque.pollFirst();
            }
        }
    }

    public static void main(String[] args) {
        WordBreakII test = new WordBreakII();
        List<String> list = Arrays.asList("cat", "cats", "and", "sand", "dog");
        System.out.println(test.wordBreak2("catsanddog", list));
    }
}
