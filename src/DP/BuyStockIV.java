package DP;

/*
Given an array of integers representing a stock’s price on each day. On each day you can only make one operation: either buy or sell one unit of stock, and at any time you can only hold at most one unit of stock, and you can make at most K transactions in total. Determine the maximum profit you can make.

        Assumptions

        The give array is not null and is length of at least 2
        Examples

        {2, 3, 2, 1, 4, 5, 2, 11}, K = 3, the maximum profit you can make is (3 - 2) + (5 - 1) + (11 - 2)= 14
*/

import java.util.Arrays;

public class BuyStockIV {
    public int maxProfit(int[] array, int k) {
        // edge case
        if (k == 0) {
            return 0;
        }

        int[] buys = new int[k];
        int[] sells = new int[k];
        Arrays.fill(buys, array[0]);
        for (int i = 1; i < array.length; i++) {
            // update buys and sells
            // total = MAX((sell_k - buy_k) + ... + (sell1 - buy1))
            for (int j = 0; j < k; j++) {
                if (j == 0) {
                    buys[j] = Math.min(buys[j], array[i]);
                } else {
                    buys[j] = Math.min(buys[j], array[i] - sells[j - 1]);
                }
                sells[j] = Math.max(sells[j], array[i] - buys[j]);
            }
        }
        return sells[k - 1];
    }

    public static void main(String[] args) {
        BuyStockIV test = new BuyStockIV();
        int[] arr = new int[]{2, 3, 2, 1, 4, 5, 2, 11};
        System.out.println(test.maxProfit(arr, 3));
    }
}
