package DP;

/*
A car travels from a starting position to a destination which is target miles east of the starting position.

        There are gas stations along the way. The gas stations are represented as an array stations where stations[i] = [positioni, fueli] indicates that the ith gas station is positioni miles east of the starting position and has fueli liters of gas.

        The car starts with an infinite tank of gas, which initially has startFuel liters of fuel in it. It uses one liter of gas per one mile that it drives. When the car reaches a gas station, it may stop and refuel, transferring all the gas from the station into the car.

        Return the minimum number of refueling stops the car must make in order to reach its destination. If it cannot reach the destination, return -1.

        Note that if the car reaches a gas station with 0 fuel left, the car can still refuel there. If the car reaches the destination with 0 fuel left, it is still considered to have arrived.
*/

import java.util.Collections;
import java.util.PriorityQueue;

public class GasStationIII {
//    // approach 1 - 2D DP TC: O(n^2) SC: O(n^2)
//    public int minRefuelStops(int target, int startFuel, int[][] stations) {
//        // edge case
//        if (stations.length == 0) {
//            return startFuel >= target ? 0 : -1;
//        }
//
//        int[][] dp = new int[stations.length + 1][stations.length + 1];
//        dp[0][0] = startFuel;
//        dp[0][1] = startFuel;
//        for (int i = 0; i < stations.length; i++) {
//            for (int j = 0; j <= i; j++) {
//                dp[i + 1][j + 1] = Math.max(dp[i][j] + stations[i][1], dp[i][j + 1]);
//            }
//        }
//
//        // check
//        for (int j = 1; j <= stations.length; j++) {
//            if (dp[stations.length][j] >= target) {
//                return j;
//            }
//        }
//        return -1;
//    }

    // approach 2 - Greedy + PriorityQueue TC: O(nlogn) SC: O(n)
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int net = startFuel;
        int count = 0;
        int prev = 0;
        PriorityQueue<Integer> maxFuels = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < stations.length; i++) {
            // greedy algorithm: reach as far as possible under net fuel, or add max fuel from station within all reachable stations
            while (!maxFuels.isEmpty() && net < stations[i][0] - prev) {
                net += maxFuels.poll();
                count++;
            }

            if (net < stations[i][0] - prev) {
                return -1;
            }

            // update
            net -= stations[i][0] - prev;
            prev = stations[i][0];
            maxFuels.offer(stations[i][1]);
        }

        // check
        while (!maxFuels.isEmpty() && net < target - prev) {
            net += maxFuels.poll();
            count++;
        }
        return net >= target - prev ? count : -1;
    }

    public static void main(String[] args) {
        GasStationIII test = new GasStationIII();
        int[][] stations = new int[][]{{10, 60}, {20, 30}, {30, 30}, {60, 40}};
        System.out.println(test.minRefuelStops(100, 10, stations));
    }
}
