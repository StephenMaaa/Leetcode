package Array;

/*
Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.
*/

import java.util.Arrays;

public class MeetingRooms {
    // approach 1 - Greedy TC: O(nlogn) SC: O(logn)
    public boolean canAttendMeetings(int[][] intervals) {
        // sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // check overlaps
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MeetingRooms test = new MeetingRooms();
        int[][] intervals = new int[][]{{0, 5}, {15, 20}};
        System.out.println(test.canAttendMeetings(intervals));
    }
}
