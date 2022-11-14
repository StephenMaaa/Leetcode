package DP;

/*
Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.

        In one step, you can delete exactly one character in either string.



        Example 1:

        Input: word1 = "sea", word2 = "eat"
        Output: 2
        Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
        Example 2:

        Input: word1 = "leetcode", word2 = "etco"
        Output: 4
*/

public class DeleteOperationForTwoStrings {
    // approach 1 - 2D DP TC: O(mn) SC: O(mn)
    public int minDistance(String word1, String word2) {
        int[][] minCounts = new int[word1.length() + 1][word2.length() + 1];

        // initialization
        for (int i = 0; i < word1.length(); i++) {
            minCounts[i + 1][0] = i + 1;
        }

        for (int j = 0; j < word2.length(); j++) {
            minCounts[0][j + 1] = j + 1;

        }

        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                // case 1: strA[i] == strB[j]
                // case 2: otherwise
                if (word1.charAt(i) == word2.charAt(j)) {
                    minCounts[i + 1][j + 1] = minCounts[i][j];
                } else {
                    minCounts[i + 1][j + 1] = Math.min(minCounts[i + 1][j], minCounts[i][j + 1]) + 1;
                }
            }
        }
        return minCounts[word1.length()][word2.length()];
    }

    // approach 2 - 2D DP TC: O(mn) SC: O(mn)
    // longest common subsequence
    public int minDistance2(String word1, String word2) {
        int[][] maxCounts = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                // case 1: arr[i] == arr[j]
                // case 2: otherwise
                if (word1.charAt(i) == word2.charAt(j)) {
                    maxCounts[i + 1][j + 1] = maxCounts[i][j] + 1;
                } else {
                    maxCounts[i + 1][j + 1] = Math.max(maxCounts[i + 1][j], maxCounts[i][j + 1]);
                }
            }
        }
        return word1.length() + word2.length() - 2 * maxCounts[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        DeleteOperationForTwoStrings test = new DeleteOperationForTwoStrings();
        System.out.println(test.minDistance2("a", "bc"));
    }
}
