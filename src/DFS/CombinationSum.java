package DFS;

/*
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

        The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

        It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
*/

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    // approach 1 - DFS TC: O(branch * n) SC: O(n)
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] candidates, int balance, int index, List<Integer> list, List<List<Integer>> res) {
        // base case
        if (balance == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        if (index == candidates.length) {
            return;
        }

        // recursive case
        for (int i = 0; i <= balance / candidates[index]; i++) {
            if (i > 0) {
                list.add(candidates[index]);
            }
            dfs(candidates, balance - i * candidates[index], index + 1, list, res);
        }

        for (int i = 1; i <= balance / candidates[index]; i++) {
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum test = new CombinationSum();
        int[] arr = new int[]{2, 3, 6, 8};
        System.out.println(test.combinationSum(arr, 1));
    }
}
