package com.example.algorithm;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * date: 2025-06-01
 * tags: java, algorithm, prefix sum, find minimum start value
 */
class PrefixSumTechniqueTest {

    @Test
    public void test() {
        assertThat(minStartValueBruteForce(new int[] { 1, -1, -10, 5, -10 })).isEqualTo(16);
        assertThat(minStartValueUsingPrefixSum(new int[] { 1, -1, -10, 5, -10 })).isEqualTo(16);
        assertThat(minStartValueUsingSingleCursor(new int[] { 1, -1, -10, 5, -10 })).isEqualTo(16);
    }

    public static int minStartValueBruteForce(int[] nums) {
        int minStartValue = 1;
        int l = nums.length;
        while (true) {
            int startValue = minStartValue;
            boolean isMinValue = true;
            for (int i = 0; i < l; ++i) {
                startValue += nums[i];
                if (startValue < 1) {
                    isMinValue = false;
                    break;
                }
            }
            if (isMinValue) {
                return minStartValue;
            }
            ++minStartValue;
        }
    }

    public int minStartValueUsingSingleCursor(int[] nums) {
        int minSum = 0;
        int currentSum = 0;
        for (int num : nums) {
            currentSum += num;
            minSum = Math.min(minSum, currentSum);
        }
        return 1 - minSum;
    }

    public int minStartValueUsingPrefixSum(int[] nums) {
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        int minimumPrefixSum = prefixSum[0];
        for (int i : prefixSum) {
            minimumPrefixSum = Math.min(i, minimumPrefixSum);
        }
        if (minimumPrefixSum > 0) {
            return 1;
        } else {
            return 1 + -1 * minimumPrefixSum;
        }
    }
}
