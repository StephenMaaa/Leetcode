package DP;

/*
Given an array containing only 0s and 1s, find the length of the longest subarray of consecutive 1s.

        Assumptions

        The given array is not null
        Examples

        {0, 1, 0, 1, 1, 1, 0}, the longest consecutive 1s is 3.
*/

public class LongestConsecutive1s {
    public int longest(int[] array) {
        int max = 0;
        int curr = 0;
        for (int i = 0; i < array.length; i++) {
            curr = array[i] == 0 ? 0 : curr + 1;
            max = Math.max(max, curr);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestConsecutive1s test = new LongestConsecutive1s();
        int[] arr = new int[]{1};
        System.out.println(test.longest(arr));
    }
}
