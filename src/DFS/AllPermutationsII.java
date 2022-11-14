package DFS;


/*
Given a string with possible duplicate characters, return a list with all permutations of the characters.

        Examples

        Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]
        Set = "aba", all permutations are ["aab", "aba", "baa"]
        Set = "", all permutations are [""]
        Set = null, all permutations are []
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllPermutationsII {
    public List<String> permutations(String input) {
        List<String> ans = new ArrayList<>();
        if (input == null) {
            return ans;
        }

        char[] arr = input.toCharArray();
        dfs(arr, 0, ans);
        return ans;
    }

    private void dfs(char[] arr, int index, List<String> list) {
        if (index == arr.length) {
            list.add(new String(arr));
            return;
        }

        Set<Character> set = new HashSet<>();
        for (int i = index; i < arr.length; i++) {
            if (!set.contains(arr[i])) {
                set.add(arr[i]);
                swap(arr, i, index);
                dfs(arr, index + 1, list);
                swap(arr, i, index);
            }
        }
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        AllPermutationsII test = new AllPermutationsII();
        List<String> ans = test.permutations(null);
        System.out.println(ans);
    }
}
