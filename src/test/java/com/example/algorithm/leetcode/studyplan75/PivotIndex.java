package com.example.algorithm.leetcode.studyplan75;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * date: 2025-06-03
 * tags: java, algorithm, prefix sum
 */
class PivotIndex {
    public static int pivotIndex(int[] nums) {
        int sumLeft = 0;
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        for (int i = 0; i < nums.length; i++) {
            int sumRight = totalSum - sumLeft - nums[i];
            if (sumLeft == sumRight) {
                return i;
            }
            sumLeft += nums[i];
        }
        return -1;
    }

    @Test
    public void test() {
        assertThat(pivotIndex(new int[] { 1, 7, 3, 6, 5, 6 })).isEqualTo(3);
        assertThat(pivotIndex(new int[] { 2, 1, -1 })).isEqualTo(0);
        assertThat(pivotIndex(new int[] { -3, 2, 1 })).isEqualTo(-1);
    }
}
