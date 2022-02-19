package com.atuldwivedi.codingpractice.algo.dp;

/**
 * @author Atul Dwivedi
 * @date 15/07/21
 */
public class EggDropping {
    public int recursive(int n, int k) {
        if (n == 1 || k == 0 || k == 1) {
            return k;
        }

        int min = Integer.MAX_VALUE;

        int res;
        for (int i = 1; i <= k; i++) {
            res = Math.max(recursive(n - 1, i - 1), recursive(n, k - i));
            if (res < min) {
                min = res;
            }
        }
        return min + 1;
    }


    public static void main(String[] args) {
        //number of eggs
        int n = 2;
        //number of floors
        int k = 10;

        EggDropping eggDropping = new EggDropping();
        int minimumAttempt = eggDropping.recursive(n, k);

        System.out.println(minimumAttempt);
    }
}
