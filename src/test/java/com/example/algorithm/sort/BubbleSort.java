package com.example.algorithm.sort;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-30
 * tags: java, algorithm, sort, bubble sort
 * references: https://www.geeksforgeeks.org/bubble-sort-algorithm/
 */
class BubbleSort {

    static void bubbleSort(int arr[], int n) {
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false) {
                break;
            }
        }
    }

    @Test
    public void test() {
        int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
        bubbleSort(arr, arr.length);
        assertThat(arr).isEqualTo(new int[] { 11, 12, 22, 25, 34, 64, 90 });
    }
}
