package com.atuldwivedi.cp.algo.dp;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author Atul Dwivedi
 */
public class LongestIncreasingSubsequence02 {
    public static void main(String[] args) {
        //int arr[] = {3, 10, 2, 1, 20};
        //int arr[] = {3, 2};
        //int arr[] = {50, 3, 10, 7, 40, 80};
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60};
        int lis = lis(arr, arr.length);
        System.out.println("Longest Increasing Subsequence: " + lis);
    }

    private static int lis(int[] X, int m) {
        int max = 0;

        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < m; i++) {
            set.add(X[i]);
        }
        int[] Y = new int[set.size()];
        int n = 0;
        for (int val : set) {
            Y[n] = val;
            n++;
        }

        int[][] LCS = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    LCS[i][j] = 0;
                } else if (X[i - 1] == Y[j - 1]) {
                    LCS[i][j] = LCS[i - 1][j - 1] + 1;
                } else {
                    LCS[i][j] = max(LCS[i - 1][j], LCS[i][j - 1]);
                }
            }
        }

        return LCS[m][n];
    }

    private static int max(int a, int b) {
        return (a > b) ? a : b;
    }
}
