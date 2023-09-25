package DFS;

import java.util.ArrayList;
import java.util.List;

public class AllSubsets {
    public List<String> subSets2(String set) {
        List<String> ans = new ArrayList<>();
        if (set == null) {
            return ans;
        }
        StringBuilder str = new StringBuilder();
        dfs2(set, str, 0, ans);
        return ans;
    }

    private void dfs2(String set, StringBuilder str, int index, List<String> list) {
        // base case
        if (index == set.length()) {
            list.add(str.toString());
            return;
        }

        // skip
        dfs2(set, str, index + 1, list);

        // add
        str.append(set.charAt(index));
        dfs2(set, str, index + 1, list);
        str.deleteCharAt(str.length() - 1);
    }

    // approach 1: DFS TC: O(n^2) SC: O(n)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), res);
        return res; 
    }

    private void dfs(int[] nums, int index, List<Integer> list, List<List<Integer>> res) {
        // base case
        if (index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        // recursive case
        // case 1: add
        list.add(nums[index]);
        dfs(nums, index + 1, list, res);
        list.remove(list.size() - 1);

        // case 2: skip
        dfs(nums, index + 1, list, res);
    }

    public static void main(String[] args) {
//        String set = "abc";
        int[] arr = new int[]{1, 2, 3};
        AllSubsets test = new AllSubsets();
        List<List<Integer>> ans = test.subsets(arr);
        System.out.println(ans);
    }
}
