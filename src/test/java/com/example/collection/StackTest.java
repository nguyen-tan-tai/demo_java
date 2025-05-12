package com.example.collection;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Stack;

import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-01 tags: java, collection, Stack
 */
class StackTest {

    @Test
    public void test() {
        Stack<String> stack = new Stack<>();
        stack.add("First");
        stack.add("Second");
        stack.add("Third");
        stack.add("Fourth");
        assertThat(stack).hasSize(4).containsExactly("First", "Second", "Third", "Fourth");
        assertThat(stack.peek()).isEqualTo("Fourth");
        assertThat(stack.size()).isEqualTo(4);
        assertThat(stack.pop()).isEqualTo("Fourth");
        assertThat(stack).hasSize(3).containsExactly("First", "Second", "Third");
    }
}
