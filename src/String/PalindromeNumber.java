package String;

/*
Given an integer x, return true if x is palindrome integer.

        An integer is a palindrome when it reads the same backward as forward.

        For example, 121 is a palindrome while 123 is not.
*/

public class PalindromeNumber {
    // approach 1 - String TC: O(1) SC: O(1)
    public boolean isPalindrome(int x) {
        String num = String.valueOf(x);
        int left = 0;
        int right = num.length() - 1;
        while (left < right) {
            if (num.charAt(left) != num.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // approach 2 - Reverse TC: O(log_10(n)) SC: O(1)
    public boolean isPalindrome2(int x) {
        // edge case
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        // reverse half
        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }

        // cases for correctness
        // case 1: original == reversed (same # of digits)
        // case 2: original == reversed / 10 (extra digit for reversed)
        return x == reversed || x == reversed / 10;
    }

    public static void main(String[] args) {
        PalindromeNumber test = new PalindromeNumber();
        System.out.println(test.isPalindrome2(0));
    }
}
