package String;

/*
Given an encoded string, return it's decoded string.

        The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

        You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

        Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

        Examples:

        s = "3[a]2[bc]", return "aaabcbc".
        s = "3[a2[c]]", return "accaccacc".
        s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeString {
    // time complexity: O(n)
    // space complexity: O(n)
    public String decodeString(String input) {
        Deque<StringBuilder> varStack = new ArrayDeque<>();
        Deque<Integer> countStack = new ArrayDeque<>();
        StringBuilder res = new StringBuilder();
        int i = 0;

        while (i < input.length()) {
            // read count
            // read var -> [
            // append -> ]
            if (Character.isDigit(input.charAt(i))) {
                int count = 0;
                while (Character.isDigit(input.charAt(i))) {
                    count = count * 10 + Character.getNumericValue(input.charAt(i++));
                }
                countStack.offerFirst(count);
            }

            if (input.charAt(i) == '[') {
                int start = ++i;
                while (!Character.isDigit(input.charAt(i)) && input.charAt(i) != ']') {
                    i++;
                }
                varStack.offerFirst(new StringBuilder(input.substring(start, i)));
            } else if (input.charAt(i) >= 'a' && input.charAt(i) <= 'z') {
                int start = i;
                while (i < input.length() && !Character.isDigit(input.charAt(i)) && input.charAt(i) != ']') {
                    i++;
                }

                // append res
                if (!varStack.isEmpty()) {
                    StringBuilder appendedVar = varStack.pollFirst().append(new StringBuilder(input.substring(start, i)));
                    varStack.offerFirst(appendedVar);
                } else {
                    res.append(new StringBuilder(input.substring(start, i)));
                }
            }

            if (i < input.length() && input.charAt(i) == ']') {
                StringBuilder sb = new StringBuilder();
                int count = countStack.pollFirst();
                StringBuilder var = varStack.pollFirst();
                for (int j = 0; j < count; j++) {
                    sb.append(var);
                }

                // append res
                if (!varStack.isEmpty()) {
                    StringBuilder appendedVar = varStack.pollFirst().append(sb);
                    varStack.offerFirst(appendedVar);
                } else {
                    res.append(sb);
                }
                i++;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        DecodeString test = new DecodeString();
        System.out.println(test.decodeString("1[uv3[wx]4[yz]]3[abc]"));
    }
}
