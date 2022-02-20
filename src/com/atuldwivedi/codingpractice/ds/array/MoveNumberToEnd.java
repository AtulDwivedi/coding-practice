package com.atuldwivedi.codingpractice.ds.array;

import java.util.Arrays;

/**
 * @author Atul Dwivedi
 */
public class MoveNumberToEnd {

    public static void moveElementToTheEnd(int[] arr, int element) {
        int n = arr.length;

        int count = 0;
        //move all items to the left of array but not the specified element
        for (int i = 0; i < n; i++) {
            if (arr[i] != element) {
                arr[count++] = arr[i];
            }
        }

        //fill remaining array with specified element
        for (int i = count; i < n; i++) {
            arr[i] = element;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 3, 1, 5};

        moveElementToTheEnd(arr, 3);

        Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
    }
}
