package DFS;

//Given a set of characters represented by a String, return a list containing all subsets of the characters. Notice that each subset returned will be sorted to remove the sequence.
//
//        Assumptions
//
//        There could be duplicate characters in the original set.
//
//        Examples
//
//        Set = "abc", all the subsets are ["", "a", "ab", "abc", "ac", "b", "bc", "c"]
//        Set = "abb", all the subsets are ["", "a", "ab", "abb", "b", "bb"]
//        Set = "abab", all the subsets are ["", "a", "aa","aab", "aabb", "ab","abb","b", "bb"]
//        Set = "", all the subsets are [""]
//        Set = null, all the subsets are []

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubsetsII {
    public List<String> subSets(String set) {
        List<String> ans = new ArrayList<>();
        if (set == null) {
            return ans;
        }
        char[] arr = set.toCharArray();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        dfs(arr, sb, 0, ans);
        return ans;
    }

    private void dfs(char[] arr, StringBuilder sb, int index, List<String> ans) {
        // base case
        if (index == arr.length) {
            ans.add(sb.toString());
            return;
        }

        // add
        sb.append(arr[index]);
        dfs(arr, sb, index + 1, ans);
        sb.deleteCharAt(sb.length() - 1);

        // skip
        while (index < arr.length - 1 && arr[index] == arr[index + 1]) {
            index++;
        }
        dfs(arr, sb, index + 1, ans);
    }

//    private void dfs(String set, StringBuilder sb, int index, List<String> ans) {
//        // base case
//        if (index == set.length()) {
//            ans.add(sb.toString());
//            return;
//        }
//
//        // add
//        sb.append(set.charAt(index));
//        dfs(set, sb, index + 1, ans);
//        sb.deleteCharAt(sb.length() - 1);
//
//        // skip
//        while (index < set.length() - 1 && set.charAt(index) == set.charAt(index + 1)) {
//            index++;
//        }
//        dfs(set, sb, index + 1, ans);
//    }

    public static void main(String[] args) {
        String set = "abab";
        AllSubsetsII test = new AllSubsetsII();
        List<String> ans = test.subSets(set);
        System.out.println(ans);
    }
}
