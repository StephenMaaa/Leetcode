package DP;

/*
Find the length of longest common subsequence of two given strings.

        Assumptions

        The two given strings are not null
        Examples

        S = “abcde”, T = “cbabdfe”, the longest common subsequence of s and t is {‘a’, ‘b’, ‘d’, ‘e’}, the length is 4.
*/

public class LongestCommonSubsequence {
    public int longest(String source, String target) {
        // pad 0 to save condition check
        int m = source.length();
        int n = target.length();
        int[][] matrix = new int[m + 1][n + 1];
        int max = 0;

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (source.charAt(i - 1) == target.charAt(j - 1)) {
                    matrix[i][j] = Math.max(matrix[i - 1][j - 1] + 1, Math.max(matrix[i - 1][j], matrix[i][j - 1]));
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                }

                max = Math.max(max, matrix[i][j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestCommonSubsequence test = new LongestCommonSubsequence();
        System.out.println(test.longest("", ""));
    }
}
