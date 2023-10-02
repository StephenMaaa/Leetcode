package DP;

/*
LeetCode 134

There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].

        You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.

        Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique



        Example 1:

        Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
        Output: 3
        Explanation:
        Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
        Travel to station 4. Your tank = 4 - 1 + 5 = 8
        Travel to station 0. Your tank = 8 - 2 + 1 = 7
        Travel to station 1. Your tank = 7 - 3 + 2 = 6
        Travel to station 2. Your tank = 6 - 4 + 3 = 5
        Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
        Therefore, return 3 as the starting index.
        Example 2:

        Input: gas = [2,3,4], cost = [3,4,3]
        Output: -1
        Explanation:
        You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
        Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
        Travel to station 0. Your tank = 4 - 3 + 2 = 3
        Travel to station 1. Your tank = 3 - 3 + 3 = 3
        You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
        Therefore, you can't travel around the circuit once no matter where you start.
*/

import java.util.PriorityQueue;

public class GasStation {
//    // approach 1 - Linear Scan TC: O(n^2) SC: O(1)
//    public int canCompleteCircuit(int[] gas, int[] cost) {
//        for (int i = 0; i < gas.length; i++) {
//            if (traverse(gas, cost, i)) {
//                return i;
//            }
//        }
//        return -1;
//    }
//
//    private boolean traverse(int[] gas, int[] cost, int start) {
//        // base case
//        if (gas[start] - cost[start] < 0) {
//            return false;
//        }
//
//        // traverse
//        int net = 0;
//        for (int i = 0; i < gas.length; i++) {
//            int index = (start + i) % gas.length;
//            net += gas[index] - cost[index];
//
//            // check
//            if (net < 0) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    // approach 2 - Greedy TC: O(n^2) SC: O(n)
//    public int canCompleteCircuit2(int[] gas, int[] cost) {
//        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
//        for (int i = 0; i < gas.length; i++) {
//            if (gas[i] - cost[i] >= 0) {
//                pq.offer(new int[]{i, gas[i] - cost[i]});
//            }
//        }
//
//        // traverse the index with the largest net value
//        while (!pq.isEmpty()) {
//            int index = pq.poll()[0];
//            if (traverse(gas, cost, index)) {
//                return index;
//            }
//        }
//        return -1;
//    }
//
//    // approach 3 - Linear Scan TC: O(n) SC: O(1)
//    public int canCompleteCircuit3(int[] gas, int[] cost) {
//        int i = 0;
//        while (i < gas.length) {
//            // traverse
//            int net = 0;
//            int count = 0;
//            while (count < gas.length) {
//                int index = (i + count) % gas.length;
//                net += gas[index] - cost[index];
//
//                // check
//                if (net < 0) {
//                    break;
//                }
//                count++;
//            }
//
//            if (count == gas.length) {
//                return i;
//            }
//            i += count + 1;
//        }
//        return -1;
//    }
//
//    // approach 4 - Greedy TC: O(n) SC: O(1)
//    public int canCompleteCircuit4(int[] gas, int[] cost) {
//        int net = 0;
//        int curr = 0;
//        int start = 0;
//        for (int i = 0; i < gas.length; i++) {
//            curr += gas[i] - cost[i];
//            net += gas[i] - cost[i];
//            if (curr < 0) {
//                start = i + 1;
//                curr = 0;
//            }
//        }
//        return net < 0 ? -1 : start % gas.length;
//    }

    // approach 1: Linear Scan TC: O(n^2) SC: O(1)
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            // check
            if (traverse(i, gas, cost)) {
                return i;
            }
        }
        return -1;
    }

    private boolean traverse(int start, int[] gas, int[] cost) {
        int net = 0;
        for (int i = 0; i < gas.length; i++) {
            int index = (i + start) % gas.length;
            net += gas[index] - cost[index];

            // check
            if (net < 0) {
                return false;
            }
        }
        return true;
    }

    // approach 2: Greedy TC: O(n) SC: O(1)
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int curr = 0;
        int net = 0;
        for (int i = 0; i < gas.length; i++) {
            curr += gas[i] - cost[i];
            net += gas[i] - cost[i];

            // check
            if (curr < 0) {
                start = i + 1;
                curr = 0;
            }
        }
        return net >= 0 ? start : -1; 
    }

    public static void main(String[] args) {
        GasStation test = new GasStation();
        int[] gas = new int[]{1, 2, 3, 4, 5};
        int[] cost = new int[]{3, 4, 5, 1, 2};
        System.out.println(test.canCompleteCircuit(gas, cost));
    }
}
