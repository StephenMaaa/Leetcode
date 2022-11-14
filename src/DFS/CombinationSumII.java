package DFS;

/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

        Each number in candidates may only be used once in the combination.

        Note: The solution set must not contain duplicate combinations.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    // approach 1 - DFS TC: O(2^n) SC: O(n)
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        // sort
        Arrays.sort(candidates);
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
        // take
        if (balance >= candidates[index]) {
            list.add(candidates[index]);
            dfs(candidates, balance - candidates[index], index + 1, list, res);
            list.remove(list.size() - 1);
        }

        // skip
        while (index < candidates.length - 1 && candidates[index] == candidates[index + 1]) {
            index++;
        }
        dfs(candidates, balance, index + 1, list, res);
    }

    public static void main(String[] args) {
        CombinationSumII test = new CombinationSumII();
        int[] arr = new int[]{2, 5, 2, 1, 2};
        System.out.println(test.combinationSum2(arr, 5));
    }
}
