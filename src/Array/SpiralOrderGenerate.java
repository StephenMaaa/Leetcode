package Array;

/*
Generate an M * N 2D array in spiral order clock-wise starting from the top left corner, using the numbers of 1, 2, 3, …, M * N in increasing order.

        Assumptions

        M >= 0, N >= 0
        Examples

        M = 3, N = 4, the generated matrix is

        { {1,  2,  3,  4}

        {10, 11, 12, 5},

        {9,  8,  7,  6} }
*/

public class SpiralOrderGenerate {
    // time complexity: O(m * n)
    // space complexity: O(1)
    public int[][] spiralGenerate(int m, int n) {
        int[][] matrix = new int[m][n];
        int count = 1;
        int mOffset = 0;
        int nOffset = 0;
        while (m > 1 && n > 1) {
            for (int i = 0; i < n - 1; i++) {
                matrix[mOffset][nOffset + i] = count++;
            }

            for (int i = 0; i < m - 1; i++) {
                matrix[mOffset + i][nOffset + n - 1] = count++;
            }

            for (int i = n - 1; i > 0; i--) {
                matrix[mOffset + m - 1][nOffset + i] = count++;
            }

            for (int i = m - 1; i > 0; i--) {
                matrix[mOffset + i][nOffset] = count++;
            }
            mOffset++;
            nOffset++;
            m -= 2;
            n -= 2;
        }

        if (m == 1) {
            for (int i = 0; i < n; i++) {
                matrix[mOffset][nOffset + i] = count++;
            }
        } else if (n == 1) {
            for (int i = 0; i < m; i++) {
                matrix[mOffset + i][nOffset] = count++;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        SpiralOrderGenerate test = new SpiralOrderGenerate();
        System.out.println(test.spiralGenerate(3, 1));
    }
}
