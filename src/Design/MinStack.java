package Design;

/*
LeetCode 155

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

        Implement the MinStack class:

        MinStack() initializes the stack object.
        void push(int val) pushes the element val onto the stack.
        void pop() removes the element on the top of the stack.
        int top() gets the top element of the stack.
        int getMin() retrieves the minimum element in the stack.
        You must implement a solution with O(1) time complexity for each function.
*/

import java.util.Stack;

public class MinStack {
    class MinStackClass {
        Stack<Integer> stack;
        Stack<Integer[]> minStack;

        public MinStackClass() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            // add to stack
            stack.push(val);

            // check min stack
            if (minStack.isEmpty() || minStack.peek()[0] > val) {
                minStack.push(new Integer[]{val, stack.size()});
            }
        }

        public void pop() {
            // remove from stack
            stack.pop();

            // check and remove from min stack
            if (!minStack.isEmpty() && stack.size() + 1 == minStack.peek()[1]) {
                minStack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek()[0];
        }
    }
}
