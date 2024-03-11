package String;

/*
LeetCode 150

Evaluate the value of an arithmetic expression in Reverse Polish Notation.

        Valid operators are +, -, *, and /. Each operand may be an integer or another expression.

        Note that division between two integers should truncate toward zero.

        It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a result, and there will not be any division by zero operation.
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluateReversePolishNotation {
//    // approach 1 - Stack TC: O(n) SC: O(n)
//    public int evalRPN(String[] tokens) {
//        Deque<Integer> stack = new ArrayDeque<>();
//        for (int i = 0; i < tokens.length; i++) {
//            // case 1: num
//            // case 2: op
//            if (tokens[i].charAt(tokens[i].length() - 1) >= '0' && tokens[i].charAt(tokens[i].length() - 1) <= '9') {
//                stack.offerFirst(Integer.valueOf(tokens[i]));
//            } else {
//                int num2 = stack.pollFirst();
//                int num1 = stack.pollFirst();
//                stack.offerFirst(op(num1, num2, tokens[i]));
//            }
//        }
//        return stack.pollFirst();
//    }
//
//    private int op(int num1, int num2, String operator) {
//        switch (operator) {
//            case "+": return num1 + num2;
//            case "-": return num1 - num2;
//            case "*": return num1 * num2;
//            case "/": return num1 / num2;
//            default: return -1;
//        }
//    }

    // approach 1: Stack TC: O(n) SC: O(n)
    public int evalRPN(String[] tokens) {
        // initialization
        Deque<Integer> stack = new ArrayDeque<>();

        // linear scan
        for (int i = 0; i < tokens.length; i++) {
            String c = tokens[i];

            // check
            // case 1: num -> add to stack
            // case 2: operator -> calculate
            if (Character.isDigit(c.charAt(c.length() - 1))) {
                stack.offerFirst(Integer.valueOf(c));
            } else {
                int numA = stack.pollFirst();
                int numB = stack.pollFirst();
                int res = calculate(numB, numA, c);
                stack.offerFirst(res);
            }
        }
        return stack.pollFirst();
    }

    private int calculate(int a, int b, String operator) {
        // calculate
        if (operator.equals("+")) {
            return a + b;
        } else if (operator.equals("-")) {
            return a - b;
        } else if (operator.equals("*")) {
            return a * b;
        } else {
            return a / b;
        }
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation test = new EvaluateReversePolishNotation();
        String[] arr = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(test.evalRPN(arr));
    }
}
