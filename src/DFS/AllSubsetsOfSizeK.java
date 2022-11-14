package DFS;

/*
Given a set of characters represented by a String, return a list containing all subsets of the characters whose size is K.

        Assumptions

        There are no duplicate characters in the original set.

        ​Examples

        Set = "abc", K = 2, all the subsets are [“ab”, “ac”, “bc”].

        Set = "", K = 0, all the subsets are [""].

        Set = "", K = 1, all the subsets are [].
*/

import java.util.ArrayList;
import java.util.List;

public class AllSubsetsOfSizeK {
    public List<String> subSetsOfSizeK(String set, int k) {
        List<String> ans = new ArrayList<>();
        if (set == null) {
            return ans;
        }
        StringBuilder sb = new StringBuilder();
        dfs(set, sb, 0, k, ans);
        return ans;
    }

    private void dfs(String str, StringBuilder sb, int index, int k, List<String> list) {
        // base case
        if (sb.length() == k) {
            list.add(sb.toString());
            return;
        }

        if (index == str.length()) {
            return;
        }

        // add
        sb.append(str.charAt(index));
        dfs(str, sb, index + 1, k, list);
        sb.deleteCharAt(sb.length() - 1);

        // skip
        dfs(str, sb, index + 1, k, list);
    }

    public static void main(String[] args) {
        String set = "";
        AllSubsetsOfSizeK test = new AllSubsetsOfSizeK();
        List<String> ans = test.subSetsOfSizeK(set, 1);
        System.out.println(ans.size());
    }
}
