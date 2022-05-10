package com.atuldwivedi.cp.algo.dp;

/**
 * @author Atul Dwivedi
 * @date 13/07/21
 */
public class FibonacciNumber {

    private final int MAX = 100;
    private final int NIL = -1;

    int[] lookup = new int[MAX];

    private void initialize() {
        for (int i = 0; i < MAX; i++) {
            lookup[i] = NIL;
        }
    }

    public int recursive(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return recursive(n - 1) + recursive(n - 2);
    }

    public int memoization(int n) {
        if (lookup[n] == NIL) {
            if (n <= 1) {
                lookup[n] = n;
            } else {
                lookup[n] = memoization(n - 1) + memoization(n - 2);
            }
        }
        return lookup[n];
    }

    public int tabulation(int n) {
        int[] lookup = new int[n + 1];
        lookup[0] = 0;
        lookup[1] = 1;

        for (int i = 2; i <= n; i++) {
            lookup[i] = lookup[i - 1] + lookup[i - 2];
        }
        return lookup[n];
    }

    public static void main(String[] args) {
        FibonacciNumber fibonacciNumber = new FibonacciNumber();

        int number = 9;

        int recursiveResult = fibonacciNumber.recursive(number);
        System.out.println(recursiveResult);

        fibonacciNumber.initialize();
        int memoizationResult = fibonacciNumber.memoization(number);
        System.out.println(memoizationResult);

        int tabulationResult = fibonacciNumber.tabulation(number);
        System.out.println(tabulationResult);
    }
}
