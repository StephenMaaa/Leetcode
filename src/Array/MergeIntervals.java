package Array;

/*
LeetCode 56

Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    // approach 1 - Sort TC: O(nlogn) SC: O(n)
    public int[][] merge2(int[][] intervals) {
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

    // approach 1: Sorting TC: O(nlogn) SC: O(n)
    public int[][] merge(int[][] intervals) {
        // sort by start time in ascending order
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> list = new ArrayList<>();
        int[] interval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            // check
            // case 1: inclusive
            // case 2: interaction
            // case 3: separate
//            if (interval[1] >= intervals[i][1]) {
//                continue;
//            } else if (interval[1] >= intervals[i][0]) {
//                interval[1] = intervals[i][1];
//            } else {
//                list.add(interval);
//                interval = intervals[i];
//            }

            if (interval[1] < intervals[i][0]) {
                list.add(interval);
                interval = intervals[i];
            } else {
                interval[1] = Math.max(interval[1], intervals[i][1]);
            }
        }

        // add last interval
        list.add(interval);

        // populate
        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        MergeIntervals test = new MergeIntervals();
        int[][] intervals = new int[][]{{1, 4}, {4, 6}};
        int[][] res = test.merge(intervals);
    }
}
