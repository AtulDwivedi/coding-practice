package com.atuldwivedi.cp.algo.sorting.insertion;

import java.util.Arrays;

/**
 * @author Atul Dwivedi
 * @date 01/07/21
 */
public class InsertionSort {

    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        //input array
        int[] arr = {4, 2, 9, 7, 3, 5};

        //sorting
        new InsertionSort().sort(arr);

        //printing sorted array
        Arrays.stream(arr).forEach(element -> System.out.print(element + "\t"));
    }
}
