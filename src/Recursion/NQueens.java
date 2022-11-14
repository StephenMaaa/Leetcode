package Recursion;

/*
Get all valid ways of putting N Queens on an N * N chessboard so that no two Queens threaten each other.

        Assumptions

        N > 0
        Return

        A list of ways of putting the N Queens
        Each way is represented by a list of the Queen's y index for x indices of 0 to (N - 1)
        Example

        N = 4, there are two ways of putting 4 queens:

        [1, 3, 0, 2] --> the Queen on the first row is at y index 1, the Queen on the second row is at y index 3, the Queen on the third row is at y index 0 and the Queen on the fourth row is at y index 2.

        [2, 0, 3, 1] --> the Queen on the first row is at y index 2, the Queen on the second row is at y index 0, the Queen on the third row is at y index 3 and the Queen on the fourth row is at y index 1.
*/

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<List<Integer>> nqueens(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        findQueens(n, new ArrayList<>(), ans);
        return ans;
    }

    private void findQueens(int n, List<Integer> list, List<List<Integer>> ans) {
        // base case
        if (list.size() == n) {
            ans.add(new ArrayList<>(list));
        }

        for (int i = 0; i < n; i++) {
            if (check(list, i)) {
                list.add(i);
                findQueens(i, list, ans);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean check(List<Integer> list, int col) {
        int row = list.size();
        for (int i = 0; i < row; i++) {
            // check
            if (list.get(i) == col || Math.abs(list.get(i) - col) == row - i) {
                return false;
            }
        }
        return true;
    }

    // approach 1 - DFS TC: O(n!) SC: O(n^2)
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] queens = new int[n];

        // DFS
        find(0, n, queens, res);
        return res;
    }

    private void find(int row, int n, int[] queens, List<List<String>> res) {
        // base case
        if (row == n) {
            // parse result
            res.add(parse(queens));
            return;
        }

        // recursive case
        for (int i = 0; i < n; i++) {
            // check
            if (checkQueens(queens, row, i)) {
                queens[row] = i;
                find(row + 1, n, queens, res);
            }
        }
    }

    private List<String> parse(int[] arr) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append('.');
        }

        // set queens
        for (int i : arr) {
            sb.setCharAt(i, 'Q');
            list.add(sb.toString());
            sb.setCharAt(i, '.');
        }
        return list;
    }

    private boolean checkQueens(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            // case 1: same col
            // case 2: diagonal
            if (col == queens[i] || queens[i] + (row - i) == col || queens[i] - (row - i) == col) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NQueens test = new NQueens();
        System.out.println(test.solveNQueens(4));
    }
}
