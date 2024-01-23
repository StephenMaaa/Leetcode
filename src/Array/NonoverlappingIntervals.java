package Array;

/*
LeetCode 435

Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
*/

import java.util.Arrays;

public class NonoverlappingIntervals {
    // approach 1: Sorting and Intervals TC: O(nlogn) SC: O(logn)
    public int eraseOverlapIntervals(int[][] intervals) {
        // sort
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int end = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            // check intervals
            // case 1: nonoverlap interval[0] >= end -> update end
            // case 2: overlap interval[0] < end -> remove and update count
            if (interval[0] >= end) {
                end = interval[1];
            } else {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NonoverlappingIntervals test = new NonoverlappingIntervals();
        int[][] arr = new int[][]{{1, 2}, {1, 2}, {1, 2}};
        System.out.println(test.eraseOverlapIntervals(arr));
    }
}
