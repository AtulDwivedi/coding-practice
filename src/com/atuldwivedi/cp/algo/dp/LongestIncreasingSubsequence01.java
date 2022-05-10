package com.atuldwivedi.cp.algo.dp;

import java.util.Arrays;

/**
 * @author Atul Dwivedi
 */
public class LongestIncreasingSubsequence01 {
    public static void main(String[] args) {
        //int arr[] = {3, 10, 2, 1, 20};
        //int arr[] = {3, 2};
        //int arr[] = {50, 3, 10, 7, 40, 80};
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60};
        int lis = lis(arr, arr.length);
        System.out.println("Longest Increasing Subsequence: " + lis);
    }

    private static int lis(int[] arr, int n) {
        int max = 0;

        int[] LIS = new int[n];
        Arrays.fill(LIS, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && LIS[i] < LIS[j] + 1) {
                    LIS[i] = LIS[j] + 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (max < LIS[i]) {
                max = LIS[i];
            }
        }

        return max;
    }
}
