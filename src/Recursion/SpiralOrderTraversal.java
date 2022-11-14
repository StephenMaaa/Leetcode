package Recursion;

/*
Traverse an N * N 2D array in spiral order clock-wise starting from the top left corner. Return the list of traversal sequence.

        Assumptions

        The 2D array is not null and has size of N * N where N >= 0
        Examples

        { {1,  2,  3},

        {4,  5,  6},

        {7,  8,  9} }

        the traversal sequence is [1, 2, 3, 6, 9, 8, 7, 4, 5]
*/

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderTraversal {
    // time complexity: O(n ^ 2)
    // space complexity: O(n) -> can be improved to O(1)
    public List<Integer> spiral(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        traverse(matrix, 0, matrix.length, ans);
        return ans;
    }

    private void traverse(int[][] matrix, int offset, int size, List<Integer> list) {
        if (size == 0) {
            return;
        }
        if (size == 1) {
            list.add(matrix[offset][offset]);
            return;
        }

        // left -> right
        for (int i = 0; i < size; i++) {
            list.add(matrix[offset][i + offset]);
        }
        for (int i = 1; i < size; i++) {
            list.add(matrix[i + offset][size + offset - 1]);
        }
        for (int i = size - 2; i >= 0; i--) {
            list.add(matrix[size + offset - 1][i + offset]);
        }
        for (int i = size - 2; i >= 1; i--) {
            list.add(matrix[i + offset][offset]);
        }

        traverse(matrix, offset + 1, size - 2, list);
    }

    public static void main(String[] args) {
        SpiralOrderTraversal test = new SpiralOrderTraversal();
        int[][] matrix = new int[][]{};
        System.out.println(test.spiral(matrix));
    }
}
