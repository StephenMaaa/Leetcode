package String;

/*
Given an original string input, and two strings S and T, from left to right replace all occurrences of S in input with T.

        Assumptions

        input, S and T are not null, S is not empty string
        Examples

        input = "appledogapple", S = "apple", T = "cat", input becomes "catdogcat"
        input = "laicode", S = "code", T = "offer", input becomes "laioffer"
*/

import java.util.ArrayList;
import java.util.List;

public class StringReplace {
    // approach 1: StringBuilder
    public String replace(String input, String source, String target) {
        // find pattern
        StringBuilder ans = new StringBuilder();
        int pointer = 0;
        while (pointer < input.length()) {
            int count = 0;
            while (count < source.length() && pointer + count < input.length() && source.charAt(count) == input.charAt(pointer + count)) {
                count++;
            }
            if (count == source.length()) {
                ans.append(target);
                pointer += count;
            } else {
                ans.append(input.charAt(pointer++));
            }
        }
        return ans.toString();
    }

    // approach 2: in-place
    public String replace2(String input, String source, String target) {
        // find pattern
        List<Integer> replacedIndex = new ArrayList<>();
        int pointer = 0;

        // count the occurrence
        while (pointer < input.length()) {
            int count = 0;
            while (count < source.length() && pointer + count < input.length() && source.charAt(count) == input.charAt(pointer + count)) {
                count++;
            }
            if (count == source.length()) {
                replacedIndex.add(pointer);
                pointer += count;
            } else {
                pointer++;
            }
        }

        // resize the arr
        char[] res = new char[input.length() + replacedIndex.size() * (target.length() - source.length())];

        // fill the new arr
        int index = 0;
        int pointerA = 0;
        pointer = 0;
        while (pointer < input.length()) {
            // case 1: meet the replaced target
            // case 2: otherwise
            if (index < replacedIndex.size() && pointer == replacedIndex.get(index)) {
                for (int i = 0; i < target.length(); i++) {
                    res[pointerA++] = target.charAt(i);
                }
                pointer += source.length();
                index++;
            } else {
                res[pointerA++] = input.charAt(pointer++);
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {
        StringReplace test = new StringReplace();
        System.out.println(test.replace2("laicode", "code", "offer"));
    }
}
