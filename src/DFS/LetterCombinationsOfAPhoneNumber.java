package DFS;

/*
LeetCode 17

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

        A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
*/

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
    // approach 1 - DFS TC: O(3^m * 4^k) SC: O(n)
    public List<String> letterCombinations2(String digits) {
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

        dfs2(digits, new StringBuilder(), 0, res, mapping);
        return res;
    }

    private void dfs2(String digits, StringBuilder sb, int index, List<String> list, List<List<Character>> mapping) {
        // base case
        if (digits.length() == index) {
            list.add(sb.toString());
            return;
        }

        // recursive case
        int num = digits.charAt(index) - '2';
        for (Character ch : mapping.get(num)) {
            sb.append(ch);
            dfs2(digits, sb, index + 1, list, mapping);
            sb.deleteCharAt(index);
        }
    }

    // approach 1: DFS TC: O(4^n) SC: O(n)
    public List<String> letterCombinations(String digits) {
        // initialization
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> res = new ArrayList<>();

        // edge case
        if (digits == null || digits.length() == 0) {
            return res;
        }

        dfs(digits, 0, new StringBuilder(), map, res);
        return res;
    }

    private void dfs(String digits, int index, StringBuilder sb, Map<Character, String> map, List<String> res) {
        // base case
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }

        // recursive case
        for (char c : map.get(digits.charAt(index)).toCharArray()) {
            sb.append(c);
            dfs(digits, index + 1, sb, map, res);
            sb.deleteCharAt(index);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber test = new LetterCombinationsOfAPhoneNumber();
        System.out.println(test.letterCombinations("22"));
    }
}
