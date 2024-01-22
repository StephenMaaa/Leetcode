package String;

/*
LeetCode 392

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
*/

public class IsSubsequence {
    // approach 1: Pointers TC: O(n) SC: O(1)
    public boolean isSubsequence(String s, String t) {
        // edge case
        if (s.length() == 0) {
            return true;
        }

        if (s.length() >= t.length()) {
            return false;
        }

        int pointer = 0;
        for (char c : t.toCharArray()) {
            // check
            if (s.charAt(pointer) == c) {
                pointer++;
            }

            // check match
            if (pointer == s.length()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IsSubsequence test = new IsSubsequence();
        System.out.println(test.isSubsequence("abc", "aegbgsc"));
    }
}
