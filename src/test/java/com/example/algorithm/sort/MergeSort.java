package com.example.algorithm.sort;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-30 tags: java, algorithm, sort, merged sort references:
 * https://www.geeksforgeeks.org/merge-sort/
 */
class MergeSort {
    static void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
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

    static void mergedSort(int arr[], int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergedSort(arr, l, m);
            mergedSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    @Test
    public void test() {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
        mergedSort(arr, 0, arr.length - 1);
        assertThat(arr).isEqualTo(new int[] { 5, 6, 7, 11, 12, 13 });
    }
}
