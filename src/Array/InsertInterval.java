package Array;

/*
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

        Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

        Return intervals after the insertion.
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InsertInterval {
    // approach 1 - Arrays TC: O(n) SC: O(n)
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new LinkedList<>();

        // precopy
        int i = 0;
        while (i < intervals.length && intervals[i][0] <= newInterval[0]) {
            res.add(intervals[i++]);
        }

        // merge with pre
        if (!res.isEmpty() && res.get(res.size() - 1)[1] >= newInterval[0]) {
            res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], newInterval[1]);
        } else {
            res.add(newInterval);
        }

        // merge with post
        int maxEnd = res.get(res.size() - 1)[1];
        while (i < intervals.length && maxEnd >= intervals[i][0]) {
            i++;
        }
        if (i > 0) {
            res.get(res.size() - 1)[1] = Math.max(maxEnd, intervals[i - 1][1]);
        }

        // postcopy
        while (i < intervals.length) {
            res.add(intervals[i++]);
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        InsertInterval test = new InsertInterval();
        int[][] intervals = new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[][] res = test.insert(intervals, new int[]{4, 8});
    }
}
