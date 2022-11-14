package DFS;

import java.util.ArrayList;
import java.util.List;

public class AllSubsets {
    public List<String> subSets(String set) {
        List<String> ans = new ArrayList<>();
        if (set == null) {
            return ans;
        }
        StringBuilder str = new StringBuilder();
        dfs(set, str, 0, ans);
        return ans;
    }

    private void dfs(String set, StringBuilder str, int index, List<String> list) {
        // base case
        if (index == set.length()) {
            list.add(str.toString());
            return;
        }

        // skip
        dfs(set, str, index + 1, list);

        // add
        str.append(set.charAt(index));
        dfs(set, str, index + 1, list);
        str.deleteCharAt(str.length() - 1);
    }

    public static void main(String[] args) {
        String set = "abc";
        AllSubsets test = new AllSubsets();
        List<String> ans = test.subSets(set);
        System.out.println(ans);
    }
}
