package Array;

/*
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

        Each row must contain the digits 1-9 without repetition.
        Each column must contain the digits 1-9 without repetition.
        Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
        Note:

        A Sudoku board (partially filled) could be valid but is not necessarily solvable.
        Only the filled cells need to be validated according to the mentioned rules.
*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {
    // approach 1 - Block Traversal + Map TC: O(9 * 9) SC: O(9 * 9 * 3)
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Integer>> rowMap = new HashMap<>();
        Map<Integer, Set<Integer>> colMap = new HashMap<>();

        // traverse blocks
        for (int blockRow = 0; blockRow < 3; blockRow++) {
            for (int blockCol = 0; blockCol < 3; blockCol++) {
                int row = 3 * blockRow;
                int col = 3 * blockCol;
                Set<Integer> set = new HashSet<>();

                for (int i = row; i < row + 3; i++) {
                    for (int j = col; j < col + 3; j++) {
                        int val = board[i][j];
                        if (val == '.') {
                            continue;
                        }

                        // case 1: block dup
                        // case 2: row dup
                        // case 3: col dup
                        if (set.contains(val)) {
                            return false;
                        }

                        if (rowMap.containsKey(i) && rowMap.get(i).contains(val)) {
                            return false;
                        }

                        if (colMap.containsKey(j) && colMap.get(j).contains(val)) {
                            return false;
                        }

                        set.add(val);
                        if (!rowMap.containsKey(i)) {
                            rowMap.put(i, new HashSet<>());
                        }
                        rowMap.get(i).add(val);

                        if (!colMap.containsKey(j)) {
                            colMap.put(j, new HashSet<>());
                        }
                        colMap.get(j).add(val);
                    }
                }
            }
        }
        return true;
    }

    // approach 2 - Block Traversal + int array TC: O(9 * 9) SC: O(9 * 9 * 3)
    public boolean isValidSudoku2(char[][] board) {
        int[][] rowDup = new int[9][9];
        int[][] colDup = new int[9][9];
        int[][][] blockDup = new int[3][3][9];

        // traverse blocks
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char digit = board[i][j];
                if (digit == '.') {
                    continue;
                }
                int index = digit - '0' - 1;
                rowDup[i][index]++;
                colDup[j][index]++;
                blockDup[i / 3][j / 3][index]++;

                // check dup
                if (rowDup[i][index] > 1 || colDup[j][index] > 1 || blockDup[i / 3][j / 3][index] > 1) {
                    return false;
                }
            }
        }
        return true;
    }

//    public static void main(String[] args) {
//        ValidSudoku test = new ValidSudoku();
//        char[][] board = new char[][]{}
//    }
}
