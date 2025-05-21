package com.example.algorithm;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-18
 * tags: java, algorithm, Array Shift Technique
 */
class ArrayShiftTechniqueTest {

    public int[] shiftLeftUsingTempArray(int[] arr, int r) {
        int l = arr.length;
        int[] shiftedArr = new int[l];
        for (int i = 0; i < l; i++) {
            int p = i + r < l ? i + r : i + r - l;
            shiftedArr[i] = arr[p];
        }
        return shiftedArr;
    }

    void shiftLeftDirect(int arr[], int r) {
        int n = arr.length;
        int temp[] = new int[r];
        for (int i = 0; i < r; i++) {
            temp[i] = arr[i];
        }
        for (int i = r; i < n; i++) {
            arr[i - r] = arr[i];
        }
        for (int i = 0; i < r; i++) {
            arr[i + n - r] = temp[i];
        }
    }

    @Test
    public void test() {
        assertThat(shiftLeftUsingTempArray(new int[] {1, 2, 3, 4, 5}, 2)).isEqualTo(new int[] {3, 4, 5, 1, 2});
        int[] arr = new int[] {1, 2, 3, 4, 5};
        shiftLeftDirect(arr, 2);
        assertThat(arr).isEqualTo(new int[] {3, 4, 5, 1, 2});
    }
}
