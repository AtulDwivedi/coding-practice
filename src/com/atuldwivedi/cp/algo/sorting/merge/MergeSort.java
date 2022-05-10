package com.atuldwivedi.cp.algo.sorting.merge;

import java.util.Arrays;

/**
 * Merge Sort
 *
 * @author Atul Dwivedi
 */
public class MergeSort {

    /**
     * Merge Sort of integer array
     *
     * @param arr original array
     * @param l   left most index of array
     * @param r   right most index of array
     *            <p>
     *            Algorithm:
     *            1. Sort
     *            1.1 Find mid of array
     *            1.2 sort array between left most index l to mid index, both inclusive
     *            1.3 sort array between next of mid i.e. (m+1) to right most index r, both inclusive
     *            2. Merge
     *            2.1 Perform sorted merge on both arrays arr[...,l,...,m,m+1,...,r...]
     *            2.2 Two part of array are from l to m and m+1 to r
     */
    public void sort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            sortedMerge(arr, l, m, r);
        }
    }

    private void sortedMerge(int[] arr, int l, int m, int r) {
        //length of array = (last index - first index) + 1
        int n1 = (m - l) + 1;
        int n2 = (r - (m + 1)) + 1;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }

        for (int j = 0; j < n2; j++) {
            R[j] = arr[(m + 1) + j];
        }

        int i = 0, j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        Arrays.stream(arr).forEach(element -> System.out.print(element + "\t"));

        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr, 0, arr.length - 1);

        System.out.println();
        Arrays.stream(arr).forEach(element -> System.out.print(element + "\t"));
    }
}
