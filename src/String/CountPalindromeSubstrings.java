package String;

/*
Given a string, count how many substrings are palindrome. Two substrings are considered different if they are of difference indexes, even though they consist same content.

        Example 1:

        Input = "abc"

        Output = 3

        Explanation: "a", "b", "c

        Example 2:

        Input = "aaa"

        Output = 6

        Explanation: "a","a","a","aa","aa","aaa"

        Assumptions:

        The input string is not null.
*/

public class CountPalindromeSubstrings {
    // time complexity: O(n^2)
    // space complexity: O(n^2)
    public int countPalindromeSubs(String input) {
        int length = input.length();
        boolean[][] check = new boolean[length][length];
        int count = 0;

        for (int interval = 0; interval < length; interval++) {
            for (int i = 0; i < length - interval; i++) {
                int j = i + interval;

                // base case
                if (interval == 0) {
                    check[i][j] = true;
                    count++;
                    continue;
                }

                if (input.charAt(i) == input.charAt(j)) {
                    if (interval == 1 || check[i + 1][j - 1]) {
                        check[i][j] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountPalindromeSubstrings test = new CountPalindromeSubstrings();
        System.out.println(test.countPalindromeSubs(""));
    }
}
