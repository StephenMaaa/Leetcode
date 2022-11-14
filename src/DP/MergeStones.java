package DP;

/*
We have a list of piles of stones, each pile of stones has a certain weight, represented by an array of integers. In each move, we can merge two adjacent piles into one larger pile, the cost is the sum of the weights of the two piles. We merge the piles of stones until we have only one pile left. Determine the minimum total cost.

        Assumptions

        stones is not null and is length of at least 1
        Examples

        {4, 3, 3, 4}, the minimum cost is 28

        merge first 4 and first 3, cost 7

        merge second 3 and second 4, cost 7

        merge two 7s, cost 14

        total cost = 7 + 7 + 14 = 28
*/

import com.sun.scenario.effect.Merge;

import java.util.Arrays;

public class MergeStones {
    public int minCost(int[] stones) {
        int[][] minCosts = new int[stones.length][stones.length];
        int[][] weights = new int[stones.length][stones.length];

        // update weights
        for (int i = 0; i < stones.length - 1; i++) {
            weights[i][i] = stones[i];
            for (int j = i + 1; j < stones.length; j++) {
                weights[i][j] = weights[i][j - 1] + stones[j];
            }
        }

        for (int interval = 1; interval < stones.length; interval++) {
            for (int i = 0; i < stones.length - interval; i++) {
                int j = i + interval;
                minCosts[i][j] = Integer.MAX_VALUE;
                // find min cost M[i][j]
                for (int k = i; k < j; k++) {
                    minCosts[i][j] = Math.min(minCosts[i][j], minCosts[i][k] + minCosts[k + 1][j] + weights[i][j]);
                }
            }
        }
        return minCosts[0][stones.length - 1];
    }

    public static void main(String[] args) {
        MergeStones test = new MergeStones();
        int[] arr = new int[]{4};
        System.out.println(test.minCost(arr));
    }
}
