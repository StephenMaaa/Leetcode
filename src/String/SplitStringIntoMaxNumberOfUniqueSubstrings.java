package String;

/*
Given a string s, return the maximum number of unique substrings that the given string can be split into.

        You can split string s into any list of non-empty substrings, where the concatenation of the substrings forms the original string. However, you must split the substrings such that all of them are unique.

        A substring is a contiguous sequence of characters within a string.
*/

import java.util.HashSet;
import java.util.Set;

public class SplitStringIntoMaxNumberOfUniqueSubstrings {
    // approach 1 - Set TC: O(k^n) SC: O(k)
    public int maxUniqueSplit(String s) {
        Set<String> set = new HashSet<>();
        int[] max = new int[1];
        dfs(set, s, 0, max);
        return max[0];
    }

    private void dfs(Set<String> set, String s, int index, int[] max) {
        // base case
        if (index == s.length()) {
            max[0] = Math.max(max[0], set.size());
            return;
        }

        // recursive case
        for (int i = index; i < s.length(); i++) {
            String str = s.substring(index, i + 1);

            // check
            if (!set.contains(str)) {
                set.add(str);
                dfs(set, s, i + 1, max);
                set.remove(str);
            }
        }
    }

    public static void main(String[] args) {
        SplitStringIntoMaxNumberOfUniqueSubstrings test = new SplitStringIntoMaxNumberOfUniqueSubstrings();
        System.out.println(test.maxUniqueSplit("wwwzfvedwfvhsww"));
    }
}
