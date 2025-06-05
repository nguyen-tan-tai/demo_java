package com.example.algorithm.leetcode.studyplan75;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * date: 2025-06-03
 * tags: java, algorithm, move zeroes
 */
class ReverseVowelsOfAStringTest {
    public String reverseVowels(String s) {
        int l = s.length();
        List<Character> vowels = new ArrayList<>();
        for (int i = 0; i < l; i++) {
            char c = s.charAt(i);
            if (isVowel(c)) {
                vowels.add(c);
            }
        }
        int idx = vowels.size() - 1;
        StringBuilder result = new StringBuilder(s);
        for (int i = 0; i < l; i++) {
            if (isVowel(s.charAt(i))) {
                result.setCharAt(i, vowels.get(idx--));
            }
        }
        return result.toString();
    }

    private boolean isVowel(char c) {
        char lc = Character.toLowerCase(c);
        return lc == 'a' || lc == 'e' || lc == 'i' || lc == 'o' || lc == 'u';
    }

    public String reverseVowelsUsingTwoPointers(String s) {
        char[] str = s.toCharArray();
        int length = str.length;
        int l = 0;
        int r = length - 1;
        while (l < r) {
            while (l < r && !isVowel(str[l])) {
                l++;
            }
            while (l < r && !isVowel(str[r])) {
                r--;
            }
            if (l < r) {
                char temp = str[l];
                str[l] = str[r];
                str[r] = temp;
                l++;
                r--;
            }
        }
        return new String(str);
    }

    @Test
    public void test() {
        assertThat(reverseVowels("abucOde")).isEqualTo("ebOcuda");
        assertThat(reverseVowelsUsingTwoPointers("abucOde")).isEqualTo("ebOcuda");
    }
}
