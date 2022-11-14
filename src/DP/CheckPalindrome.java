package DP;

public class CheckPalindrome {
    public int palindrome(String s) {
        char[] input = s.toCharArray();
        // minArr
        // arr[i] represents the min # of cuts from index 0 to i, -1 represents not a palindrome
        int[] arr = new int[s.length() + 1];
        arr[0] = 0;
        for (int i = 1; i < s.length() + 1; i++) {
            arr[i] = -1;
            for (int j = 0; j < i; j++) {
                if (arr[j] != -1 && check(input, i, j)) {
                    if (arr[i] == -1) {
                        arr[i] = arr[j] + 1;
                    } else {
                        arr[i] = Math.min(arr[i], arr[j] + 1);
                    }
                }
            }
        }
        return arr[s.length()];
    }

    private boolean check(char[] input, int i, int j) {
        for (int a = 0; a < (i - j) / 2; a++) {
            if (input[j + a] != input[i - a - 1]) {
                return false;
            }
        }
        return true;
    }
}
