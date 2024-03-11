package DFS;

/*
LeetCode 22

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
*/

import java.util.ArrayList;
import java.util.List;

public class AllParentheses {
//    public List<String> validParentheses(int n) {
//        List<String> ans = new ArrayList<>();
//        StringBuilder str = new StringBuilder();
//        int left = 0, right = 0;
//        dfs(n, left, right, str, ans);
//        return ans;
//    }
//
//    private void dfs(int n, int left, int right, StringBuilder str, List<String> list) {
//        if (left == n && right == n) {
//            list.add(str.toString());
//            return;
//        }
//
//        // add (
//        if (left < n) {
//            str.append("(");
//            dfs(n, left + 1, right, str, list);
//            str.deleteCharAt(str.length() - 1);
//        }
//
//        // add )
//        if (left > right) {
//            str.append(")");
//            dfs(n, left, right + 1, str, list);
//            str.deleteCharAt(str.length() - 1);
//        }
//    }

//    // approach 1 - DFS TC: O(2^n) SC: O(n)
//    public List<String> generateParenthesis(int n) {
//        List<String> res = new ArrayList<>();
//        dfs(new StringBuilder(), n, n, res);
//        return res;
//    }
//
//    private void dfs(StringBuilder sb, int left, int right, List<String> list) {
//        // base case
//        if (left == 0 && right == 0) {
//            list.add(sb.toString());
//            return;
//        }
//
//        // recursive case
//        // add left bracket
//        if (left > 0) {
//            sb.append('(');
//            dfs(sb, left - 1, right, list);
//            sb.deleteCharAt(sb.length() - 1);
//        }
//
//        // add right bracket
//        if (left < right) {
//            sb.append(')');
//            dfs(sb, left, right - 1, list);
//            sb.deleteCharAt(sb.length() - 1);
//        }
//    }

    // approach 1: DFS TC: O(2^n) SC: O(n)
    public List<String> generateParenthesis(int n) {
        // initialization
        List<String> res = new ArrayList<>();
        dfs(n, n, new StringBuilder(), res);
        return res;
    }

    private void dfs(int left, int right, StringBuilder sb, List<String> res) {
        // base case
        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }

        // recursive case
        // add left bracket
        if (left > 0) {
            sb.append('(');
            dfs(left - 1, right, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }

        // add right bracket
        if (left < right) {
            sb.append(')');
            dfs(left, right - 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        AllParentheses test = new AllParentheses();
        List<String> ans = test.generateParenthesis(4);
        System.out.println(ans);
    }
}
