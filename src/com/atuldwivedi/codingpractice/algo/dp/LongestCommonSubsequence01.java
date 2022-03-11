package com.atuldwivedi.codingpractice.algo.dp;

/**
 * @author Atul Dwivedi
 */
public class LongestCommonSubsequence01 {
    public static void main(String[] args) {
        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";

        char[] X = str1.toCharArray();
        char[] Y = str2.toCharArray();

        int lcs = lsc(X, Y, X.length, Y.length);
        System.out.println("Longest Common Subsequence: " + lcs);
    }

    private static int lsc(char[] X, char[] Y, int m, int n) {
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
