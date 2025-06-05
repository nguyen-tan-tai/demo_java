package com.example.algorithm.leetcode.studyplan75;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * date: 2025-06-03
 * tags: java, algorithm, move zeroes
 */
class CanPlaceFlowersTest {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int l = flowerbed.length;
        int capacity = 0;
        for (int i = 0; i < l; i++) {
            if ((i - 1 < 0 || flowerbed[i - 1] == 0)
                    && flowerbed[i] == 0
                    && (i + 1 > l - 1 || flowerbed[i + 1] == 0)) {
                capacity++;
                i++;
            }
        }
        return capacity >= n;
    }

    @Test
    public void test() {
        assertThat(canPlaceFlowers(new int[] { 0, 0, 1, 0, 0, 0, 1 }, 2)).isTrue();
    }
}
