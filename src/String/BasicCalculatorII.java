package String;

/*
Given a string s which represents an expression, evaluate this expression and return its value.

        The integer division should truncate toward zero.

        You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].

        Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class BasicCalculatorII {
//    // approach 1 - Stack TC: O(n) SC: O(n)
//    public int calculate(String s) {
//        Deque<Integer> stack = new ArrayDeque<>();
//        Deque<Character> opStack = new ArrayDeque<>();
//        int i = 0;
//        while (i < s.length()) {
//            // skip whitespace
//            while (i < s.length() && s.charAt(i) == ' ') {
//                i++;
//            }
//
//            if (i == s.length()) {
//                break;
//            }
//
//            // case 1: num
//            // case 2: op
//            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
//                int count = i;
//                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
//                    i++;
//                }
//                stack.offerFirst(Integer.valueOf(s.substring(count, i)));
//
//                // immediate op
//                if (!opStack.isEmpty() && (opStack.peekFirst() == '*' || opStack.peekFirst() == '/')) {
//                    int num2 = stack.pollFirst();
//                    int num1 = stack.pollFirst();
//                    stack.offerFirst(op(num1, num2, opStack.pollFirst()));
//                }
//            } else {
//                opStack.offerFirst(s.charAt(i++));
//            }
//        }
//
//        // process addition and subtraction
//        while (!opStack.isEmpty()) {
//            int num1 = stack.pollLast();
//            int num2 = stack.pollLast();
//            stack.offerLast(op(num1, num2, opStack.pollLast()));
//        }
//        return stack.pollFirst();
//    }

//    private int op(int num1, int num2, char operator) {
//        switch (operator) {
//            case '+': return num1 + num2;
//            case '-': return num1 - num2;
//            case '*': return num1 * num2;
//            default: return num1 / num2;
//        }
//    }

//    // approach 2 - Stack TC: O(n) SC: O(n)
//    public int calculate(String s) {
//        Deque<Integer> stack = new ArrayDeque<>();
//        int num = 0;
//        char op = '+';
//        for (int i = 0; i < s.length(); i++) {
//            // case 1: num
//            // case 2: op
//            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
//                num = num * 10 + s.charAt(i) - '0';
//            }
//
//            if ((s.charAt(i) < '0' || s.charAt(i) > '9') && s.charAt(i) != ' ' || i == s.length() - 1) {
//                switch (op) {
//                    case '+':
//                        stack.offerFirst(num);
//                        break;
//                    case '-':
//                        stack.offerFirst(-num);
//                        break;
//                    case '*':
//                        stack.offerFirst(stack.pollFirst() * num);
//                        break;
//                    default:
//                        stack.offerFirst(stack.pollFirst() / num);
//                }
//                op = s.charAt(i);
//                num = 0;
//            }
//        }
//
//        // process all addition and subtraction
//        int res = 0;
//        while (!stack.isEmpty()) {
//            res += stack.pollFirst();
//        }
//        return res;
//    }

    // approach 3 - Pointer TC: O(n) SC: O(1)
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        int lastNum = 0;
        int num = 0;
        char op = '+';
        for (int i = 0; i < s.length(); i++) {
            // case 1: num
            // case 2: op
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                num = num * 10 + s.charAt(i) - '0';
            }

            if ((s.charAt(i) < '0' || s.charAt(i) > '9') && s.charAt(i) != ' ' || i == s.length() - 1) {
                switch (op) {
                    case '+':
                        res += lastNum;
                        lastNum = num;
                        break;
                    case '-':
                        res += lastNum;
                        lastNum = -num;
                        break;
                    case '*':
                        lastNum *= num;
                        break;
                    default:
                        lastNum /= num;
                }
                op = s.charAt(i);
                num = 0;
            }
        }
        res += lastNum;
        return res;
    }

    public static void main(String[] args) {
        BasicCalculatorII test = new BasicCalculatorII();
        System.out.println(test.calculate("2*2"));
    }
}
