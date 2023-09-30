package Array;

/*
LeetCode 739

Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
*/

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperatures {
    // approach 1: Stack TC: O(n) SC: O(n)
    public int[] dailyTemperatures(int[] temperatures) {
        // initialization
        int[] res = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++) {
            // check
            while (!stack.isEmpty() && temperatures[stack.peekFirst()] < temperatures[i]) {
                int index = stack.pollFirst();
                res[index] = i - index;
            }

            // add
            stack.offerFirst(i);
        }
        return res;
    }

    public static void main(String[] args) {
        DailyTemperatures test = new DailyTemperatures();
        int[] arr = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(test.dailyTemperatures(arr)));
    }
}
