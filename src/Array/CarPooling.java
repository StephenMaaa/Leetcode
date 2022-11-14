package Array;

/*
There is a car with capacity empty seats. The vehicle only drives east (i.e., it cannot turn around and drive west).

        You are given the integer capacity and an array trips where trips[i] = [numPassengersi, fromi, toi] indicates that the ith trip has numPassengersi passengers and the locations to pick them up and drop them off are fromi and toi respectively. The locations are given as the number of kilometers due east from the car's initial location.

        Return true if it is possible to pick up and drop off all passengers for all the given trips, or false otherwise.
*/

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class CarPooling {
//    // approach 1 - Greedy + PriorityQueue (minHeap) TC: O(nlogn) SC: O(n)
//    public boolean carPooling(int[][] trips, int capacity) {
//        // greedy: smallest max (earliest end)
//
//        // sort by start location
//        Arrays.sort(trips, (a, b) -> a[1] - b[1]);
//
//        // maintain a minHeap of end location
//        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
//        for (int i = 0; i < trips.length; i++) {
//            // offload
//            while (!minHeap.isEmpty() && minHeap.peek()[2] <= trips[i][1]) {
//                capacity += minHeap.poll()[0];
//            }
//
//            capacity -= trips[i][0];
//            // check
//            if (capacity < 0) {
//                return false;
//            }
//            minHeap.offer(trips[i]);
//        }
//        return true;
//    }

    // approach 2 - Greedy + TreeMap TC: O(nlogn) SC: O(n)
    public boolean carPooling(int[][] trips, int capacity) {
        // greedy: smallest max (earliest end)

        // maintain a treeMap
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < trips.length; i++) {
            map.put(trips[i][1], map.getOrDefault(trips[i][1], 0) + trips[i][0]);
            map.put(trips[i][2], map.getOrDefault(trips[i][2], 0) - trips[i][0]);
        }

        // populate
        for (int num : map.values()) {
            capacity -= num;

            // check
            if (capacity < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CarPooling test = new CarPooling();
        int[][] trips = new int[][]{{2, 1, 5}, {3, 3, 7}};
        System.out.println(test.carPooling(trips, 6));
    }
}
