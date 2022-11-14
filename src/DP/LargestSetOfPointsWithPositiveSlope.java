package DP;

/*
Given an array of 2D coordinates of points (all the coordinates are integers), find the largest number of points that can form a set such that any pair of points in the set can form a line with positive slope. Return the size of such a maximal set.

        Assumptions

        The given array is not null
        Note: if there does not even exist 2 points can form a line with positive slope, should return 0.
        Examples

<0, 0>, <1, 1>, <2, 3>, <3, 3>, the maximum set of points are {<0, 0>, <1, 1>, <2, 3>}, the size is 3.
*/

import java.util.Arrays;
import java.util.Comparator;

public class LargestSetOfPointsWithPositiveSlope {
    public int largest(Point[] points) {
        // edge case
        if (points == null || points.length == 0) {
            return 0;
        }

        // sort Points in increasing x-coordinates
//        Arrays.sort(points, (Point a, Point b) -> a.x - b.x);
        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.x - o2.x;
            }
        });

        // find the longest ascending subsequence of y-coordinates
        int globalMax = 0;
        int[] maxArr = new int[points.length];
        Arrays.fill(maxArr, 1);

        for (int i = 1; i < points.length; i++) {
            for (int j = 0; j < i; j++) {
                if (points[j].x < points[i].x && points[j].y < points[i].y) {
                    maxArr[i] = Math.max(maxArr[i], maxArr[j] + 1);
                }
            }
            globalMax = Math.max(globalMax, maxArr[i]);
        }
        return globalMax == 1 ? 0 : globalMax;
    }

    public static void main(String[] args) {
        LargestSetOfPointsWithPositiveSlope test = new LargestSetOfPointsWithPositiveSlope();
        Point a = new Point(0, 10);
        Point b = new Point(1, 1);
        Point c = new Point(1, 3);
        Point d = new Point(3, 3);
        Point[] arr = new Point[]{b, c};
        System.out.println(test.largest(arr));
    }
}
