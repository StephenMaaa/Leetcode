package DFS;

/*
Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

        Only numbers 1 through 9 are used.
        Each number is used at most once.
        Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
*/

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    // approach 1 - DFS TC: O(1) SC: O(1)
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(n, k, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int balance, int index, List<Integer> list, List<List<Integer>> res) {
        // base case
        if (index == 0) {
            if (balance == 0) {
                res.add(new ArrayList<>(list));
            }
            return;
        }

        // recursive case
        int start = list.size() == 0 ? 1 : list.get(list.size() - 1) + 1;
        for (int i = start; i <= 9; i++) {
            if (balance < i) {
                break;
            }

            list.add(i);
            dfs(balance - i, index - 1, list, res);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSumIII test = new CombinationSumIII();
        System.out.println(test.combinationSum3(4, 1));
    }
}
