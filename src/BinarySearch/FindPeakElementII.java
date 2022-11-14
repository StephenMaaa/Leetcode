package BinarySearch;

/*
A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to the left, right, top, and bottom.

        Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return the length 2 array [i,j].

        You may assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.

        You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.
*/

import java.util.Arrays;

public class FindPeakElementII {
    // time complexity: O(nlogm)
    // space complexity: O(1)
    public int[] findPeakGrid(int[][] mat) {
        int topRow = 0;
        int bottomRow = mat.length - 1;

        // binary search
        while (topRow <= bottomRow) {
            int mid = topRow + (bottomRow - topRow) / 2;

            // find global max
            int max = Integer.MIN_VALUE;
            int maxIndex = -1;
            for (int i = 0; i < mat[0].length; i++) {
                if (max < mat[mid][i]) {
                    max = mat[mid][i];
                    maxIndex = i;
                }
            }

            // check
            if (mid != 0 && mat[mid - 1][maxIndex] > mat[mid][maxIndex]) {
                bottomRow = mid - 1;
            } else if (mid != mat.length - 1 && mat[mid + 1][maxIndex] > mat[mid][maxIndex]) {
                topRow = mid + 1;
            } else {
                return new int[]{mid, maxIndex};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        FindPeakElementII test = new FindPeakElementII();
        int[][] grid = new int[][]{{7, 2, 3, 1, 2},
                                   {8, 5, 4, 2, 1}};
        System.out.println(Arrays.toString(test.findPeakGrid(grid)));
    }
}
