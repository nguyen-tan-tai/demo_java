package com.example.algorithm.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * date: 2025-06-08
 * tags: java, algorithm, dfs
 */
class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = nums1.length;
        int mi = m - 1;
        int ni = n - 1;
        for (int i = l - 1; i >= 0; i--) {
            if (mi < 0) {
                nums1[i] = nums2[ni--];
                continue;
            }
            if (ni < 0) {
                nums1[i] = nums1[mi--];
                continue;
            }
            int vM = nums1[mi];
            int vN = nums2[ni];
            if (vM > vN) {
                nums1[i] = nums1[mi--];
            } else {
                nums1[i] = nums2[ni--];
            }
        }
    }

    @Test
    public void test() {
        int[] arr1 = new int[] { 1, 2, 3, 0, 0, 0 };
        int[] arr2 = new int[] { 2, 5, 6 };
        merge(arr1, 3, arr2, 3);
        assertThat(arr1).isEqualTo(new int[] { 1, 2, 2, 3, 5, 6 });
    }
}
