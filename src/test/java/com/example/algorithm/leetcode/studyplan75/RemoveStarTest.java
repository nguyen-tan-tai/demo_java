package com.example.algorithm.leetcode.studyplan75;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Stack;
import org.junit.jupiter.api.Test;

/**
 * date: 2025-06-05
 * tags: java, algorithm, remove star, stack
 */
class RemoveStarTest {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        int l = s.length();
        for (int i = 0; i < l; i++) {
            char c = s.charAt(i);
            if (c == '*') {
                stack.pop();
            } else {
                stack.add(c);
            }
            System.out.println(stack);
        }
        StringBuilder b = new StringBuilder();
        for (char c : stack) {
            b.append(c);
        }
        return b.toString();
    }

    @Test
    public void test() {
        assertThat(removeStars("leet**cod*e")).isEqualTo("lecoe");
    }
}
