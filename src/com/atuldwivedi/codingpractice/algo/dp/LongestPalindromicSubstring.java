package com.atuldwivedi.codingpractice.algo.dp;

/**
 * @author Atul Dwivedi
 */
public class LongestPalindromicSubstring {

    static int longestPalindromeSubstring(String str) {
        int n = str.length();
        boolean[][] table = new boolean[n][n];
        int startIndexOfLongestPalindrome = 0;
        int maxLength = 1;

        // All substrings of length 1 are palindromes
        for (int i = 0; i < n; i++) {
            table[i][i] = true;
        }

        // check palindromes for sub-strings (length = 2)
        for (int i = 0; i < n - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                table[i][i + 1] = true;
                startIndexOfLongestPalindrome = i;
                maxLength = 2;
            }
        }

        // check palindromes for sub-strings (lengths > 2)
        for (int substringLength = 3; substringLength <= n; substringLength++) {
            for (int startIndex = 0; startIndex < n - substringLength + 1; startIndex++) {
                int endIndex = startIndex + substringLength - 1;

                if (table[startIndex + 1][endIndex - 1] && str.charAt(startIndex) == str.charAt(endIndex)) {
                    table[startIndex][endIndex] = true;
                    if (substringLength > maxLength) {
                        startIndexOfLongestPalindrome = startIndex;
                        maxLength = substringLength;
                    }
                }
            }
        }

        System.out.print("Longest palindrome substring is: ");
        printSubstring(str, startIndexOfLongestPalindrome, startIndexOfLongestPalindrome + maxLength - 1);

        return maxLength;
    }

    static void printSubstring(String str, int low, int high) {
        System.out.println(str.substring(low, high + 1));
    }

    public static void main(String[] args) {
        String str = "forgekkegfor";
        System.out.println("Length is: " + longestPalindromeSubstring(str));
    }
}
