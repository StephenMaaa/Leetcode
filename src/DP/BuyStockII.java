package DP;

/*
Given an array of positive integers representing a stock’s price on each day. On each day you can only make one operation: either buy or sell one unit of stock, you can make as many transactions you want, but at any time you can only hold at most one unit of stock. Determine the maximum profit you can make.

        Assumptions

        The give array is not null and is length of at least 2
        Examples

        {2, 3, 2, 1, 4, 5}, the maximum profit you can make is (3 - 2) + (5 - 1) = 5
*/

public class BuyStockII {
    // time complexity: O(n)
    // space complexity: O(1)
    public int maxProfit(int[] array) {
        int total = 0;
        for (int i = 1; i < array.length; i++) {
            total += Math.max(0, array[i] - array[i - 1]);
        }
        return total;
    }

    // time complexity: O(n)
    // space complexity: O(1)
    public int maxProfit2(int[] prices) {
        int total = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                total += prices[i] - prices[i - 1];
            }
        }
        return total;
    }

    public static void main(String[] args) {
        BuyStockII test = new BuyStockII();
        int[] arr = new int[]{2, 3, 2, 1, 4, 5};
        System.out.println(test.maxProfit(arr));
    }
}
