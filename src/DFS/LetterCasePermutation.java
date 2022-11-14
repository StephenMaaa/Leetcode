package DFS;

/*
Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.

        Return a list of all possible strings we could create. Return the output in any order.
*/

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    // approach 1 - DFS TC: O(2^n) SC: O(n)
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        dfs(s, new StringBuilder(), 0, res);
        return res;
    }

    private void dfs(String s, StringBuilder sb, int index, List<String> res) {
        // base case
        if (index == s.length()) {
            res.add(sb.toString());
            return;
        }

        // recursive case
        char var = s.charAt(index);
        // case 1: number
        // case 2: letter
        if (var >= '0' && var <= '9') {
            sb.append(var);
            dfs(s, sb, index + 1, res);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            // case 1: lowercase
            // case 2: uppercase
            sb.append(Character.toLowerCase(var));
            dfs(s, sb, index + 1, res);
            sb.deleteCharAt(sb.length() - 1);

            sb.append(Character.toUpperCase(var));
            dfs(s, sb, index + 1, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCasePermutation test = new LetterCasePermutation();
        System.out.println(test.letterCasePermutation("a1b2"));
    }
}
