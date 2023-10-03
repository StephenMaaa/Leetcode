package Array;

/*
LeetCode 338

Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
*/

import java.util.Arrays;

public class CountingBits {
    // approach 1: Bit Operations TC: O(nlogn) SC: O(1)
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            res[i] = count(i);
        }
        return res;
    }

    private int count(int i) {
        int count = 0;
        while (i != 0) {
            count += i & 1;
            i >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        CountingBits test = new CountingBits();
        System.out.println(Arrays.toString(test.countBits(5)));
    }
}
