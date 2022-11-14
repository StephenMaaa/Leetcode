package DP;

/*
Given a string with only character 'a' and 'b', replace some of the characters such that the string becomes in the forms of all the 'b's are on the right side of all the 'a's.

        Determine what is the minimum number of replacements needed.

        Assumptions:

        The given string is not null.
        Examples:

        "abaab", the minimum number of replacements needed is 1 (replace the first 'b' with 'a' so that the string becomes "aaaab").
*/

public class MinReplacement {
    // approach 1 - TC: O(n) SC: O(n)
    public int minReplacements(String input) {
        // edge case
        if (input == null || input.length() == 0) {
            return 0;
        }

        int[] minA = new int[input.length()];
        int[] minB = new int[input.length()];

        for (int i = 0; i < input.length(); i++) {
            // case 1: str[i] == A
            // case 2: str[i] == B
            if (input.charAt(i) == 'a') {
                if (i != 0) {
                    minA[i] = minA[i - 1];
                }
            } else {
                if (i == 0) {
                    minA[i] = 1;
                } else {
                    minA[i] = minA[i - 1] + 1;
                }
            }
        }

        for (int i = input.length() - 1; i >= 0; i--) {
            // case 1: str[i] == A
            // case 2: str[i] == B
            if (input.charAt(i) == 'b') {
                if (i != input.length() - 1) {
                    minB[i] = minB[i + 1];
                }
            } else {
                if (i == input.length() - 1) {
                    minB[i] = 1;
                } else {
                    minB[i] = minB[i + 1] + 1;
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < input.length() - 1; i++) {
            min = Math.min(min, minA[i] + minB[i + 1]);
        }
        return Math.min(min, Math.min(minA[input.length() - 1], minB[0]));
    }

    public static void main(String[] args) {
        MinReplacement test = new MinReplacement();
        System.out.println(test.minReplacements("abbab"));
    }
}
