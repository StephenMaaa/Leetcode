package Array;

/*
LeetCode 844

Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

        Note that after backspacing an empty text, the text will continue empty.
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class BackspaceStringCompare {
    // approach 1: Stack TC: O(m + n) SC: O(m + n)
    public boolean backspaceCompare2(String s, String t) {
        // initialization
        Deque<Character> stackA = new ArrayDeque<>();
        Deque<Character> stackB = new ArrayDeque<>();

        // process strings
        process(stackA, s);
        process(stackB, t);

//        // compare
//        while (!stackA.isEmpty() && !stackB.isEmpty()) {
//            // check
//            if (stackA.pollFirst() != stackB.pollFirst()) {
//                return false;
//            }
//        }
//        return stackA.isEmpty() && stackB.isEmpty();
        return String.valueOf(stackA).equals(String.valueOf(stackB));
    }

    private void process(Deque<Character> stack, String s) {
        for (char c : s.toCharArray()) {
            // check
            if (c == '#') {
                if (!stack.isEmpty()) {
                    stack.pollFirst();
                }
            } else {
                stack.offerFirst(c);
            }
        }
    }

    // approach 2: Two Pointers TC: O(m + n) SC: O(1)
    public boolean backspaceCompare(String s, String t) {
        // initialization
        int pointerA = s.length() - 1;
        int pointerB = t.length() - 1;
        int countA = 0;
        int countB = 0;

        // process
        while (pointerA >= 0 || pointerB >= 0) {
            // move to the next validate char
            while (pointerA >= 0) {
                char c = s.charAt(pointerA);

                // check
                if (c == '#') {
                    pointerA--;
                    countA++;
                } else if (countA > 0) {
                    pointerA--;
                    countA--;
                } else {
                    break;
                }
            }

            while (pointerB >= 0) {
                char c = t.charAt(pointerB);

                // check
                if (c == '#') {
                    pointerB--;
                    countB++;
                } else if (countB > 0) {
                    pointerB--;
                    countB--;
                } else {
                    break;
                }
            }

            // check
            if (pointerA >= 0 && pointerB >= 0 && s.charAt(pointerA) != t.charAt(pointerB)) {
                return false;
            }

            // update
            pointerA--;
            pointerB--;
        }
        return pointerA < 0 && pointerA == pointerB;
    }

    public static void main(String[] args) {
        BackspaceStringCompare test = new BackspaceStringCompare();
        System.out.println(test.backspaceCompare("nzp#o#g", "b#nzp#o#g"));
    }
}
