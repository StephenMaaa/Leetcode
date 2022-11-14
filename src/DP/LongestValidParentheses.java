package DP;

/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

        Example

        ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
*/

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LongestValidParentheses {
    // approach 1 - Stack TC: O(n) SC: O(n)
    public int longestValidParentheses(String input) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.offerFirst(-1);
        int max = 0;

        for (int i = 0; i < input.length(); i++) {
            // case 1: (
            // case 2: )
            if (input.charAt(i) == '(') {
                stack.offerFirst(i);
            } else {
                stack.pollFirst();

                // check and update
                // case 1: left < right -> reset
                // case 2: left >= right -> update
                if (stack.isEmpty()) {
                    stack.offerFirst(i);
                } else {
                    max = Math.max(max, i - stack.peekFirst());
                }
            }
        }
        return max;
    }

    // approach 2 - Linear Scan TC: O(n) SC: O(1)
    public int longestValidParentheses2(String input) {
        int left = 0;
        int right = 0;
        int max = 0;

        // linear scan and check forward
        for (int i = 0; i < input.length(); i++) {
            // case 1: (
            // case 2: )
            if (input.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            // check and update
            // case 1: left == right -> update
            // case 2: left < right -> reset
            if (left == right) {
                max = Math.max(max, left + right);
            } else if (left < right) {
                left = 0;
                right = 0;
            }
        }

        left = 0;
        right = 0;

        // linear scan and check backward
        for (int i = input.length() - 1; i >= 0; i--) {
            // case 1: (
            // case 2: )
            if (input.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            // check and update
            // case 1: left == right -> update
            // case 2: left < right -> reset
            if (left == right) {
                max = Math.max(max, left + right);
            } else if (left > right) {
                left = 0;
                right = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestValidParentheses test = new LongestValidParentheses();
        System.out.println(test.longestValidParentheses2(""));
    }
}
