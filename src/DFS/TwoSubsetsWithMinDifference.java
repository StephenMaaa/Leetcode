package DFS;

/*
Given a set of n integers, divide the set in two subsets of n/2 sizes each such that the difference of the sum of two subsets is as minimum as possible.

        Return the minimum difference(absolute value).

        Assumptions:

        The given integer array is not null and it has length of >= 2.
        Examples:

        {1, 3, 2} can be divided into {1, 2} and {3}, the minimum difference is 0
*/

public class TwoSubsetsWithMinDifference {
    public int minDifference(int[] array) {
        int left = 0;
        int right = 0;
        int[] min = new int[1];
        min[0] = Integer.MAX_VALUE;
        dfs(array, left, right, 0, 0, 0, min);
        return min[0];
    }

    private void dfs(int[] array, int left, int right, int leftSize, int rightSize, int index, int[] min) {
        // base case
        if (index == array.length) {
            if (Math.abs(leftSize - rightSize) <= 1) {
                min[0] = Math.min(min[0], Math.abs(left - right));
            }
            return;
        }

        dfs(array, left + array[index], right, leftSize + 1, rightSize, index + 1, min);
        dfs(array, left, right + array[index], leftSize, rightSize + 1, index + 1, min);
    }

    public static void main(String[] args) {
        TwoSubsetsWithMinDifference test = new TwoSubsetsWithMinDifference();
        int[] arr = new int[]{1, 3, 2};
        System.out.println(test.minDifference(arr));
    }
}
