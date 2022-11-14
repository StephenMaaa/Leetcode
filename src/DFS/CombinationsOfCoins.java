package DFS;

import java.util.ArrayList;
import java.util.List;

public class CombinationsOfCoins {
    public List<List<Integer>> combinations(int target, int[] coins) {
        // Write your solution here
        List<List<Integer>> ans = new ArrayList<>();
        if (target < 0 || coins == null || coins.length == 0) {
            return ans;
        }
//        List<Integer> count = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        dfs(target, coins, 0, count, ans);
        return ans;
    }

    private void dfs(int target, int[] coins, int index, List<Integer> count, List<List<Integer>> list) {
        if (index == coins.length) {
            if (target == 0) {
                list.add(new ArrayList<>(count));
            }
            return;
        }

        // branch: # of max largest coin
        for (int i = 0; i <= target / coins[index]; i++) {
            count.add(i);
            dfs(target - coins[index] * i, coins, index + 1, count, list);
            count.remove(count.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationsOfCoins test = new CombinationsOfCoins();
        int[] coins = new int[]{25, 10, 5, 1};
        System.out.println(test.combinations(11, coins));
    }
}
