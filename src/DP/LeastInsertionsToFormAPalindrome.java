package DP;

/*
Insert the least number of characters to a string in order to make the new string a palindrome. Return the least number of characters should be inserted.

        Assumptions:

        The given string is not null.
*/

public class LeastInsertionsToFormAPalindrome {
    // time complexity: O(n^2)
    // space complexity: O(n^2)
    public int leastInsertion(String input) {
        // edge case
        if (input == null || input.length() == 0) {
            return 0;
        }

        // find the longest palindromic subsequence
        int length = input.length();
        int[][] maxCounts = new int[length][length];

        for (int interval = 0; interval < length; interval++) {
            for (int i = 0; i < length - interval; i++) {
                int j = i + interval;

                // initialization
                if (interval == 0) {
                    maxCounts[i][j] = 1;
                    continue;
                }

                // case 1: arr[i] == arr[j]
                // case 2: otherwise
                if (input.charAt(i) == input.charAt(j)) {
                    maxCounts[i][j] = interval == 1 ? 2 : maxCounts[i + 1][j - 1] + 2;
                } else {
                    maxCounts[i][j] = Math.max(maxCounts[i + 1][j], maxCounts[i][j - 1]);
                }
            }
        }
        return length - maxCounts[0][length - 1];
    }

    public static void main(String[] args) {
        LeastInsertionsToFormAPalindrome test = new LeastInsertionsToFormAPalindrome();
        System.out.println(test.leastInsertion("a"));
    }
}
