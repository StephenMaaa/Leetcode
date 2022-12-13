package Airbnb;

/*
We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].

        You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.

        If you choose a job that ends at time X you will be able to start another job that starts at time X.
*/

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaxProfitInJobScheduling {
    // approach 1 - Greedy + PriorityQueue TC: O(nlogn) SC: O(n)
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int[startTime.length][3];
        for (int i = 0; i < jobs.length; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        // greedy: earliest start
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        // greedy: earliest end
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int maxProfit = 0;
        for (int i = 0; i < jobs.length; i++) {
            while (!pq.isEmpty() && jobs[i][0] >= pq.peek()[1]) {
                maxProfit = Math.max(maxProfit, pq.poll()[2]);
            }

            pq.offer(new int[]{jobs[i][0], jobs[i][1], jobs[i][2] + maxProfit});
        }

        // get max
        while (!pq.isEmpty()) {
            maxProfit = Math.max(maxProfit, pq.poll()[2]);
        }
        return maxProfit;
    }
}
