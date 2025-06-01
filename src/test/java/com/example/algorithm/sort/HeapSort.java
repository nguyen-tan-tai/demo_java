package com.example.algorithm.sort;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-30
 * tags: java, algorithm, sort, heap sort
 * references: https://www.geeksforgeeks.org/heap-sort/
 */
class HeapSort {
    static void heapify(int arr[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }

    static void heapSort(int arr[]) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    @Test
    public void test() {
        int arr[] = { 9, 4, 3, 8, 10, 2, 5 };
        heapSort(arr);
        assertThat(arr).isEqualTo(new int[] { 2, 3, 4, 5, 8, 9, 10 });
    }
}
