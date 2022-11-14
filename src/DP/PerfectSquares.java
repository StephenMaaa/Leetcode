package DP;

/*
Given an integer n, return the least number of perfect square numbers that sum to n.

        A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
*/

import java.util.Arrays;

public class PerfectSquares {
//    // approach 1 - DP TC: O(n^2) SC: O(n)
//    public int numSquares(int n) {
//        // min array
//        int[] minArr = new int[n + 1];
//        for (int i = 1; i < n + 1; i++) {
//            // case 1: i == k^2
//            // case 2: otherwise
//            int x = (int) Math.sqrt(i);
//            if (x * x == i) {
//                minArr[i] = 1;
//            } else {
//                int min = Integer.MAX_VALUE;
//                for (int j = 1; j < i; j++) {
//                    min = Math.min(min, minArr[j] + minArr[i - j]);
//                }
//                minArr[i] = min;
//            }
//        }
//        return minArr[n];
//    }

    // approach 2 - DP TC: O(n * sqrt(n)) SC: O(n)
    public int numSquares(int n) {
        // min array
        int[] minArr = new int[n + 1];
        Arrays.fill(minArr, Integer.MAX_VALUE);
        minArr[0] = 0;

        // populate a perfect square array
        int x = (int) Math.sqrt(n) + 1;
        int[] squares = new int[x];
        for (int i = 1; i < x; i++) {
            squares[i] = i * i;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < x; j++) {
                if (i < squares[j]) {
                    continue;
                }

                minArr[i] = Math.min(minArr[i], minArr[i - squares[j]] + 1);
            }
        }
        return minArr[n];
    }

    public static void main(String[] args) {
        PerfectSquares test = new PerfectSquares();
        System.out.println(test.numSquares(13));
    }
}
