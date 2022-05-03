package com.atuldwivedi.codingpractice.leetcode.p0123;

/**
 * @author Atul Dwivedi
 * <p>
 * At most two transactions are allowed.
 * References:
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 * https://www.geeksforgeeks.org/best-time-to-buy-and-sell-stock/
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/discuss/1990099/Java-or-O(n)-orEasy
 */
public class BestTimeToBuyAndSellStockIII {

    /**
     * @param prices
     * @return maximum profit
     * <p>
     * Time complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int maxProfit(int[] prices) {
        int buy1 = prices[0];
        int sell1 = 0;

        int buy2 = prices[0];
        int sell2 = 0;

        for (int i = 1; i < prices.length; i++) {
            buy1 = Math.min(buy1, prices[i]);
            sell1 = Math.max(sell1, prices[i] - buy1);
            buy2 = Math.min(buy2, prices[i] - sell1);
            sell2 = Math.max(sell2, prices[i] - buy2);
        }

        return sell2;
    }

    public static void main(String[] args) {
        int[] arr = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit(arr) == 6 ? "Success" : "Failed");

        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println(maxProfit(arr2) == 4 ? "Success" : "Failed");

        int[] arr3 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(arr3) == 0 ? "Success" : "Failed");

        int[] arr4 = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit(arr4) == 6 ? "Success" : "Failed");
    }
}
