package DFS;

/*
Given an integer k, arrange the sequence of integers [1, 1, 2, 2, 3, 3, ...., k - 1, k - 1, k, k], such that the output integer array satisfy this condition:

        Between each two i's, they are exactly i integers (for example: between the two 1s, there is one number, between the two 2's there are two numbers).

        If there does not exist such sequence, return null.

        Assumptions:

        k is guaranteed to be > 0
        Examples:

        k = 3, The output = { 2, 3, 1, 2, 1, 3 }.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeepDistanceForIdenticalElements {
    public int[] keepDistance(int k) {
//        List<List<Integer>> ans = new ArrayList<>();
        int[] ans = new int[2 * k];
        int[] arr = new int[2 * k];
        dfs(arr, 1, k, ans);
        return ans[0] == 0 ? null : ans;
    }

    private void dfs(int[] arr, int index, int k, int[] list) {
        // base case
        if (index == k + 1) {
//            System.out.println(Arrays.toString(arr));
//            list = Arrays.copyOf(arr, arr.length);
            for (int i = 0; i < arr.length; i++) {
                list[i] = arr[i];
            }
//            System.out.println(Arrays.toString(list));
            return;
        }

        for (int i = 0; i < arr.length - index - 1; i++) {
            // check availability
            if (arr[i] == 0 && arr[i + index + 1] == 0) {
                arr[i] = index;
                arr[i + index + 1] = index;
                dfs(arr, index + 1, k, list);
                arr[i] = 0;
                arr[i + index + 1] = 0;
            }
        }
    }

    public static void main(String[] args) {
        KeepDistanceForIdenticalElements test = new KeepDistanceForIdenticalElements();
        System.out.println(Arrays.toString(test.keepDistance(1)));
    }
}
