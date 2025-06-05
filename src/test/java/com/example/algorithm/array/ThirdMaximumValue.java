package com.example.algorithm.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * date: 2025-06-03
 * tags: java, algorithm, max min
 */
class ThirdMaximumValue {
    public int thirdMax(int[] nums) {
        int l = nums.length;
        if (l <= 1) {
            return nums[0];
        }
        if (l <= 2) {
            // If the third maximum does not exist, return the maximum number
            return Math.max(nums[0], nums[1]);
        }
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
        for (int i = 0; i < l; i++) {
            int v = nums[i];
            if (v == first || v == second || v == third) { // Do not mess it up
                continue;
            }
            if (v > first) {
                third = second;
                second = first;
                first = v;
            } else if (v > second) {
                third = second;
                second = v;
            } else if (v > third) {
                third = v;
            }
        }
        if (third == Long.MIN_VALUE) {
            return (int) first;
        }
        return (int) third;
    }

    @Test
    public void test() {
        assertThat(thirdMax(new int[] { 2, 2, 3, 1 })).isEqualTo(1);
        assertThat(thirdMax(new int[] { 3, 2, 1 })).isEqualTo(1);
        assertThat(thirdMax(new int[] { 1, 2, 2, 5, 3, 5 })).isEqualTo(2);
    }
}
