package DP;

/*
Given two strings where first string is a normal string and second string may contain wild card characters. Write a function that returns true if the two strings match. The following are allowed wildcard characters in first string.
        * --> Matches with 0 or more instances of any character or set of characters.
        ? --> Matches with any one character.

        Assumptions:

        The two strings are both not null.
        Assume there is no more than one '*' adjacent to each other.
        Examples:

        input = "abc", pattern = "?*", return true.
*/

public class WildcardMatching {
    public boolean match(String input, String pattern) {
        int m = input.length();
        int n = pattern.length();
        // edge case
        if (m == 0 && n == 1) {
            return pattern.charAt(0) == '*';
        }

        boolean[][] check = new boolean[m + 1][n + 1];
        check[0][0] = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char inputChar = input.charAt(i);
                char patternChar = pattern.charAt(j);

                if (patternChar == '*') {
                    check[i + 1][j + 1] = check[i][j] || check[i + 1][j] || check[i][j + 1];
                } else if (patternChar == '?') {
                    check[i + 1][j + 1] = check[i][j];
                } else {
                    check[i + 1][j + 1] = (inputChar == patternChar) && check[i][j];
                }
//                // case 1: i < j
//                if (i < j) {
//                    if (patternChar == '*') {
//                        check[i + 1][j + 1] = check[i + 1][j];
//                    } else if (pattern.charAt(j - 1) == '*') {
//                        if (patternChar == '?') {
//                            check[i + 1][j + 1] = check[i + 1][j];
//                        } else {
//                            check[i + 1][j + 1] = (inputChar == patternChar) && check[i + 1][j];
//                        }
//                    } else {
//                        check[i + 1][j + 1] = (inputChar == patternChar) && check[i][j];
//                    }
//                }
//
//                // case 2: i > j
//                if (i > j) {
//                    if (patternChar == '*') {
//                        check[i + 1][j + 1] = check[i][j + 1];
//                    } else if (patternChar == '?') {
//                        check[i + 1][j + 1] = check[i][j];
//                    } else {
//                        check[i + 1][j + 1] = (inputChar == patternChar) && check[i][j];
//                    }
//                }
//
//                // case 3: i == j
//                if (i == j) {
//                    if (patternChar == '*') {
//                        check[i + 1][j + 1] = check[i][j] || check[i + 1][j] || check[i][j + 1];
//                    } else if (patternChar == '?') {
//                        check[i + 1][j + 1] = check[i][j];
//                    } else {
//                        check[i + 1][j + 1] = (inputChar == patternChar) && check[i][j];
//                    }
//                }
            }
        }
        return check[m][n];
    }

    // approach 1 - 2D DP TC: O(mn) SC: O(mn)
    public boolean isMatch(String s, String p) {
        boolean[][] check = new boolean[s.length() + 1][p.length() + 1];
        check[0][0] = true;

        // edge case
        if (s.length() == 0) {
            return checkFlag(p, p.length());
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                char charB = p.charAt(j);

                // case 1: charB == *
                // case 2: charB == ?
                // case 3: otherwise
                if (charB == '*') {
                    check[i + 1][j + 1] = check[i][j] || check[i + 1][j] || check[i][j + 1];
                } else if (charB == '?') {
                    check[i + 1][j + 1] = check[i][j];

                    // check
                    if (!check[i + 1][j + 1] && j > 0 && p.charAt(j - 1) == '*') {
                        check[i + 1][j + 1] = checkFlag(p, j);
                    }
                } else {
                    check[i + 1][j + 1] = check[i][j] && s.charAt(i) == charB;

                    // check
                    if (!check[i + 1][j + 1] && j > 0 && p.charAt(j - 1) == '*') {
                        check[i + 1][j + 1] = checkFlag(p, j) && s.charAt(i) == charB;
                    }
                }
            }
        }
        return check[s.length()][p.length()];
    }

    private boolean checkFlag(String str, int index) {
        for (int k = 0; k < index; k++) {
            if (str.charAt(k) != '*') {
                return false;
            }
        }
        return true;
    }

    // approach 2 - 2D DP TC: O(mn) SC: O(mn)
    public boolean isMatch2(String s, String p) {
        boolean[][] check = new boolean[s.length() + 1][p.length() + 1];
        check[0][0] = true;

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                check[0][i + 1] = true;
            } else {
                break;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                char charB = p.charAt(j);

                // case 1: charB == *
                // case 2: charB == ?
                // case 3: otherwise
                if (charB == '*') {
                    check[i + 1][j + 1] = check[i][j] || check[i + 1][j] || check[i][j + 1];
                } else if (charB == '?') {
                    check[i + 1][j + 1] = check[i][j];
                } else {
                    check[i + 1][j + 1] = check[i][j] && s.charAt(i) == charB;
                }
            }
        }
        return check[s.length()][p.length()];
    }

    public static void main(String[] args) {
        WildcardMatching test = new WildcardMatching();
        System.out.println(test.isMatch2("", "**?**"));
//        System.out.println(test.isMatch2("", "*"));
    }
}
