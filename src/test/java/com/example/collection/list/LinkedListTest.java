package com.example.collection.list;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-01
 * tags: java, collection, LinkedList
 */
class LinkedListTest {

    @Test
    public void test() {
        LinkedList<String> l = new LinkedList<String>();
        l.add("Second");
        l.addFirst("First");
        l.addLast("Fourth");
        l.add(2, "Third");
        assertThat(l).hasSize(4).containsExactly("First", "Second", "Third", "Fourth");
        assertThat(l.peekFirst()).isEqualTo("First");
        assertThat(l).hasSize(4).containsExactly("First", "Second", "Third", "Fourth");
        assertThat(l.peekLast()).isEqualTo("Fourth");
        assertThat(l).hasSize(4).containsExactly("First", "Second", "Third", "Fourth");

        assertThat(l.pollFirst()).isEqualTo("First");
        assertThat(l).hasSize(3).containsExactly("Second", "Third", "Fourth");
        assertThat(l.pollLast()).isEqualTo("Fourth");
        assertThat(l).hasSize(2).containsExactly("Second", "Third");

        l.addAll(Arrays.asList("Fifth", "Sixth"));
        l.push("Seventh");
        l.pop();
        assertThat(l).hasSize(4).containsExactly("Second", "Third", "Fifth", "Sixth");
        l.poll();
        assertThat(l).hasSize(3).containsExactly("Third", "Fifth", "Sixth");
    }
}
