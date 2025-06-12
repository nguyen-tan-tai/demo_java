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
class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        fillInOrder(result, 1, n);
        return result;
    }

    private void fillInOrder(List<Integer> result, int i, int n) {
        if (i > n) {
            return;
        }
        result.add(i);
        fillInOrder(result, i * 10, n);
        if (i % 10 != 9) {
            fillInOrder(result, i + 1, n);
        }
    }

    public List<Integer> lexicalOrder2(int n) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            arr.add(i);
        }
        Collections.sort(arr, new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return Integer.toString(i1).compareTo(Integer.toString(i2));
            }
        });
        return arr;
    }

    @Test
    public void test() {
        assertThat(lexicalOrder(25)).isEqualTo(Arrays.asList(1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 2, 20, 21, 22, 23, 24, 25, 3, 4, 5, 6, 7, 8, 9));
        assertThat(lexicalOrder2(25)).isEqualTo(Arrays.asList(1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 2, 20, 21, 22, 23, 24, 25, 3, 4, 5, 6, 7, 8, 9));
    }
}
