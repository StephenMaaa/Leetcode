package String;

/*
In URL encoding, whenever we see an space " ", we need to replace it with "20%". Provide a method that performs this encoding for a given string.

        Examples

        "google/q?flo wer market" → "google/q?flo20%wer20%market"
        Corner Cases

        If the given string is null, we do not need to do anything.
*/

import java.util.Arrays;

public class EncodeSpace {
    // approach 1: StringBuilder
    public String encode(String input) {
        // edge case
        if (input == null) {
            return input;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                sb.append("20%");
            } else {
                sb.append(input.charAt(i));
            }
        }
        return sb.toString();
    }

    // approach 2: String (in-place)
    public String encode2(String input) {
        // edge case
        if (input == null) {
            return input;
        }

        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                count++;
            }
        }

        char[] arr = new char[input.length() + count * 2];
        int pointer = 0;
        String replaced = "20%";
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                for (int j = 0; j < replaced.length(); j++) {
                    arr[pointer++] = replaced.charAt(j);
                }
            } else {
                arr[pointer++] = input.charAt(i);
            }
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        EncodeSpace test = new EncodeSpace();
        System.out.println(test.encode2("google/q?flo wer market"));
    }
}
