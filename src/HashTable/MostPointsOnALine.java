package HashTable;

/*
Given an array of 2D coordinates of points (all the coordinates are integers), find the largest number of points that can be crossed by a single line in 2D space.

        Assumptions

        The given array is not null and it has at least 2 points
        Examples

<0, 0>, <1, 1>, <2, 3>, <3, 3>, the maximum number of points on a line is 3(<0, 0>, <1, 1>, <3, 3> are on the same line)
*/

import javafx.util.Pair;

import java.util.*;

public class MostPointsOnALine {
    public int most(Point[] points) {
        Map<Double, Map<Double, Set<Point>>> map = new HashMap<>();

        // check all pairs of Points
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                // edge case
                double slope;
                double b;
                if (points[i].x == points[j].x) {
                    slope = Integer.MAX_VALUE;
                    b = points[i].x;
                } else {
                    slope = (points[j].y - points[i].y + 0.0) / (points[j].x - points[i].x);
                    b = points[i].y - slope * points[i].x;
                }

                if (!map.containsKey(slope)) {
                    map.put(slope, new HashMap<>());
                    map.get(slope).put(b, new HashSet<>());
                } else if (!map.get(slope).containsKey(b)) {
                    map.get(slope).put(b, new HashSet<>());
                }

                map.get(slope).get(b).add(points[i]);
                map.get(slope).get(b).add(points[j]);
            }
        }

        // find max size
        int max = -1;
        for (Map<Double, Set<Point>> subMap : map.values()) {
            for (Set<Point> set : subMap.values()) {
                max = Math.max(max, set.size());
            }
        }

        return max;
    }

    // approach 1 - Map TC: O(n^2) SC: O(n^2)
    public int maxPoints(int[][] points) {
        Map<Pair<Double, Double>, Set<Integer>> map = new HashMap<>();

        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                // ax + b = y
                double a = 0;
                double b = 0;

                // calculate slope and intercept
                if (points[j][0] == points[i][0]) {
                    a = Integer.MAX_VALUE;
                    b = points[i][0];
                } else {
                    a = (points[j][1] - points[i][1] + 0.0) / (points[j][0] - points[i][0]);
                    b = points[i][1] - a * points[i][0];
                }
                Pair<Double, Double> line = new Pair<>(a, b);

                // update map
                if (!map.containsKey(line)) {
                    map.put(line, new HashSet<>());
                }
                map.get(line).add(i);
                map.get(line).add(j);
            }
        }

        // process
        int max = 1;
        for (Pair<Double, Double> line : map.keySet()) {
            max = Math.max(max, map.get(line).size());
        }
        return max;
    }

    public static void main(String[] args) {
        MostPointsOnALine test = new MostPointsOnALine();
        Point a = new Point(0, 0);
        Point b = new Point(1, 1);
        Point c = new Point(2, 3);
        Point d = new Point(3, 3);
        Point e = new Point(3, 4);
        Point f = new Point(3, 5);
        Point g = new Point(3, 6);
        Point[] arr = new Point[]{a, b, c, d, e, f, g};
        System.out.println(test.most(arr));
    }
}
