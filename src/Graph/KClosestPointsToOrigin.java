package Graph;

/*
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

        The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

        You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
*/

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class KClosestPointsToOrigin {
//    // approach 1 - PriorityQueue (maxHeap) TC: O(nlogk) SC: O(k)
//    public int[][] kClosest(int[][] points, int k) {
//        // maxHeap
////        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));
//        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> dis(b) - dis(a));
//
//        // iteration
//        for (int i = 0; i < points.length; i++) {
//            // check
//            if (maxHeap.size() < k) {
//                maxHeap.offer(points[i]);
//            } else if (dis(maxHeap.peek()) > dis(points[i])) {
//                maxHeap.poll();
//                maxHeap.offer(points[i]);
//            }
//        }
//
//        // populate
//        int[][] res = new int[k][2];
//        int[] point;
//        for (int i = 0; i < k; i++) {
//            res[i] = maxHeap.poll();
//        }
//        return res;
//    }

    private int dis(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    Random random = new Random();

    // approach 2 - QuickSort TC: O(n) SC: O(logn)
    public int[][] kClosest(int[][] points, int k) {
        // quick sort
        quickSort(points, 0, points.length - 1, k);
        return Arrays.copyOfRange(points, 0, k);
    }

    private void quickSort(int[][] points, int left, int right, int k) {
        // edge case
        if (left > points.length || right < 0 || left >= right) {
            return;
        }

        int pivot = partition(points, left, right);

        // check
        if (k < pivot - left + 1) {
            quickSort(points, left, pivot - 1, k);
        } else if (k > pivot - left + 1) {
            quickSort(points, pivot + 1, right, k - (pivot - left + 1));
        }
    }

    private int partition(int[][] points, int left, int right) {
        int pivot = left + random.nextInt(right - left + 1);
        swap(points, pivot, right);
        pivot = dis(points[right]);
        for (int i = left; i < right; i++) {
            if (dis(points[i]) <= pivot) {
                swap(points, i, left++);
            }
        }
        swap(points, left, right);
        return left;
    }

    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }

    public static void main(String[] args) {
        KClosestPointsToOrigin test = new KClosestPointsToOrigin();
        int[][] points = new int[][]{{3, 3}, {5, -1},{-2, 4}};
        int[][] res = test.kClosest(points, 2);
    }
}
