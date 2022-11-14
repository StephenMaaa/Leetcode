package DFS;

/*
Given a string with no duplicate characters, return a list with all permutations of the string and all its subsets.



        Examples

        Set = “abc”, all permutations are [“”, “a”, “ab”, “abc”, “ac”, “acb”, “b”, “ba”, “bac”, “bc”, “bca”, “c”, “cb”, “cba”, “ca”, “cab”].

        Set = “”, all permutations are [“”].

        Set = null, all permutations are [].
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPermutationsOfSubsets {
    public List<String> allPermutationsOfSubsets(String set) {
        List<String> ans = new ArrayList<>();

        // edge case
        if (set == null) {
            return ans;
        }

        char[] arr = set.toCharArray();
        dfs(arr, 0, ans);
        return ans;
    }

    private void dfs(char[] arr, int index, List<String> list) {
        // base case
        list.add(new String(Arrays.copyOf(arr, index)));

        if (index == arr.length) {
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            dfs(arr, index + 1, list);
            swap(arr, index, i);
        }
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        AllPermutationsOfSubsets test = new AllPermutationsOfSubsets();
        System.out.println(test.allPermutationsOfSubsets(null));
    }
}
