package com.example.algorithm.leetcode.studyplan75;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.utils.MyUtils;
import org.junit.jupiter.api.Test;

/**
 * date: 2025-06-03
 * tags: java, algorithm, move zeroes
 */
class MoveZerosTest {
    public void moveZeroesUsingTempArr(int[] nums) {
        int l = nums.length;
        int[] tmp = new int[l];
        int zeroIndex = l - 1;
        for (int nonZeroIndex = 0, i = 0; i < l; i++) {
            if (nums[i] != 0) {
                tmp[nonZeroIndex++] = nums[i];
            } else {
                tmp[zeroIndex--] = nums[i];
            }
        }
        for (int i = 0; i < l; i++) {
            nums[i] = tmp[i];
        }
    }

    public void moveZeroesOptimized(int[] nums) {
        int l = nums.length;
        for (int lastNonZeroFoundAt = 0, i = 0; i < l; i++) {
            if (nums[i] != 0) {
                System.out.print("swap zero=" + lastNonZeroFoundAt + "  current=" + i + " ");
                MyUtils.print(nums);
                swap(nums, lastNonZeroFoundAt++, i);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int iValue = nums[i];
        nums[i] = nums[j];
        nums[j] = iValue;
    }

    @Test
    public void test() {
        {
            int[] arr1 = new int[] { 0, 1, 0, 3, 12 };
            moveZeroesUsingTempArr(arr1);
            assertThat(arr1).isEqualTo(new int[] { 1, 3, 12, 0, 0 });

            int[] arr2 = new int[] { 2, 0, 1, 0, 3, 12 };
            moveZeroesUsingTempArr(arr2);
            assertThat(arr2).isEqualTo(new int[] { 2, 1, 3, 12, 0, 0 });
        }
        {
            int[] arr1 = new int[] { 0, 1, 0, 3, 12 };
            moveZeroesOptimized(arr1);
            assertThat(arr1).isEqualTo(new int[] { 1, 3, 12, 0, 0 });

            int[] arr2 = new int[] { 2, 0, 1, 0, 3, 12 };
            moveZeroesOptimized(arr2);
            assertThat(arr2).isEqualTo(new int[] { 2, 1, 3, 12, 0, 0 });
        }
    }
}
