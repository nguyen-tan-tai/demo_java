package com.example.algorithm;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-18
 * tags: java, algorithm, Difference Array Technique
 */
class DifferenceArrayTechniqueTest {

    @Test
    public void test() {
        assertThat(isZeroArrayUsingDifferenceArray(new int[] {1, 0, 1}, new int[][] {{0, 2}})).isTrue();
        assertThat(isZeroArrayUsingDifferenceArray(new int[] {4, 3, 2, 1}, new int[][] {{1, 3}, {0, 2}})).isFalse();

        assertThat(isZeroArrayBruteForce(new int[] {1, 0, 1}, new int[][] {{0, 2}})).isTrue();
        assertThat(isZeroArrayBruteForce(new int[] {4, 3, 2, 1}, new int[][] {{1, 3}, {0, 2}})).isFalse();
    }

    public boolean isZeroArrayBruteForce(int[] nums, int[][] queries) {
        int[] changes = new int[nums.length];
        for (int[] query : queries) {
            for (int i = query[0]; i <= query[1]; i++) {
                changes[i]++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > changes[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean isZeroArrayUsingDifferenceArray(int[] nums, int[][] queries) {
        int[] deltaNums = new int[nums.length + 1];
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            deltaNums[l] += 1;
            deltaNums[r + 1] -= 1;
        }
        // System.out.println(" -> delta" + Arrays.toString(deltaNums));
        int[] accumulateIncrement = new int[deltaNums.length];
        int currentInrement = 0;
        for (int i = 0; i < deltaNums.length; i++) {
            currentInrement += deltaNums[i];
            accumulateIncrement[i] = currentInrement;
        }
        // System.out.println("accumulate > " + Arrays.toString(accumulateIncrement));
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > accumulateIncrement[i]) {
                return false;
            }
        }
        return true;
    }
}
