package DP;

/*
Given three strings A, B and C. Determine if C can be created by merging A and B in a way that maintains the relative order of the characters in A and B.

        Assumptions

        none of A, B, C is null
        Examples

        C = "abcde", A = "acd", B = "be", return true
        C = "abcde", A = "adc", B = "be", return false
*/

public class InterleaveStrings {
    // time complexity: O(m * n)
    // space complexity: O(m * n)
    public boolean canMerge(String a, String b, String c) {
        // edge case
        if (a.length() + b.length() != c.length()) {
            return false;
        }

        int m = a.length();
        int n = b.length();
        boolean[][] check = new boolean[m + 1][n + 1];
        check[0][0] = true;

        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                // expand M[i + 1][j] and M[i][j + 1]
                if (i < m && check[i][j] && a.charAt(i) == c.charAt(i + j)) {
                    check[i + 1][j] = true;
                }

                if (j < n && check[i][j] && b.charAt(j) == c.charAt(i + j)) {
                    check[i][j + 1] = true;
                }
            }
        }
        return check[m][n];
    }

    public static void main(String[] args) {
        InterleaveStrings test = new InterleaveStrings();
        System.out.println(test.canMerge("", "", ""));
    }
}
