package com.example.algorithm.leetcode.studyplan75;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-18
 * tags: java, algorithm, array
 */
class MergeStringsAlternatelyTest {
    public String mergeAlternately(String word1, String word2) {
        char[] characters1 = word1.toCharArray();
        char[] characters2 = word2.toCharArray();
        int word1Length = characters1.length;
        int word2Length = characters2.length;
        int maxLength = Math.max(word1Length, word2Length);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxLength; i++) {
            if (i < word1Length) {
                sb.append(characters1[i]);
            }
            if (i < word2Length) {
                sb.append(characters2[i]);
            }
        }
        return sb.toString();
    }

    @Test
    public void test() {
        assertThat(mergeAlternately("abc", "def")).isEqualTo("adbecf");
    }
}
