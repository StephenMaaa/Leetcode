package Graph;

/*
You are given two integers, x and y, which represent your current location on a Cartesian grid: (x, y). You are also given an array points where each points[i] = [ai, bi] represents that a point exists at (ai, bi). A point is valid if it shares the same x-coordinate or the same y-coordinate as your location.

        Return the index (0-indexed) of the valid point with the smallest Manhattan distance from your current location. If there are multiple, return the valid point with the smallest index. If there are no valid points, return -1.

        The Manhattan distance between two points (x1, y1) and (x2, y2) is abs(x1 - x2) + abs(y1 - y2).
*/

public class FindNearestPointThatHasTheSameXOrYCoordinate {
    // approach 1 - Arrays TC: O(n) SC: O(1)
    public int nearestValidPoint(int x, int y, int[][] points) {
        int minIndex = -1;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < points.length; i++) {
            // check the same X or Y coordinate
            if (points[i][0] == x || points[i][1] == y) {
                int dis = Math.abs(points[i][0] - x + points[i][1] - y);

                // update
                if (dis == 0) {
                    return i;
                } else if (minDiff > dis) {
                    minIndex = i;
                    minDiff = dis;
                }
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        FindNearestPointThatHasTheSameXOrYCoordinate test = new FindNearestPointThatHasTheSameXOrYCoordinate();
        int[][] points = new int[][]{{3, 4}};
        System.out.println(test.nearestValidPoint(3, 4, points));
    }
}
