package DFS;

/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

        A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    // approach 1 - DFS TC: O(3^m * 4^k) SC: O(n)
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        // edge case
        if (digits == null || digits.length() == 0) {
            return res;
        }

        List<List<Character>> mapping = new ArrayList<>();
        mapping.add(Arrays.asList('a', 'b', 'c'));
        mapping.add(Arrays.asList('d', 'e', 'f'));
        mapping.add(Arrays.asList('g', 'h', 'i'));
        mapping.add(Arrays.asList('j', 'k', 'l'));
        mapping.add(Arrays.asList('m', 'n', 'o'));
        mapping.add(Arrays.asList('p', 'q', 'r', 's'));
        mapping.add(Arrays.asList('t', 'u', 'v'));
        mapping.add(Arrays.asList('w', 'x', 'y', 'z'));

        dfs(digits, new StringBuilder(), 0, res, mapping);
        return res;
    }

    private void dfs(String digits, StringBuilder sb, int index, List<String> list, List<List<Character>> mapping) {
        // base case
        if (digits.length() == index) {
            list.add(sb.toString());
            return;
        }

        // recursive case
        int num = digits.charAt(index) - '2';
        for (Character ch : mapping.get(num)) {
            sb.append(ch);
            dfs(digits, sb, index + 1, list, mapping);
            sb.deleteCharAt(index);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber test = new LetterCombinationsOfAPhoneNumber();
        System.out.println(test.letterCombinations(""));
    }
}
