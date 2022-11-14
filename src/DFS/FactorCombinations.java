package DFS;

/*
Given an integer number, return all possible combinations of the factors that can multiply to the target number.

        Example

        Give A = 24

        since 24 = 2 x 2 x 2 x 3

        = 2 x 2 x 6

        = 2 x 3 x 4

        = 2 x 12

        = 3 x 8

        = 4 x 6

        your solution should return

        { { 2, 2, 2, 3 }, { 2, 2, 6 }, { 2, 3, 4 }, { 2, 12 }, { 3, 8 }, { 4, 6 } }

        note: duplicate combination is not allowed.
*/

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {
    public List<List<Integer>> combinations(int target) {
        List<List<Integer>> ans = new ArrayList<>();

        // find all factors
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i <= target / 2; i++) {
            if (target % i == 0) {
                factors.add(i);
            }
        }

        if (factors.size() == 0) {
            return ans;
        }

        dfs(target, 0, factors, new ArrayList<>(), ans);
        return ans;
    }

    private void dfs(int target, int index, List<Integer> factors, List<Integer> cur, List<List<Integer>> list) {
        // base case
        if (target == 1) {
            list.add(new ArrayList<>(cur));
            return;
        }

        if (index == factors.size()) {
            return;
        }

        // skip
        dfs(target, index + 1, factors, cur, list);

        // add
        int count = 0;
        while (target % factors.get(index) == 0) {
            count++;
            target /= factors.get(index);
            cur.add(factors.get(index));
            dfs(target, index + 1, factors, cur, list);
        }

        while (count > 0) {
            cur.remove(cur.size() - 1);
            count--;
        }
    }

    public static void main(String[] args) {
        FactorCombinations test = new FactorCombinations();
        System.out.println(test.combinations(4));
    }
}
