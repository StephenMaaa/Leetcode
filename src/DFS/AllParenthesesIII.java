package DFS;

/*
Get all valid permutations of l pairs of (), m pairs of <> and n pairs of {}, subject to the priority restriction: {} higher than <> higher than ().



        Assumptions

        l, m, n >= 0

        l + m + n >= 0



        Examples

        l = 1, m = 1, n = 0, all the valid permutations are ["()<>", "<()>", "<>()"].

        l = 2, m = 0, n = 1, all the valid permutations are [“()(){}”, “(){()}”, “(){}()”, “{()()}”, “{()}()”, “{}()()”].
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class AllParenthesesIII {
    public List<String> validParenthesesIII(int l, int m, int n) {
        List<String> ans = new ArrayList<>();
        int[] count = new int[]{l, l, m, m, n, n};
        char[] parenthesis = new char[]{'(', ')', '<', '>', '{', '}'};
        int total = 2 * (l + m + n);
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        dfs(count, parenthesis, total, sb, stack, ans);
        return ans;
    }

    private void dfs(int[] count, char[] parenthesis, int total, StringBuilder sb, Deque<Integer> stack, List<String> list) {
        // base case
        if (sb.length() == total) {
            list.add(sb.toString());
            return;
        }

        for (int i = 0; i < parenthesis.length; i++) {
            if (i % 2 == 0) {
                // add left parenthesis
                if (count[i] > 0 && (stack.isEmpty() || stack.peekFirst() > i)) {
                    sb.append(parenthesis[i]);
                    stack.offerFirst(i);
                    count[i]--;
                    dfs(count, parenthesis, total, sb, stack, list);
                    sb.deleteCharAt(sb.length() - 1);
                    stack.pollFirst();
                    count[i]++;
                }
            } else {
                // add right parenthesis
                if (!stack.isEmpty() && stack.peekFirst() == i - 1) {
                    sb.append(parenthesis[i]);
                    stack.pollFirst();
                    count[i]--;
                    dfs(count, parenthesis, total, sb, stack, list);
                    sb.deleteCharAt(sb.length() - 1);
                    stack.offerFirst(i - 1);
                    count[i]++;
                }
            }
        }
    }

    public static void main(String[] args) {
        AllParenthesesIII test = new AllParenthesesIII();
        System.out.println(test.validParenthesesIII(2, 0, 1));
    }
}
