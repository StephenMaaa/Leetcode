package Airbnb;

import java.util.ArrayList;
import java.util.List;

public class AllCombinations {
    // approach 1 - DFS TC: O(2^n) SC: O(n)
    public List<String> allCombinations(String s) {
        List<String> res = new ArrayList<>();
        s = s.toLowerCase();
        dfs(s.toCharArray(), 0, res);
        return res;
    }

    private void dfs(char[] arr, int index, List<String> res) {
        // base case
        if (index == arr.length) {
            res.add(new String(arr));
            return;
        }

        // recursive case
        // lowercase
        dfs(arr, index + 1, res);

        // uppercase
        arr[index] -= 32;
        dfs(arr, index + 1, res);
        arr[index] += 32;
    }

    public static void main(String[] args) {
        AllCombinations test = new AllCombinations();
        System.out.println(test.allCombinations("abc"));
    }
}
