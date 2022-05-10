package com.atuldwivedi.cp.algo.dp.p05;

/**
 * @author Atul Dwivedi
 */
public class EditDistance {

    /**
     * @param s1
     * @param s2
     * @return min operations
     * <p>
     * Time Complexity: O(m*n)
     * Space Complexity: O(m*n)
     */
    public static int findMinOperationsMemoization(String s1, String s2) {
        Integer[][] dp = new Integer[s1.length() + 1][s2.length() + 1];
        return findMinOperationsMemoizationRecursive(dp, s1, s2, 0, 0);
    }

    private static int findMinOperationsMemoizationRecursive(Integer[][] dp, String s1, String s2, int i1, int i2) {
        if (dp[i1][i2] == null) {
            if (i1 == s1.length()) {
                dp[i1][i2] = s2.length() - i2;
            } else if (i2 == s2.length()) {
                dp[i1][i2] = s1.length() - i1;
            } else if (s1.charAt(i1) == s2.charAt(i2)) {
                dp[i1][i2] = findMinOperationsMemoizationRecursive(dp, s1, s2, i1 + 1, i2 + 1);
            } else {
                int c1 = 1 + findMinOperationsMemoizationRecursive(dp, s1, s2, i1 + 1, i2);
                int c2 = 1 + findMinOperationsMemoizationRecursive(dp, s1, s2, i1, i2 + 1);
                int c3 = 1 + findMinOperationsMemoizationRecursive(dp, s1, s2, i1 + 1, i2 + 1);
                dp[i1][i2] = Math.min(c1, Math.min(c2, c3));
            }
        }
        return dp[i1][i2];
    }


    /**
     * @param s1
     * @param s2
     * @return min operations
     * <p>
     * Time Complexity: O(3^(m+n))
     * Space Complexity: O(m+n)
     */
    public static int findMinOperationsBruteForce(String s1, String s2) {
        return findMinOperationsBruteForceRecursive(s1, s2, 0, 0);
    }

    private static int findMinOperationsBruteForceRecursive(String s1, String s2, int i1, int i2) {
        if (i1 == s1.length()) {
            return s2.length() - i2;
        }

        if (i2 == s2.length()) {
            return s1.length() - i1;
        }

        if (s1.charAt(i1) == s2.charAt(i2)) {
            return findMinOperationsBruteForceRecursive(s1, s2, i1 + 1, i2 + 1);
        } else {
            int c1 = 1 + findMinOperationsBruteForceRecursive(s1, s2, i1 + 1, i2);
            int c2 = 1 + findMinOperationsBruteForceRecursive(s1, s2, i1, i2 + 1);
            int c3 = 1 + findMinOperationsBruteForceRecursive(s1, s2, i1 + 1, i2 + 1);

            return Math.min(c1, Math.min(c2, c3));
        }
    }

    public static void main(String[] args) {
        EditDistance editDisatnce = new EditDistance();
        System.out.println(editDisatnce.findMinOperationsBruteForce("bat", "but"));
        System.out.println(editDisatnce.findMinOperationsBruteForce("abdca", "cbda"));
        System.out.println(editDisatnce.findMinOperationsBruteForce("passpot", "ppsspqrt"));
    }
}
