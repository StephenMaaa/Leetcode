package DP;

/*
Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

        '.' Matches any single character.
        '*' Matches zero or more of the preceding element.
        The matching should cover the entire input string (not partial).



        Example 1:

        Input: s = "aa", p = "a"
        Output: false
        Explanation: "a" does not match the entire string "aa".
        Example 2:

        Input: s = "aa", p = "a*"
        Output: true
        Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
        Example 3:

        Input: s = "ab", p = ".*"
        Output: true
        Explanation: ".*" means "zero or more (*) of any character (.)".
*/

public class RegularExpressionMatching {
    // approach 1 - 2D DP TC: O(mn) SC: O(mn)
    public boolean isMatch(String s, String p) {
        // initialization
        boolean[][] check = new boolean[s.length() + 1][p.length() + 1];
        check[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                check[0][i + 1] = check[0][i - 1];
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                char charP = p.charAt(j);

                // case 1: *
                // case 2: .
                // case 3: otherwise
                if (charP == '*') {
                    char prev = p.charAt(j - 1);
                    if (prev == '.') {
                        prev = s.charAt(i);
                    }

                    if (s.charAt(i) == prev) {
                        check[i + 1][j + 1] = check[i + 1][j - 1] || check[i][j + 1];
                    } else {
                        check[i + 1][j + 1] = check[i + 1][j - 1];
                    }
                } else if (charP == '.') {
                    check[i + 1][j + 1] = check[i][j];
                } else {
                    check[i + 1][j + 1] = check[i][j] && (s.charAt(i) == charP);
                }
            }
        }
        return check[s.length()][p.length()];
    }

    public static void main(String[] args) {
        RegularExpressionMatching test = new RegularExpressionMatching();
        System.out.println(test.isMatch("aa", "a*"));
    }
}
