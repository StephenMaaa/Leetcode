package Array;

/*
LeetCode 1768

You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.

        Return the merged string.
*/

public class MergeStringsAlternately {
    // approach 1: Arrays/Pointers TC: O(MAX(m, n)) SC: O(m + n)
    public String mergeAlternately(String word1, String word2) {
        int pointerA = 0;
        int pointerB = 0;
        char[] res = new char[word1.length() + word2.length()];
        int minLen = Math.min(word1.length(), word2.length());

        for (int i = 0; i < minLen; i++) {
            res[2 * i] = word1.charAt(i);
            res[2 * i + 1] = word2.charAt(i);
        }

        // add remaining
        if (word1.length() < word2.length()) {
            for (int i = minLen; i < word2.length(); i++) {
                res[i + minLen] = word2.charAt(i);
            }
        } else {
            for (int i = minLen; i < word1.length(); i++) {
                res[i + minLen] = word1.charAt(i);
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {
        MergeStringsAlternately test = new MergeStringsAlternately();
        System.out.println(test.mergeAlternately("abc", "pqrtest"));
    }
}
