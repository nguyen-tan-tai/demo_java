package com.example.algorithm.leetcode.studyplan75;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

/**
 * date: 2025-06-03
 * tags: java, algorithm, array
 */
class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int l = nums.length;
        long productAll = 1L;
        int numOfZeros = 0;
        for (int i = 0; i < l; i++) {
            if (nums[i] == 0) {
                numOfZeros++;
                continue;
            }
            productAll *= nums[i];
        }
        int[] out = new int[l];
        if (numOfZeros >= 2) {
            Arrays.fill(out, 0);
            return out;
        }
        if (numOfZeros == 1) {
            for (int i = 0; i < l; i++) {
                if (nums[i] == 0) {
                    out[i] = (int) productAll;
                } else {
                    out[i] = 0;
                }
            }
            return out;
        }
        for (int i = 0; i < l; i++) {
            if (nums[i] == 0) {
                out[i] = (int) productAll;
            } else {
                out[i] = (int) (productAll / nums[i]);
            }
        }
        return out;
    }

    @Test
    public void test() {
        assertThat(productExceptSelf(new int[] { 0, 0, 3 })).isEqualTo(new int[] { 0, 0, 0 });
        assertThat(productExceptSelf(new int[] { 2, 0, 3 })).isEqualTo(new int[] { 0, 6, 0 });
        assertThat(productExceptSelf(new int[] { 1, 2, 3, 4 })).isEqualTo(new int[] { 24, 12, 8, 6 });
    }
}
