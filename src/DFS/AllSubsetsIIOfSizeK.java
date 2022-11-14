package DFS;

/*
Given a set of characters represented by a String, return a list containing all subsets of the characters whose size is K. Notice that each subset returned will be sorted for deduplication.



        Assumptions

        There could be duplicate characters in the original set.

        ​

        Examples

        Set = "abc", K = 2, all the subsets are [“ab”, “ac”, “bc”].

        Set = "abb", K = 2, all the subsets are [“ab”, “bb”].

        Set = "abab", K = 2, all the subsets are [“aa”, “ab”, “bb”].

        Set = "", K = 0, all the subsets are [""].

        Set = "", K = 1, all the subsets are [].

        Set = null, K = 0, all the subsets are [].
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubsetsIIOfSizeK {
    public List<String> subSetsIIOfSizeK(String set, int k) {
        List<String> ans = new ArrayList<>();

        // edge case
        if (set == null) {
            return ans;
        }
        char[] arr = set.toCharArray();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        dfs(arr, sb, 0, k, ans);
        return ans;
    }

    private void dfs(char[] arr, StringBuilder sb, int index, int k, List<String> list) {
        // base case
        if (sb.length() == k) {
            list.add(sb.toString());
            return;
        }

        if (index == arr.length) {
            return;
        }

        // add
        sb.append(arr[index]);
        dfs(arr, sb, index + 1, k, list);
        sb.deleteCharAt(sb.length() - 1);

        // skip
        while (index < arr.length - 1 && arr[index] == arr[index + 1]) {
            index++;
        }
        dfs(arr, sb, index + 1, k, list);
    }

    public static void main(String[] args) {
        String set = null;
        AllSubsetsIIOfSizeK test = new AllSubsetsIIOfSizeK();
        List<String> ans = test.subSetsIIOfSizeK(set, 2);
        System.out.println(ans);
    }
}
