package DFS;

import java.util.ArrayList;
import java.util.List;

/* Given a string with no duplicate characters, return a list with all permutations of the characters.

        Assume that input string is not null.

        Examples

        Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]

        Set = "", all permutations are [""]
*/

public class AllPermutations {
    public List<String> permutations(String input) {
        // Write your solution here
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

        // branch: all possible swap
        for (int i = index; i < arr.length; i++) {
            swap(arr, i, index);
            dfs(arr, index + 1, list);
            swap(arr, i, index);
        }
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        AllPermutations test = new AllPermutations();
        List<String> ans = test.permutations("abc");
        System.out.println(ans);
    }
}
