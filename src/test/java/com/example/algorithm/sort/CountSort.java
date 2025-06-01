package com.example.algorithm.sort;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-30
 * tags: java, algorithm, sort, count sort
 * references: https://www.geeksforgeeks.org/quick-sort-algorithm/
 */
class CountSort {

    public int[] countSort(int[] inputArray) {
        int N = inputArray.length;
        int M = 0;
        for (int i = 0; i < N; i++) {
            M = Math.max(M, inputArray[i]);
        }
        int[] countArray = new int[M + 1];
        for (int i = 0; i < N; i++) {
            countArray[inputArray[i]]++;
        }
        for (int i = 1; i <= M; i++) {
            countArray[i] += countArray[i - 1];
        }
        int[] outputArray = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            outputArray[countArray[inputArray[i]] - 1] = inputArray[i];
            countArray[inputArray[i]]--;
        }
        return outputArray;
    }

    @Test
    public void test() {
        int[] inputArray = { 4, 3, 12, 1, 5, 5, 3, 9 };
        int[] outputArray = countSort(inputArray);
        countSort(outputArray);
        assertThat(outputArray).isEqualTo(new int[] { 1, 3, 3, 4, 5, 5, 9, 12 });
    }
}
