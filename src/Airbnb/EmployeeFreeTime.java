package Airbnb;

/*
We are given a list schedule of employees, which represents the working time for each employee.

        Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.

        Return the list of finite intervals representing common, positive-length free time for all employees, also in sorted order.

        (Even though we are representing Intervals in the form [x, y], the objects inside are Intervals, not lists or arrays. For example, schedule[0][0].start = 1, schedule[0][0].end = 2, and schedule[0][0][0] is not defined).  Also, we wouldn't include intervals like [5, 5] in our answer, as they have zero length.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class EmployeeFreeTime {
    public class Interval {
        public int start;
        public int end;

        public Interval() {}

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    };

    // approach 1 - PriorityQueue TC: O(nlogk) SC: O(k)
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> schedule.get(a[0]).get(a[1]).start - schedule.get(b[0]).get(b[1]).start);

        // initialization
        for (int i = 0; i < schedule.size(); i++) {
            pq.offer(new int[]{i, 0});
        }

        int prev = schedule.get(pq.peek()[0]).get(pq.peek()[1]).start;
        while (!pq.isEmpty()) {
            int[] entry = pq.poll();
            Interval interval = schedule.get(entry[0]).get(entry[1]);

            // add free interval
            if (interval.start > prev) {
                res.add(new Interval(prev, interval.start));
            }

            // update last end time
            prev = Math.max(prev, interval.end);

            // offer next interval for this employee
            if (entry[1] + 1 < schedule.get(entry[0]).size()) {
                pq.offer(new int[]{entry[0], entry[1] + 1});
            }
        }
        return res;
    }
}
