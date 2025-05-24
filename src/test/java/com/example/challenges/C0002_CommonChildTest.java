package com.example.challenges;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-24
 * tags: java, algorithm, matrix, Strings, Dynamic Programming, Overlapping subproblems, Optimal Substructure Property
 */
class C0002_CommonChild {


    @Test
    public void test() {
        assertThat(commonChild("ACBA", "ABCA")).isEqualTo(3);
        assertThat(commonChild("HARRY", "SALLY")).isEqualTo(2);
        assertThat(commonChild("AA", "BB")).isEqualTo(0);
        assertThat(commonChild("SHINCHAN", "NOHARAAA")).isEqualTo(3);
        assertThat(commonChild("ABCDEF", "FBDAMN")).isEqualTo(2);
    }

    public static int commonChild(String s1, String s2) {
        int[][] matrix = new int[s1.length() + 1][s2.length() + 1];
        for (int r = 0; r <= s1.length(); r++) {
            for (int c = 0; c <= s2.length(); c++) {
                if (r == 0 || c == 0) {
                    matrix[r][c] = 0;
                    continue;
                }
                if (s1.charAt(r - 1) == s2.charAt(c - 1)) {
                    matrix[r][c] = matrix[r - 1][c - 1] + 1;
                } else {
                    matrix[r][c] = Math.max(matrix[r - 1][c], matrix[r][c - 1]);
                }
            }
        }
        return matrix[s1.length()][s2.length()];
    }

    public static int commonChildWrong(String s1, String s2) {
        StringBuilder sb1 = new StringBuilder(s1);
        StringBuilder sb2 = new StringBuilder(s2);
        for (int i = sb1.length() - 1; i >= 0; i--) {
            if (!s2.contains(String.valueOf(sb1.charAt(i)))) {
                sb1.delete(i, i + 1);
            }
        }
        for (int i = sb2.length() - 1; i >= 0; i--) {
            if (!s1.contains(String.valueOf(sb2.charAt(i)))) {
                sb2.delete(i, i + 1);
            }
        }
        String s2Final = sb2.toString();
        int m = 0;
        CharSequence sub = null;
        for (int i = 0; i < sb1.length(); i++) {
            for (int j = i + 1; j < sb1.length() + 1; j++) {
                sub = sb1.subSequence(i, j);
                if (s2Final.contains(sub)) {
                    m = Math.max(m, j - i);
                }
            }
        }
        return m;
    }
}
