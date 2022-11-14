package Array;

/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    // approach 1 - Sort TC: O(nlogn) SC: O(n)
    public int[][] merge(int[][] intervals) {
        // sort based on the first dimension (start)
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> list = new ArrayList<>();
        int i = 0;
        while (i < intervals.length) {
            int[] interval = intervals[i];

            // merge all intervals
            while (i < intervals.length - 1 && interval[1] >= intervals[i + 1][0]) {
                interval[1] = Math.max(interval[1], intervals[i + 1][1]);
                i++;
            }
            list.add(interval);
            i++;
        }

        // process result
//        int[][] res = new int[list.size()][2];
//        i = 0;
//        for (int[] interval : list) {
//            res[i++] = interval;
//        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervals test = new MergeIntervals();
        int[][] intervals = new int[][]{{1, 4}, {4, 6}};
        int[][] res = test.merge(intervals);
    }
}
