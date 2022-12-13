package Airbnb;

import java.util.ArrayList;
import java.util.List;

public class MenuCombinationSum {
    // approach 1 - DFS TC: O(n^(T/m)) SC: O(T/m)
    public List<List<String>> menuCombinationSum(String[] menu, double[] price, double target) {
        List<List<String>> res = new ArrayList<>();

        // rescale the value
        int scaledTarget = (int) target * 100;
        int[] scaledPrice = new int[price.length];
        for (int i = 0; i < menu.length; i++) {
            scaledPrice[i] = (int) price[i] * 100;
        }
        dfs(menu, scaledPrice, scaledTarget, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(String[] menu, int[] price, int target, int index, List<String> list, List<List<String>> res) {
        // base case
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        // recursive case
        for (int i = index; i < menu.length; i++) {
            if (target >= price[i]) {
                list.add(menu[i]);
                dfs(menu, price, target - price[i], i, list, res);
                list.remove(list.size() - 1);
            }
        }
    }
}
