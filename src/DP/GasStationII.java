package DP;

/*
Min Cost
*/

public class GasStationII {
    // approach 1 - Greedy TC: O(n) SC: O(1)
    public int minCost(int[] distance, int[] cost) {
        int min = 0;
        int price = cost[0];
        for (int i = 0; i < distance.length - 1; i++) {
            min += price * (distance[i + 1] - distance[i]);

            // update min price
            if (cost[i + 1] < price) {
                price = cost[i + 1];
            }
        }
        return min;
    }

    // approach 1 - Greedy TC: O(n) SC: O(1)
    public int minCost2(int[] distance, int[] cost) {
        int min = 0;
        int price = Integer.MAX_VALUE;
        for (int i = 0; i < distance.length - 1; i++) {
            // update min price
            if (cost[i + 1] < price) {
                price = cost[i];
            }

            min += price * (distance[i + 1] - distance[i]);
        }
        return min;
    }
}
