package com.atuldwivedi.cp.ds.array;

import java.util.Arrays;

/**
 * @author Atul Dwivedi
 */
public class ReverseAnArray {

    public static void reverse(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[(n - 1) - i];
            arr[(n - 1) - i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        reverse(arr);

        Arrays.stream(arr).forEach(e -> System.out.print(e + "\t"));
    }
}
