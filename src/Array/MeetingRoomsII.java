package Array;

/*
Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.
*/

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    // approach 1 - Greedy + PriorityQueue (minHeap) TC: O(nlogn) SC: O(n)
    public int minMeetingRooms(int[][] intervals) {
        // greedy: smallest max (earliest end)

        // sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // maintain a minHeap by end time
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int i = 0; i < intervals.length; i++) {
            // check
            if (!minHeap.isEmpty() && minHeap.peek()[1] <= intervals[i][0]) {
                minHeap.poll();
            }
            minHeap.offer(intervals[i]);
        }
        return minHeap.size();
    }

    public static void main(String[] args) {
        MeetingRoomsII test = new MeetingRoomsII();
        int[][] intervals = new int[][]{{0, 30}, {15, 20}};
        System.out.println(test.minMeetingRooms(intervals));
    }
}
