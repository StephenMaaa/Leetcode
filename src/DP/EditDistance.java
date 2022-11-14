package DP;

/*
Given two strings of alphanumeric characters, determine the minimum number of Replace, Delete, and Insert operations needed to transform one string into the other.

        Assumptions

        Both strings are not null
        Examples

        string one: “sigh”, string two : “asith”

        the edit distance between one and two is 2 (one insert “a” at front then replace “g” with “t”).
*/

public class EditDistance {
    public int editDistance(String one, String two) {
        // initialization
        int[][] arr = new int[one.length() + 1][two.length() + 1];

        // DP
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (i == 0) {
                    arr[i][j] = j;
                } else if (j == 0) {
                    arr[i][j] = i;
                } else if (one.charAt(i - 1) == two.charAt(j - 1)) {
                    arr[i][j] = arr[i - 1][j - 1];
                } else {
                    arr[i][j] = Math.min(arr[i - 1][j - 1], Math.min(arr[i - 1][j], arr[i][j - 1])) + 1;
                }
            }
        }
        return arr[one.length()][two.length()];
    }

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
                    // replace: M[i - 1][j - 1]
                    // delete: M[i - 1][j]
                    // insert: M[i][j - 1]
                    minCounts[i + 1][j + 1] = Math.min(minCounts[i][j], Math.min(minCounts[i + 1][j], minCounts[i][j + 1])) + 1;
                }
            }
        }
        return minCounts[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        EditDistance test = new EditDistance();
        System.out.println(test.minDistance("horse", "ros"));
    }
}
