package com.atuldwivedi.cp.algo.sorting.bubble;

import java.util.Arrays;

/**
 * @author Atul Dwivedi
 * @date 01/07/21
 */
public class BubbleSort {

    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (n - 1) - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        //input array
        int[] arr = {4, 2, 9, 7, 3, 5};

        //sorting
        sort(arr);

        //printing sorted array
        Arrays.stream(arr).forEach(element -> System.out.print(element + "\t"));
    }
}
