package com.example.algorithm.leetcode.studyplan75;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.utils.MyUtils;
import org.junit.jupiter.api.Test;

/**
 * date: 2025-06-03
 * tags: java, algorithm, prefix sum
 */
class FindTheHighestAltitude {
    public int largestAltitude(int[] gain) {
        int l = gain.length;
        int[] ps = new int[l + 1];
        ps[0] = 0;
        int highest = Integer.MIN_VALUE;
        for (int i = 0; i < l; i++) {
            ps[i + 1] = ps[i] + gain[i];
            highest = Math.max(highest, ps[i + 1]);
        }
        MyUtils.print(ps);
        return highest;
    }

    @Test
    public void test() {
        assertThat(largestAltitude(new int[] { -4, -3, -2, -1, 4, 3, 2 })).isEqualTo(0);
    }
}
