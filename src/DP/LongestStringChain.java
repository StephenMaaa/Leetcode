package DP;

/*
LeetCode 1048

You are given an array of words where each word consists of lowercase English letters.

        wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without changing the order of the other characters to make it equal to wordB.

        For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
        A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k == 1.

        Return the length of the longest possible word chain with words chosen from the given list of words.
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {
    // approach 1: DP + Map TC: O(nL^2) SC: O(n)
    public int longestStrChain(String[] words) {
        // sort
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        // initialization
        Map<String, Integer> map = new HashMap<>();
        int globalMax = 0;
        for (String word : words) {
            int max = 0;
            // remove char at each index
            for (int i = 0; i < word.length(); i++) {
                String str = word.substring(0, i) + word.substring(i + 1);

                // check
                max = Math.max(map.getOrDefault(str, 0) + 1, max);
            }

            // update
            map.put(word, max);
            globalMax = Math.max(max, globalMax);
        }
        return globalMax; 
    }

    public static void main(String[] args) {
        LongestStringChain test = new LongestStringChain();
        String[] arr = new String[]{"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"};
        System.out.println(test.longestStrChain(arr));
    }
}
