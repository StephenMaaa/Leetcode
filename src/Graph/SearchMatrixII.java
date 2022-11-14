package Graph;

/*
Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

        Integers in each row are sorted in ascending from left to right.
        Integers in each column are sorted in ascending from top to bottom.
*/

public class SearchMatrixII {
//    // approach 1 - Pointers TC: O(m + n) SC: O(1)
//    public boolean searchMatrix(int[][] matrix, int target) {
//        int row = matrix.length - 1;
//        int col = 0;
//        boolean order = true;
//        while (row >= 0 && col < matrix[0].length) {
//            // case 1: row
//            // case 2: col
//            if (order) {
//                while (row >= 0 && target < matrix[row][col]) {
//                    row--;
//                }
//
//                // check
//                if (row >= 0 && target == matrix[row][col]) {
//                    return true;
//                }
//            } else {
//                while (col < matrix[0].length && target > matrix[row][col]) {
//                    col++;
//                }
//
//                // check
//                if (col < matrix[0].length && target == matrix[row][col]) {
//                    return true;
//                }
//            }
//            order = !order;
//        }
//        return false;
//    }

    // approach 1 - Pointers TC: O(m + n) SC: O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            // case 1: row
            // case 2: col
            if (target < matrix[row][col]) {
                row--;
            } else if (target > matrix[row][col]) {
                col++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchMatrixII test = new SearchMatrixII();
        int[][] matrix = new int[][]{{1, 4, 7, 11, 15},
                                    {2, 4, 8, 12, 19},
                                    {3, 6, 9, 16, 22},
                                    {10, 13, 14, 17, 24},
                                    {18, 21, 23, 26, 30}};
        System.out.println(test.searchMatrix(matrix, 5));
    }
}
