package com.atuldwivedi.cp.leetcode.p0121;

/**
 * @author Atul Dwivedi
 * <p>
 * At most one transaction is allowed.
 * References:
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * https://www.geeksforgeeks.org/maximum-difference-between-two-elements/
 */
public class BestTimeToBuyAndSellStock {

    /**
     * @param prices
     * @return maximum profit
     * <p>
     * Time complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int max_diff = prices[1] - prices[0];
        int min_element = prices[0];

        for (int i = 1; i < prices.length; i++) {
            int curr_element = prices[i];
            int curr_diff = curr_element - min_element;

            if (curr_diff > max_diff) {
                max_diff = curr_diff;
            }

            if (curr_element < min_element) {
                min_element = prices[i];
            }
        }

        if (max_diff < 0) {
            return 0;
        }

        return max_diff;
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(arr) == 5 ? "Success" : "Failed");

        int[] arr2 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(arr2) == 0 ? "Success" : "Failed");

        int[] arr3 = {2, 3, 10, 6, 4, 8, 1};
        System.out.println(maxProfit(arr3) == 8 ? "Success" : "Failed");

        int[] arr4 = {7, 9, 5, 6, 3, 2};
        System.out.println(maxProfit(arr4) == 2 ? "Success" : "Failed");
    }
}
