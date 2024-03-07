package Tree;

/*
leetCode 232

Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

        Implement the MyQueue class:

        void push(int x) Pushes element x to the back of the queue.
        int pop() Removes the element from the front of the queue and returns it.
        int peek() Returns the element at the front of the queue.
        boolean empty() Returns true if the queue is empty, false otherwise.
        Notes:

        You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
        Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
*/

import java.util.Stack;

public class ImplementQueueUsingStacks {
//    public class MyQueue {
//        Stack<Integer> stack;
//        Stack<Integer> tempStack;
//
//        public MyQueue() {
//            this.stack = new Stack<>();
//            this.tempStack = new Stack<>();
//        }
//
//        // TC: O(n)
//        public void push(int x) {
//            // move all elements in stack to temp
//            while (!stack.isEmpty()) {
//                tempStack.push(stack.pop());
//            }
//
//            // add new element to the bottom
//            stack.push(x);
//
//            // add back
//            while (!tempStack.isEmpty()) {
//                stack.push(tempStack.pop());
//            }
//        }
//
//        public int pop() {
//            return stack.pop();
//        }
//
//        public int peek() {
//            return stack.peek();
//        }
//
//        public boolean empty() {
//            return stack.isEmpty();
//        }
//    }

    public class MyQueue {
        Stack<Integer> startStack;
        Stack<Integer> endStack;

        public MyQueue() {
            this.startStack = new Stack<>();
            this.endStack = new Stack<>();
        }

        // TC: O(1)
        public void push(int x) {
            startStack.push(x);
        }

        // TC: O(1)
        public int pop() {
            // check endStack
            if (endStack.isEmpty()) {
                // move all startStack to endStack
                while (!startStack.isEmpty()) {
                    endStack.push(startStack.pop());
                }
            }
            return endStack.pop();
        }

        public int peek() {
            // check endStack
            if (endStack.isEmpty()) {
                // move all startStack to endStack
                while (!startStack.isEmpty()) {
                    endStack.push(startStack.pop());
                }
            }
            return endStack.peek();
        }

        public boolean empty() {
            return startStack.isEmpty() && endStack.isEmpty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
