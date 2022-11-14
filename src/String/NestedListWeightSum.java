package String;

/*
Given a nested list of integers represented by a string without blank, parse the string and  return the sum of all integers in the list weighted by their depth.

        Each element is either an integer, or a list -- whose elements may also be integers or other lists.

        Example 1:
        Given the list "[[1,1],2,[1,1]]", return 10. (four 1's at depth 2, one 2 at depth 1)

        Example 2:
        Given the list "[1,[4,[6]]]", return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27)
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class NestedListWeightSum {
    // time complexity: O(n)
    // space complexity: O(n)
    public int depthSum(String nestlists) {
        Deque<int[]> stack = new ArrayDeque<>();
        int res = 0;
        int level = 0;
        int i = 0;

        while (i < nestlists.length()) {
            char var = nestlists.charAt(i);

            // case 1: [
            // case 2: digit
            // case 3: ]
            // case 4: otherwise
            if (var == '[') {
                level++;
            } else if (Character.isDigit(var) || var == '-') {
                int sign = 1;
                // check sign
                if (var == '-') {
                    sign = -1;
                    i++;
                }

                int count = 0;
                while (Character.isDigit(nestlists.charAt(i))) {
                    count = count * 10 + Character.getNumericValue(nestlists.charAt(i++));
                }
                i--;

                count *= sign;

                // add to stack
                if (!stack.isEmpty() && level == stack.peek()[1]) {
                    int[] val = stack.pollFirst();
                    stack.offerFirst(new int[]{val[0] + count, level});
                } else {
                    stack.offerFirst(new int[]{count, level});
                }
            } else if (var == ']' && !stack.isEmpty()) {
                int[] val = stack.pollFirst();
                res += val[0] * val[1];
                level--;
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        NestedListWeightSum test = new NestedListWeightSum();
        System.out.println(test.depthSum("[-1]"));
    }
}
