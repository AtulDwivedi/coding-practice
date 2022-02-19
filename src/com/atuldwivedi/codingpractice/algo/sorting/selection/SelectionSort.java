package com.atuldwivedi.codingpractice.algo.sorting.selection;

import java.util.Arrays;

/**
 * @author Atul Dwivedi
 * @date 01/07/21
 */
public class SelectionSort {

    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        //input array
        int[] arr = {4, 2, 9, 7, 3, 5};

        //sorting
        new SelectionSort().sort(arr);

        //printing sorted array
        Arrays.stream(arr).forEach(element -> System.out.print(element + "\t"));
    }
}
