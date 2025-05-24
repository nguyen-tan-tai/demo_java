package com.example.challenges;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.utils.MyUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-24
 * tags: java, algorithm, matrix, Strings, Dynamic Programming, Trick
 */
public class C0004_EqualTest {

    @Test
    public void test() {
        // assertThat(equal(new int[] {2, 2, 3, 7})).isEqualTo(2);
//        assertThat(equal(new int[] {10, 7, 12})).isEqualTo(3);
        assertThat(equal(new int[] {10, 7, 12, 13})).isEqualTo(5);
    }

    public static int equal(int[] arr) {
        MyUtils.print(arr);
        int[] possibilities = new int[5];
        int minNum = Arrays.stream(arr).min().getAsInt();
        for (int i = 0; i < possibilities.length; i++) {
            for (int j : arr) {
                int diff = j - minNum;
                int stepsRequired = diff / 5 + (diff % 5) / 2 + ((diff % 5) % 2) / 1;
                System.out.println("i=" + i + "     j=" + j + "    minNum=" + minNum + "    diff=" + diff + "     stepsRequired=" + stepsRequired);
                possibilities[i] += stepsRequired;
            }
            MyUtils.print(possibilities);
            minNum--;
        }
        return Arrays.stream(possibilities).min().getAsInt();
    }
}
