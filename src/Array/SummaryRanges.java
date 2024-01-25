package Array;

/*
LeetCode 228

You are given a sorted unique integer array nums.

        A range [a,b] is the set of all integers from a to b (inclusive).

        Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

        Each range [a,b] in the list should be output as:

        "a->b" if a != b
        "a" if a == b
*/

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    // approach 1: Arrays TC: O(n) SC: O(1)
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();

        // edge case
        if (nums.length == 0) {
            return res;
        }

        // init
        int start = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // check consecutive
            // case 1: consecutive
            // case 2: non consecutive
            if (nums[i - 1] + 1 != nums[i]) {
                res.add(constructRange(start, nums[i - 1]));
                start = nums[i];
            }
        }

        // add the last range
        res.add(constructRange(start, nums[nums.length - 1]));
        return res;
    }

    private String constructRange(int a, int b) {
        // check range
        // case 1: a == b
        // case 2: a != b
        if (a == b) {
            return Integer.toString(a);
        } else {
            return a + "->" + b;
        }
    }

    public static void main(String[] args) {
        SummaryRanges test = new SummaryRanges();
        int[] arr = new int[]{0, 1, 2, 4, 5, 7};
        System.out.println(test.summaryRanges(arr).toString());
    }
}
