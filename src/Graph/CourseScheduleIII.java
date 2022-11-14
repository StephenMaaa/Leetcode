package Graph;

/*
There are n different online courses numbered from 1 to n. You are given an array courses where courses[i] = [durationi, lastDayi] indicate that the ith course should be taken continuously for durationi days and must be finished before or on lastDayi.

        You will start on the 1st day and you cannot take two or more courses simultaneously.

        Return the maximum number of courses that you can take.
*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CourseScheduleIII {
//    // approach 1 - Greedy TC: O(nlogn) SC: O(n)
//    public int scheduleCourse(int[][] courses) {
//        // strategy: always choose the course with the latest beginning day (largest min)
//        // priority queue to dynamically maintaining the order
//        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if ((o2[1] - o2[0]) == (o1[1] - o1[0])) {
//                    return o2[1] - o1[1];
//                }
//                return (o2[1] - o2[0]) - (o1[1] - o1[0]);
//            }
//        });
//
//        for (int[] course : courses) {
//            // add valid course only
//            if (course[0] <= course[1]) {
//                pq.offer(course);
//            }
//        }
//
//        int xMax = Integer.MAX_VALUE;
//        int count = 0;
//        while (!pq.isEmpty()) {
//            int[] course = pq.poll();
//
//            // case 1: xMax >= y - interval
//            // case 2: otherwise
//            if (xMax >= course[1]) {
//                xMax = course[1] - course[0];
//                count++;
//            } else {
//                course[1] = xMax;
//
//                // add valid course only
//                if (course[0] <= course[1]) {
//                    pq.offer(course);
//                }
//            }
//        }
//        return count;
//    }

    // approach 1 - Greedy TC: O(nlogn) SC: O(n)
    public int scheduleCourse(int[][] courses) {
        // strategy: always choose the course with the earliest ending day (smallest max)
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);

        // priority queue to dynamically maintaining the order
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        int x = 0;
        for (int[] course : courses) {
            // case 1: x + t <= d
            // case 2: selected course with max interval is replaceable
            if (x + course[0] <= course[1]) {
                pq.offer(course);
                x += course[0];
            } else if (!pq.isEmpty() && pq.peek()[0] > course[0]) {
                x -= pq.poll()[0] - course[0];
                pq.offer(course);
            }
        }
        return pq.size();
    }

    public static void main(String[] args) {
        CourseScheduleIII test = new CourseScheduleIII();
        int[][] courses = new int[][]{{9, 14}, {7, 12}, {1, 11}, {4, 7}};
//        int[][] courses = new int[][]{{1, 2}, {2, 3}};
        System.out.println(test.scheduleCourse(courses));
    }
}