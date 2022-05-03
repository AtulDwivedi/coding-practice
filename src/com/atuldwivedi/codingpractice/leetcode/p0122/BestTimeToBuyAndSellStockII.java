package com.atuldwivedi.codingpractice.leetcode.p0122;

/**
 * @author Atul Dwivedi
 * <p>
 * Any number of transactions are allowed.
 * References:
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * https://www.geeksforgeeks.org/stock-buy-sell/
 */
public class BestTimeToBuyAndSellStockII {

    /**
     * @param prices
     * @return maximum profit
     * <p>
     * Valley Peak Approach
     * Time complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int maxProfit(int[] prices) {

        // maxProfit adds up the difference between
        // adjacent elements if they are in increasing order
        int maxProfit = 0;

        // The loop starts from 1
        // as its comparing with the previous
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(arr) == 7 ? "Success" : "Failed");

        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println(maxProfit(arr2) == 4 ? "Success" : "Failed");

        int[] arr3 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(arr3) == 0 ? "Success" : "Failed");

        int[] arr4 = {100, 180, 260, 310, 40, 535, 695};
        System.out.println(maxProfit(arr4) == 865 ? "Success" : "Failed");
    }
}
