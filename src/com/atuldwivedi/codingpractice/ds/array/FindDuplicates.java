package com.atuldwivedi.codingpractice.ds.array;

import java.util.Arrays;

/**
 * @author Atul Dwivedi
 */
public class FindDuplicates {

    /**
     * Prints all elements which has duplicates in the specified array
     *
     * @param arr array of integers
     *            <p>
     *            Time Complexity: O(n)
     *            Space Complexity: O(1)
     */
    private static void printDuplicates(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int idx = arr[i] % n;
            arr[idx] = arr[idx] + n;
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] / n > 1) {
                System.out.print(i + " ");
            }
        }

        //correct the modified input array to it's original state
        for (int i = 0; i < n; i++) {
            int idx = arr[i] % n;
            arr[idx] = arr[idx] - n;
        }

    }

    public static void main(String[] args) {
        int[] arr = {5, 0, 4, 3, 2, 7, 8, 2, 3, 5};
        printDuplicates(arr);
    }
}
