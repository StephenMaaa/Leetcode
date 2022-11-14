package DFS;

/*
Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.

        Notice that you can not jump outside of the array at any time.
*/

public class JumpGameIII {
//    // approach 1 - DFS TC: O(2^n) SC: O(n)
//    public boolean canReach(int[] arr, int start) {
//        boolean[] flag = new boolean[1];
//        boolean[] visited = new boolean[arr.length];
//        dfs(arr, start, visited, flag);
//        return flag[0];
//    }
//
//    public void dfs(int[] arr, int index, boolean[] visited, boolean[] flag) {
//        // base case
//        if (arr[index] == 0) {
//            flag[0] = true;
//            return;
//        }
//
//        // recursive case
//        int left = index - arr[index];
//        int right = index + arr[index];
//        if (!flag[0] && left >= 0 && !visited[left]) {
//            visited[left] = true;
//            dfs(arr, left, visited, flag);
//            visited[left] = false;
//        }
//
//        if (!flag[0] && right < arr.length && !visited[right]) {
//            visited[right] = true;
//            dfs(arr, right, visited, flag);
//            visited[right] = false;
//        }
//    }

    // approach 2 - DFS TC: O(n) SC: O(n)
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return dfs(arr, start, visited);
    }

    public boolean dfs(int[] arr, int index, boolean[] visited) {
        // base case
        if (index < 0 || index >= arr.length || visited[index]) {
            return false;
        }

        if (arr[index] == 0) {
            return true;
        }

        // recursive case
        visited[index] = true;
        return dfs(arr, index - arr[index], visited) || dfs(arr, index + arr[index], visited);
    }

    public static void main(String[] args) {
        JumpGameIII test = new JumpGameIII();
        int[] arr = new int[]{3, 0, 2, 1, 2};
        System.out.println(test.canReach(arr, 2));
    }
}
