package com.atuldwivedi.codingpractice.algo.dp;

/**
 * @author Atul Dwivedi
 */
public class CoinChange02 {
    public static int count(int[] S, int m, int n) {
        int[] table = new int[n + 1];
        table[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = S[i]; j <= n; j++) {
                table[j] = table[j] + table[j - S[i]];
            }
        }
        return table[n];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int count = count(arr, arr.length, 4);
        System.out.println(count);
    }
}
