package String;

/*
LeetCode 125
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

        Given a string s, return true if it is a palindrome, or false otherwise.
*/

public class ValidPalindrome {
//    // time complexity: O(n)
//    // space complexity: O(1)
//    public boolean isPalindrome(String s) {
//        s = s.toLowerCase();
//        int left = 0;
//        int right = s.length() - 1;
//        while (left < right) {
//            // left
//            while (left < s.length() && !Character.isAlphabetic(s.charAt(left)) && !Character.isDigit(s.charAt(left))) {
//                left++;
//            }
//
//            // right
//            while (left < right && !Character.isAlphabetic(s.charAt(right)) && !Character.isDigit(s.charAt(right))) {
//                right--;
//            }
//
//            if (left >= right) {
//                break;
//            }
//
//            if (s.charAt(left++) != s.charAt(right--)) {
//                return false;
//            }
//        }
//        return true;
//    }

    // approach 1: Two Pointers TC: O(n) SC: O(1)
    public boolean isPalindrome(String s) {
        // initialization
        int left = 0;
        int right = s.length() - 1;
        s = s.toLowerCase();

        // two pointers scan
        while (left < right) {
            // prune non-alphanumeric characters
            while (left < right && !Character.isAlphabetic(s.charAt(left)) && !Character.isDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isAlphabetic(s.charAt(right)) && !Character.isDigit(s.charAt(right))) {
                right--;
            }

            // check
            // case 1: match
            // case 2: not match -> false
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            // update
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome test = new ValidPalindrome();
        System.out.println(test.isPalindrome("211"));
    }
}
