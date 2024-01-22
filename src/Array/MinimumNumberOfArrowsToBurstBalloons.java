package Array;

/*
LeetCode 452

There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are represented as a 2D integer array points where points[i] = [xstart, xend] denotes a balloon whose horizontal diameter stretches between xstart and xend. You do not know the exact y-coordinates of the balloons.

        Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis. A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend. There is no limit to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.

        Given the array points, return the minimum number of arrows that must be shot to burst all balloons.
*/

import java.util.Arrays;

public class MinimumNumberOfArrowsToBurstBalloons {
    // approach 1: Sliding Windows TC: O(nlogn) SC: O(logn)
    public int findMinArrowShots(int[][] points) {
        // sort
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        int min = points[0][0];
        int max = points[0][1];
        int count = 0;
        for (int i = 1; i < points.length; i++) {
            // check range
            // case 1: in range -> update range
            // case 2: out of range -> count++ and reset range
            if (points[i][0] > max) {
                count++;
                min = points[i][0];
                max = points[i][1];
            } else {
                min = Math.max(points[i][0], min);
                max = Math.min(points[i][1], max);
            }
        }
        return count + 1;
    }

    public static void main(String[] args) {
        MinimumNumberOfArrowsToBurstBalloons test = new MinimumNumberOfArrowsToBurstBalloons();
        int[][] arr = new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}};
        System.out.println(test.findMinArrowShots(arr));
    }
}
