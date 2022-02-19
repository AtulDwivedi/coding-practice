package com.atuldwivedi.codingpractice.ds.array;

import java.util.Arrays;

/**
 * @author Atul Dwivedi
 */
public class MoveNumberToEnd {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 3, 1, 5};

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 3) {
                arr[count] = arr[i];
                count++;
            }
        }

        for (int i = count; i < arr.length; i++) {
            arr[i] = 3;
        }

        Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
    }
}
