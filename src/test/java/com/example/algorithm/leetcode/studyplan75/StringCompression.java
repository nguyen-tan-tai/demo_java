package com.example.algorithm.leetcode.studyplan75;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * date: 2025-06-03
 * tags: java, algorithm, two pointers
 */
class StringCompression {
    public static int compress(char[] chars) {
        int writeIndex = 0;
        int l = chars.length;
        for (int i = 0; i < l;) {
            int newCharIndex = i + 1;
            while (newCharIndex < l && chars[newCharIndex] == chars[i]) {
                newCharIndex++;
            }
            chars[writeIndex++] = chars[i];
            if (newCharIndex - i > 1) {
                String count = String.valueOf(newCharIndex - i);
                for (char c : count.toCharArray()) {
                    chars[writeIndex++] = c;
                }
            }
            i = newCharIndex;
        }
        return writeIndex;
    }

    @Test
    public void test() {
        char[] arr = new char[] { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
        int result = compress(arr);
        assertThat(result).isEqualTo(6);
        assertThat(arr).isEqualTo(new char[] { 'a', '2', 'b', '2', 'c', '3', 'c' });
    }
}
