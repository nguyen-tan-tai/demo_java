package com.example.algorithm;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-18
 * tags: java, algorithm, Difference Array Technique, sub string
 */
class SubstringAlternativeTest {

    @Test
    public void test() {
        assertThat(getWayToCreateSubstring("ababa", "aba")).isEqualTo(4);
        assertThat(getWayToCreateSubstring("ababa", "c")).isEqualTo(0);
        assertThat(getWayToCreateSubstring("ababa", "a")).isEqualTo(3);
        assertThat(getWayToCreateSubstring("ababa", "aa")).isEqualTo(3);
        assertThat(getWayToCreateSubstring("ababa", "aaa")).isEqualTo(1);
    }

    public long getWayToCreateSubstring(String string, String sub) {
        int nL = sub.length();
        int oL = string.length();
        long[] output = new long[oL + 1];
        Arrays.fill(output, 1);
        for (int i = 1; i < nL + 1; i++) {
            long[] checkOutput = new long[oL + 1];
            Arrays.fill(checkOutput, 0);
            for (int j = i; j < oL + 1; j++) {
                checkOutput[j] = checkOutput[j - 1];
                if (sub.charAt(i - 1) == string.charAt(j - 1)) {
                    checkOutput[j] += output[j - 1];
                }
            }
            output = checkOutput;
        }
        return output[output.length - 1];
    }
}
