package com.atuldwivedi.cp.algo.dp.p05;

/**
 * @author Atul Dwivedi
 */
public class LongestCommonSubstring {

    /**
     * @param s1
     * @param s2
     * @return value
     * <p>
     * Time Complexity: O(m*n)
     * Space Complexity: O(m*n)
     */
    public int findLCSLengthTabulation(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int maxLength = 0;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }
        return maxLength;
    }

    /**
     * @param s1
     * @param s2
     * @return value
     * <p>
     * Time Complexity: O(m*n * max(m,n))
     * Space Complexity: O(m*n * max(m,n))
     */
    public int findLCSLengthMemoization(String s1, String s2) {
        int maxLength = Math.min(s1.length(), s2.length());
        Integer[][][] dp = new Integer[s1.length() + 1][s2.length() + 1][maxLength];
        return findLCSLengthMemoizationRecursive(dp, s1, s2, 0, 0, 0);
    }

    private int findLCSLengthMemoizationRecursive(Integer[][][] dp, String s1, String s2, int i1, int i2, int count) {
        if (i1 == s1.length() || i2 == s2.length()) {
            return count;
        }

        if (dp[i1][i2][count] == null) {
            int c1 = count;
            if (s1.charAt(i1) == s2.charAt(i2)) {
                c1 = findLCSLengthMemoizationRecursive(dp, s1, s2, i1 + 1, i2 + 1, count + 1);
            }

            int c2 = findLCSLengthMemoizationRecursive(dp, s1, s2, i1 + 1, i2, 0);
            int c3 = findLCSLengthMemoizationRecursive(dp, s1, s2, i1, i2 + 1, 0);

            dp[i1][i2][count] = Math.min(c1, Math.min(c1, c2));
        }

        return dp[i1][i2][count];
    }

    /**
     * @param s1
     * @param s2
     * @return value
     * <p>
     * Time Complexity: O(3^(m+n))
     * Space Complexity: O(m+n)
     */
    public int findLCSLength(String s1, String s2) {
        return findLCSLengthRecursive(s1, s2, 0, 0, 0);
    }

    private int findLCSLengthRecursive(String s1, String s2, int i1, int i2, int count) {
        if (i1 == s1.length() || i2 == s2.length()) {
            return count;
        }

        if (s1.charAt(i1) == s2.charAt(i2)) {
            count = findLCSLengthRecursive(s1, s2, i1 + 1, i2 + 1, count + 1);
        }

        int c1 = findLCSLengthRecursive(s1, s2, i1 + 1, i2, 0);
        int c2 = findLCSLengthRecursive(s1, s2, i1, i2 + 1, 0);

        return Math.min(count, Math.min(c1, c2));
    }
}
