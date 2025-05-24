package com.example.challenges;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-24
 * tags: java, algorithm, matrix, Strings, Dynamic Programming, Trick
 */
public class C0003_StringReduction {

    @Test
    public void test() {
        assertThat(stringReduction("cab")).isEqualTo(2);
        assertThat(stringReduction("bcab")).isEqualTo(1);
        assertThat(stringReduction("ccccc")).isEqualTo(5);
    }

    /**
     * The idea behind is to produce a string with same character. e.g. aaaa, bb, or c
     * It is tricky challenges
     * To solve this, we add one to one char (less or equals than the rest) while deduct the 2 other chars until there are only one char in the string
     *
     * @param s
     * @return number of char
     */
    public static int stringReduction(String s) {
        int n = s.length();
        int aCount = 0;
        int bCount = 0;
        int cCount = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                aCount++;
            }
            if (s.charAt(i) == 'b') {
                bCount++;
            }
            if (s.charAt(i) == 'c') {
                cCount++;
            }
        }
        int max = n;
        while (true) {
            max = aCount + bCount + cCount;
            if (aCount == max || bCount == max || cCount == max) {
                break;
            }
            if (aCount <= bCount && aCount <= cCount) {
                aCount++;
                bCount--;
                cCount--;
            } else if (bCount <= aCount && bCount <= cCount) {
                bCount++;
                aCount--;
                cCount--;
            } else if (cCount <= aCount && cCount <= bCount) {
                cCount++;
                aCount--;
                bCount--;
            } ;
        }
        return max;
    }
}
