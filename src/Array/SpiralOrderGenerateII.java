package Array;

/*
Generate an N * N 2D array in spiral order clock-wise starting from the top left corner, using the numbers of 1, 2, 3, …, N * N in increasing order.

        Assumptions

        N >= 0
        Examples

        N = 3, the generated matrix is

        { {1,  2,  3}

        {8,  9,  4},

        {7,  6,  5} }
*/

public class SpiralOrderGenerateII {
    // time complexity: O(n^2)
    // space complexity: O(1)
    public int[][] spiralGenerate(int n) {
        int[][] matrix = new int[n][n];
        int offset = 0;
        int count = 1;

        while (n > 1) {
            for (int i = 0; i < n - 1; i++) {
                matrix[offset][offset + i] = count++;
            }

            for (int i = 0; i < n - 1; i++) {
                matrix[offset + i][offset + n - 1] = count++;
            }

            for (int i = n - 1; i > 0; i--) {
                matrix[offset + n - 1][offset + i] = count++;
            }

            for (int i = n - 1; i > 0; i--) {
                matrix[offset + i][offset] = count++;
            }
            offset++;
            n -= 2;
        }

        if (n == 1) {
            matrix[offset][offset] = count++;
        }
        return matrix;
    }

    public static void main(String[] args) {
        SpiralOrderGenerateII test = new SpiralOrderGenerateII();
        System.out.println(test.spiralGenerate(0));
    }
}
