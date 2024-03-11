package String;

/*
LeetCode 20

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

        An input string is valid if:

        Open brackets must be closed by the same type of brackets.
        Open brackets must be closed in the correct order.
        Every close bracket has a corresponding open bracket of the same type.
*/

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ValidParentheses {
    // approach 1: Stack TC: O(n) SC: O(n)
    public boolean isValid(String s) {
        // initialization
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        // linear scan
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // check parenthesis
            // case 1: left parenthesis -> add to stack
            // case 2: right parenthesis -> check stack
            if (map.containsKey(c)) {
                stack.offerFirst(c);
            } else {
                // check match
                // case 1: match -> pop
                // case 2: not match -> invalid
                if (!stack.isEmpty() && map.get(stack.peekFirst()) == c) {
                    stack.pollFirst();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses test = new ValidParentheses();
        System.out.println(test.isValid("}"));
    }
}
