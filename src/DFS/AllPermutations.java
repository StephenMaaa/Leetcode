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
//    public List<String> permutations(String input) {
//        // Write your solution here
//        List<String> ans = new ArrayList<>();
//        if (input == null) {
//            return ans;
//        }
//        char[] arr = input.toCharArray();
//        dfs(arr, 0, ans);
//        return ans;
//    }
//
//    private void dfs(char[] arr, int index, List<String> list) {
//        if (index == arr.length) {
//            list.add(new String(arr));
//            return;
//        }
//
//        // branch: all possible swap
//        for (int i = index; i < arr.length; i++) {
//            swap(arr, i, index);
//            dfs(arr, index + 1, list);
//            swap(arr, i, index);
//        }
//    }
//
//    private void swap(char[] arr, int i, int j) {
//        char temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }

//    // idea: DFS
//    // base case: index == n -> add arr to res
//    // recursive case: for loop over index -> swap current index with each -> recursive call -> swap back
//
//    // approach 1 - DFS TC: O(n!) SC: O(n!)
//    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        dfs2(nums, 0, res);
//        return res;
//    }
//
//    private void dfs2(int[] nums, int index, List<List<Integer>> res) {
//        // base case
//        if (index == nums.length) {
//            List<Integer> list = new ArrayList<>();
//            for (int i : nums) {
//                list.add(i);
//            }
//            res.add(list);
//            return;
//        }
//
//        // recursive case
//        for (int i = index; i < nums.length; i++) {
//            swap2(nums, i, index);
//            dfs2(nums, index + 1, res);
//            swap2(nums, i, index);
//        }
//    }
//
//    private void swap2(int[] nums, int i, int j) {
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }

    // approach 1: DFS TC: O(n!) SC: O(n!)
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, res);
        return res;
    }

    private void dfs(int[] nums, int index, List<List<Integer>> res) {
        // base case
        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i : nums) {
                list.add(i);
            }
            res.add(list);
            return;
        }

        // recursive case
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            dfs(nums, index + 1, res);
            swap(nums, i, index);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        AllPermutations test = new AllPermutations();
        int[] arr = new int[]{1, 2, 3};
//        List<String> ans = test.permutations("abc");
        System.out.println(test.permute(arr));
//        System.out.println(ans);
    }
}
