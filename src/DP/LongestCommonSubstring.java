package DP;

/*
Find the longest common substring of two given strings.

        Assumptions

        The two given strings are not null
        Examples

        S = “abcde”, T = “cdf”, the longest common substring of S and T is “cd”
*/

public class LongestCommonSubstring {
    public String longestCommon(String source, String target) {
        int m = source.length();
        int n = target.length();
        int[][] matrix = new int[m][n];
        int max = 0;
        int index = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (source.charAt(i) == target.charAt(j)) {
                    if (i == 0 || j == 0) {
                        matrix[i][j] = 1;
                    } else {
                        matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    }
                }

                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                    index = i;
                }
            }
        }
        return max == 0 ? "" : source.substring(index - max + 1, index + 1);
    }

    public static void main(String[] args) {
        LongestCommonSubstring test = new LongestCommonSubstring();
        System.out.println(test.longestCommon("", ""));
    }
}
