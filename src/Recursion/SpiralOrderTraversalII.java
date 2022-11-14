package Recursion;

/*
Traverse an M * N 2D array in spiral order clock-wise starting from the top left corner. Return the list of traversal sequence.

        Assumptions

        The 2D array is not null and has size of M * N where M, N >= 0
        Examples

        { {1,  2,  3,  4},

        {5,  6,  7,  8},

        {9, 10, 11, 12} }

        the traversal sequence is [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
*/

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderTraversalII {
    // time complexity: O(m * n)
    // space complexity: O(1)
    public List<Integer> spiral(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int mOffset = 0;
        int nOffset = 0;
        int mSize = matrix.length;
        int nSize = matrix[0].length;

        while (mSize > 1 && nSize > 1) {
            for (int i = 0; i < nSize - 1; i++) {
                res.add(matrix[mOffset][i + nOffset]);
            }
            for (int i = 0; i < mSize - 1; i++) {
                res.add(matrix[i + mOffset][nSize + nOffset - 1]);
            }
            for (int i = nSize - 1; i >= 1; i--) {
                res.add(matrix[mSize + mOffset - 1][i + nOffset]);
            }
            for (int i = mSize - 1; i >= 1; i--) {
                res.add(matrix[i + mOffset][nOffset]);
            }
            mOffset++;
            nOffset++;
            mSize -= 2;
            nSize -= 2;
        }

        if (mSize == 1) {
            for (int i = 0; i < nSize; i++) {
                res.add(matrix[mOffset][i + nOffset]);
            }
        } else if (nSize == 1) {
            for (int i = 0; i < mSize; i++) {
                res.add(matrix[i + mOffset][nOffset]);
            }
        }
        return res;
    }

    // approach 1 - Iteration TC: O(mn) SC: O(1)
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int mSize = matrix.length;
        int nSize = matrix[0].length;
        int mOffset = 0;
        int nOffset = 0;

        while (mSize > 1 && nSize > 1) {
            // right
            for (int i = 0; i < nSize - 1; i++) {
                res.add(matrix[mOffset][nOffset + i]);
            }

            // down
            for (int i = 0; i < mSize - 1; i++) {
                res.add(matrix[mOffset + i][nSize + nOffset - 1]);
            }

            // left
            for (int i = nSize - 1; i > 0; i--) {
                res.add(matrix[mSize + mOffset - 1][nOffset + i]);
            }

            // up
            for (int i = mSize - 1; i > 0; i--) {
                res.add(matrix[mOffset + i][nOffset]);
            }

            // update
            mSize -= 2;
            nSize -= 2;
            mOffset++;
            nOffset++;
        }

        // add remaining
        if (mSize == 1) {
            // right
            for (int i = 0; i < nSize; i++) {
                res.add(matrix[mOffset][nOffset + i]);
            }
        } else if (nSize == 1) {
            // down
            for (int i = 0; i < mSize; i++) {
                res.add(matrix[mOffset + i][nSize + nOffset - 1]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SpiralOrderTraversalII test = new SpiralOrderTraversalII();
        int[][] matrix = new int[][]{{1}};
        System.out.println(test.spiralOrder(matrix));
    }
}
