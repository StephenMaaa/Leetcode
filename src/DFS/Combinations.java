package DFS;

/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

        E.g.    Input: n = 4, k = 2

        Output: [

        [2,4],

        [3,4],

        [2,3],

        [1,2],

        [1,3],

        [1,4]

        ]
*/

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    // time complexity: O(C(n, k))
    // space complexity: O(n)
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(new ArrayList<>(), 0, n, k, res);
        return res;
    }

    private void dfs(List<Integer> list, int index, int n, int k, List<List<Integer>> res) {
        // base case
        if (list.size() + (n - index + 1) < k) {
            return;
        }

        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        // recursive case
        for (int i = index; i < n; i++) {
            list.add(i + 1);
            dfs(list, i + 1, n, k, res);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combinations test = new Combinations();
        System.out.println(test.combine(4, 2)); 
    }
}
