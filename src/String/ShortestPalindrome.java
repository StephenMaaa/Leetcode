package String;

/*
Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

        For example:

        Given "aacecaaa", return "aaacecaaa".

        Given "abcd", return "dcbabcd".
*/

public class ShortestPalindrome {
    public String shortestPalindrome(String input) {
        StringBuilder sb = new StringBuilder(input);
        int pointerA = 0;
        int pointerB = input.length() - 1;
        int matches = 0;
        while (pointerA <= pointerB) {
            // case 1: match
            // case 2: otherwise
            if (pointerA == pointerB) {
                pointerB--;
                matches++;
            } else if (sb.charAt(pointerA) == sb.charAt(pointerB)) {
                pointerA++;
                pointerB--;
                matches++;
            } else {
                pointerA = 0;
                pointerB += matches - 1;
                matches = 0;
            }
        }

        for (int i = pointerA + matches; i < input.length(); i++) {
            sb.insert(0, input.charAt(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ShortestPalindrome test = new ShortestPalindrome();
        System.out.println(test.shortestPalindrome("aacdbcb")); 
    }
}
