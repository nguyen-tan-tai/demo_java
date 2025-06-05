package com.example.algorithm.leetcode.studyplan75;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * date: 2025-06-03
 * tags: java, algorithm, greedy
 */
class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int seq = 1;
        int i = nums[0];
        int j = Integer.MIN_VALUE;
        for (int v = 1; v < nums.length; v++) {
            int k = nums[v];
            if (k == i) {
                continue;
            }
            if (k < i) {
                i = k;
                continue;
            }
            if (k < j) {
                j = k;
            } else if (k > j) {
                seq++;
                if (seq == 3) {
                    return true;
                }
                j = k;
            }
        }
        return false;
    }

    @Test
    public void test() {
        assertThat(increasingTriplet(new int[] { 0, 1, 2 })).isTrue();
        assertThat(increasingTriplet(new int[] { 99, 9, 8, 7, 7, 1, 77, 2, 4 })).isTrue();
        assertThat(increasingTriplet(new int[] { 9, 5, 9, 6, 9, 7, 6 })).isTrue();
        assertThat(increasingTriplet(new int[] { 1, 2, 2 })).isFalse();
        assertThat(increasingTriplet(new int[] { 3, 2, 3, 1, 3 })).isFalse();
    }
}
