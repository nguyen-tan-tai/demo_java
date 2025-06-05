package com.example.algorithm.array;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import org.junit.jupiter.api.Test;

/**
 * date: 2025-06-03
 * tags: java, algorithm, max min
 */
class KthMaximumValue {
    public int kthMax(int[] nums, int k) {
        int l = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < l; i++) {
            int v = nums[i];
            pq.add(v);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    static int quickSelect(List<Integer> arr, int k) {
        int pivotIdx = new Random().nextInt(arr.size());
        int pivot = arr.get(pivotIdx);
        List<Integer> leftArr = new ArrayList<>();
        List<Integer> midArr = new ArrayList<>();
        List<Integer> rightArr = new ArrayList<>();
        for (int val : arr) {
            if (val > pivot) {
                leftArr.add(val);
            } else if (val < pivot) {
                rightArr.add(val);
            } else {
                midArr.add(val);
            }
        }
        if (k <= leftArr.size()) {
            return quickSelect(leftArr, k);
        }
        if (leftArr.size() + midArr.size() < k) {
            return quickSelect(rightArr, k - leftArr.size() - midArr.size());
        }
        return pivot;
    }

    static int KthLargest(int[] arr, int k) {
        List<Integer> arrList = new ArrayList<>();
        for (int val : arr) {
            arrList.add(val);
        }
        return quickSelect(arrList, k);
    }

    @Test
    public void test() {
        assertThat(kthMax(new int[] { 3, 2, 1, 5, 6, 4 }, 2)).isEqualTo(5);
        assertThat(kthMax(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4)).isEqualTo(4);
    }
}
