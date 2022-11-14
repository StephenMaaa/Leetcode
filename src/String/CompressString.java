package String;

/*
Given a string, replace adjacent, repeated characters with the character followed by the number of repeated occurrences. If the character does not has any adjacent, repeated occurrences, it is not changed.

        Assumptions

        The string is not null

        The characters used in the original string are guaranteed to be ‘a’ - ‘z’

        Examples

        “abbcccdeee” → “ab2c3de3”
*/

import java.util.Arrays;

public class CompressString {
    public String compress(String input) {
        char[] arr = input.toCharArray();
        int pointer = 0;
        int i = 0;
        while (i < arr.length) {
            // case 1: duplicate
            // case 2: non-duplicate
            if (i == arr.length - 1 || arr[i] != arr[i + 1]) {
                arr[pointer++] = arr[i++];
            } else {
                int count = 1;
                while (i < arr.length - 1 && arr[i] == arr[i + 1]) {
                    i++;
                    count++;
                }
                arr[pointer++] = arr[i++];
                String num = String.valueOf(count);
                for (int j = 0; j < num.length(); j++) {
                    arr[pointer++] = num.charAt(j);
                }
            }
        }
        return new String(arr, 0, pointer);
    }

    // approach 1 - Pointer TC: O(n) SC: O(1)
    public int compress(char[] chars) {
        int pointer = 0;
        int i = 0;
        while (i < chars.length) {
            // count # of digits
            int count = i;
            while (i < chars.length - 1 && chars[i] == chars[i + 1]) {
                i++;
            }

            // case 1: single digit
            // case 2: dup digits
            if (count == i) {
                chars[pointer++] = chars[i];
            } else {
                chars[pointer++] = chars[i];
                String num = String.valueOf(i - count + 1);
                for (int j = 0; j < num.length(); j++) {
                    chars[pointer++] = num.charAt(j);
                }
            }
            i++;
        }
        return pointer;
    }

    public static void main(String[] args) {
        CompressString test = new CompressString();
        char[] arr = "aabbccc".toCharArray();
        System.out.println(test.compress(arr));
    }
}
