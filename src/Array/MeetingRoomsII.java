package Array;

/*
LeetCode 253

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

    // approach 2: Intervals TC: O(n) SC: O(n)
    public int minMeetingRooms2(int[][] intervals) {
        // get max
        int max = 0;
        for (int i = 0; i < intervals.length; i++) {
            max = Math.max(intervals[i][1], max);
        }

        // create count arr of meetings
        int[] countArr = new int[max + 1];
        for (int[] interval : intervals) {
            countArr[interval[0]]++;
            countArr[interval[1]]--;
        }

        // find max sum
        int sum = 0;
        int maxSum = 0;
        for (int i = 0; i < countArr.length; i++) {
            sum += countArr[i];

            // update
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MeetingRoomsII test = new MeetingRoomsII();
        int[][] intervals = new int[][]{{0, 30}, {15, 20}};
        System.out.println(test.minMeetingRooms2(intervals));
    }
}
