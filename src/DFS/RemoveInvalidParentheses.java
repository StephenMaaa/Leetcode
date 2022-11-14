package DFS;

/*
Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

        Note: The input string may contain letters other than the parentheses ( and ).

        Examples:

        "()())()" -> ["()()()", "(())()"]
        "(a)())()" -> ["(a)()()", "(a())()"]
        ")(" -> [""]
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses {
    // time complexity: O(2^n)
    // space complexity: O(n)
    public List<String> removeInvalidParentheses(String input) {
        List<String> res = new ArrayList<>();
        int[] min = new int[1];
        min[0] = Integer.MAX_VALUE;
        Set<String> dup = new HashSet<>();
        dfs(input, new StringBuilder(), 0, 0, 0, 0, min, dup, res);
        return res;
    }

    private void dfs(String input, StringBuilder sb, int left, int right, int index, int op, int[] min, Set<String> dup, List<String> res) {
        // base case
        if (index == input.length()) {
            if (left == right && op <= min[0] && !dup.contains(sb.toString())) {
                if (op < min[0]) {
                    min[0] = op;
                    res.clear();
                    dup.clear();
                }
                res.add(sb.toString());
                dup.add(sb.toString());
                return;
            } else {
                return;
            }
        }

        // recursive case
        if (op > min[0]) {
            return;
        }

        char var = input.charAt(index);
        // case 1: (
        // case 2: )
        // case 3: otherwise
        if (var == '(') {
            // keep
            if (left <= input.length() - left + right) {
                sb.append(var);
                dfs(input, sb, left + 1, right, index + 1, op, min, dup, res);
                sb.deleteCharAt(sb.length() - 1);
            }

            // remove
            dfs(input, sb, left, right, index + 1, op + 1, min, dup, res);
        } else if (var == ')') {
            // keep
            if (left > right) {
                sb.append(var);
                dfs(input, sb, left, right + 1, index + 1, op, min, dup, res);
                sb.deleteCharAt(sb.length() - 1);
            }

            // remove
            dfs(input, sb, left, right, index + 1, op + 1, min, dup, res);
        } else {
            sb.append(var);
            dfs(input, sb, left, right, index + 1, op, min, dup, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        RemoveInvalidParentheses test = new RemoveInvalidParentheses();
        System.out.println(test.removeInvalidParentheses(""));
    }
}
