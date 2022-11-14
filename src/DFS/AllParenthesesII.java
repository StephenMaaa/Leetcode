package DFS;

/*
Get all valid permutations of l pairs of (), m pairs of <> and n pairs of {}.

        Assumptions

        l, m, n >= 0
        l + m + n > 0
        Examples

        l = 1, m = 1, n = 0, all the valid permutations are ["()<>", "(<>)", "<()>", "<>()"]
*/

import java.util.*;

public class AllParenthesesII {
    public List<String> validParentheses(int l, int m, int n) {
        List<String> ans = new ArrayList<>();
//        int[] count = new int[6];
        int length = 2 * (l + m + n);
        int[] count = new int[]{l, l, m, m, n, n};
        char[] parenthesis = new char[]{'(', ')', '<', '>', '{', '}'};
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        dfs(count, parenthesis, stack, length, sb, ans);
        return ans;
    }

    private void dfs(int[] count, char[] parenthesis, Deque<Character> stack, int length, StringBuilder sb, List<String> list) {
        // base case
        if (sb.length() == length) {
            list.add(sb.toString());
        }

        for (int i = 0; i < parenthesis.length; i++) {
            // left
            if (i % 2 == 0) {
                if (count[i] > 0) {
                    sb.append(parenthesis[i]);
                    stack.offerFirst(parenthesis[i]);
                    count[i]--;
                    dfs(count, parenthesis, stack, length, sb, list);
                    sb.deleteCharAt(sb.length() - 1);
                    stack.pollFirst();
                    count[i]++;
                }
            } else {
                if (!stack.isEmpty() && stack.peekFirst() == parenthesis[i - 1]) {
                    sb.append(parenthesis[i]);
                    stack.pollFirst();
                    count[i]--;
                    dfs(count, parenthesis, stack, length, sb, list);
                    sb.deleteCharAt(sb.length() - 1);
                    stack.offerFirst(parenthesis[i - 1]);
                    count[i]++;
                }
            }
        }
    }

    public static void main(String[] args) {
        AllParenthesesII test = new AllParenthesesII();
        List<String> ans = test.validParentheses(1, 1, 0);
        System.out.println(ans);
    }
}
