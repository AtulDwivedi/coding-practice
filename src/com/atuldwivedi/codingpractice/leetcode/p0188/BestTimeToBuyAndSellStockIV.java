package com.atuldwivedi.codingpractice.leetcode.p0188;

/**
 * @author Atul Dwivedi
 * <p>
 * At most k transactions are allowed.
 * References:
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/discuss/1987196/JavaC%2B%2BPythonJavaScriptKotlinSwiftO(n)timeBEATS-99.97-MEMORYSPEED-0ms-APRIL-2022
 */
public class BestTimeToBuyAndSellStockIV {

    /**
     * @param prices
     * @return maximum profit
     * <p>
     * Time complexity: O(n*k)
     * Space Complexity: O(n*k)
     */
    public static int maxProfit(int k, int[] prices) {
        int[] sell = new int[k + 1];
        int[] buy = new int[k + 1];

        for (int i = 0; i < k + 1; i++) {
            sell[i] = 0;
            buy[i] = Integer.MIN_VALUE;
        }

        for (int price : prices) {
            for (int j = k; j > 0; j--) {
                sell[j] = Math.max(sell[j], price + buy[j]);
                buy[j] = Math.max(buy[j], sell[j - 1] - price);
            }
        }

        return sell[k];
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1};
        System.out.println(maxProfit(2, arr) == 2 ? "Success" : "Failed");

        int[] arr2 = {3, 2, 6, 5, 0, 3};
        System.out.println(maxProfit(2, arr2) == 7 ? "Success" : "Failed");
    }
}
