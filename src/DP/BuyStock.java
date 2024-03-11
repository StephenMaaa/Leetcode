package DP;

/*
LeetCode 121

Given an array of positive integers representing a stock’s price on each day. On each day you can only make one operation: either buy or sell one unit of stock and you can make at most 1 transaction. Determine the maximum profit you can make.

        Assumptions

        The given array is not null and is length of at least 2.
        Examples

        {2, 3, 2, 1, 4, 5}, the maximum profit you can make is 5 - 1 = 4
*/

public class BuyStock {
//    public int maxProfit(int[] array) {
//        int minCost = array[0];
//        int max = 0;
//        for (int i = 1; i < array.length; i++) {
//            max = Math.max(max, array[i] - minCost);
//            minCost = Math.min(minCost, array[i]);
//        }
//        return max;
//    }

    // approach 1: DP TC: O(n) SC: O(1)
    public int maxProfit(int[] prices) {
        // initialization
        int cost = prices[0];
        int max = 0;

        // search
        for (int i = 1; i < prices.length; i++) {
            // calculate profit
            max = Math.max(prices[i] - cost, max);

            // update cost (buy cheaper stock)
            cost = Math.min(prices[i], cost);
        }
        return max;
    }

    public static void main(String[] args) {
        BuyStock test = new BuyStock();
        int[] arr = new int[]{2, 3, 2, 1, 4, 5};
        System.out.println(test.maxProfit(arr));
    }
}
