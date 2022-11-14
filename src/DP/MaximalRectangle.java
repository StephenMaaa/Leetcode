package DP;

/*
Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximalRectangle {
//    // approach 1 - 2D DP + DP TC: O(mn) SC: O(mn)
//    public int maximalRectangle(char[][] matrix) {
//        // generate prefixSum matrix
//        int rows = matrix.length;
//        int cols = matrix[0].length;
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                matrix[i][j] -= '0';
//                if (i == 0) {
//                    continue;
//                }
//
//                if (matrix[i][j] == 1) {
//                    matrix[i][j] = (char) (matrix[i - 1][j] + 1);
//                }
//            }
//        }
//
//        // find max
//        int max = 0;
//        for (int i = 0; i < rows; i++) {
//            // find the largest histogram in each row
//            max = Math.max(max, findLargestHistogram(matrix[i]));
//        }
//        return max;
//    }
//
//    private int findLargestHistogram(char[] row) {
//        int max = 0;
//        Deque<Integer> stack = new ArrayDeque<>();
//        for (int i = 0; i <= row.length; i++) {
//            int rightHeight = i == row.length ? 0 : row[i];
//
//            // maintain a monotonic ascending stack
//            while (!stack.isEmpty() && row[stack.peekFirst()] > rightHeight) {
//                int height = row[stack.pollFirst()];
//                int leftBound = stack.isEmpty() ? -1 : stack.peekFirst();
//                max = Math.max(max, height * (i - leftBound - 1));
//            }
//            stack.offerFirst(i);
//        }
//        return max;
//    }

    // approach 1 - 2D DP + DP TC: O(mn) SC: O(n)
    public int maximalRectangle(char[][] matrix) {
        // generate prefixSum matrix
        int rows = matrix.length;
        int cols = matrix[0].length;
        Deque<Integer> stack = new ArrayDeque<>();
        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] -= '0';
                if (i == 0) {
                    continue;
                }

                if (matrix[i][j] == 1) {
                    matrix[i][j] = (char) (matrix[i - 1][j] + 1);
                }
            }

            // find the largest histogram in each row
            max = Math.max(max, findLargestHistogram(matrix[i], stack));
        }
        return max;
    }

    private int findLargestHistogram(char[] row, Deque<Integer> stack) {
        int max = 0;
        for (int i = 0; i <= row.length; i++) {
            int rightHeight = i == row.length ? 0 : row[i];

            // maintain a monotonic ascending stack
            while (!stack.isEmpty() && row[stack.peekFirst()] >= rightHeight) {
                int height = row[stack.pollFirst()];
                int leftBound = stack.isEmpty() ? -1 : stack.peekFirst();
                max = Math.max(max, height * (i - leftBound - 1));
            }
            stack.offerFirst(i);
        }
        stack.pollFirst();
        return max;
    }

    public static void main(String[] args) {
        MaximalRectangle test = new MaximalRectangle();
        char[][] matrix = new char[][]{{'1', '0', '1', '0', '0'},
                                       {'1', '0', '1', '1', '1'},
                                       {'1', '1', '1', '1', '1'},
                                       {'1', '0', '0', '1', '0'}};
        System.out.println(test.maximalRectangle(matrix));
    }
}
