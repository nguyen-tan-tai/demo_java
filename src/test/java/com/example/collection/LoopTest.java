package com.example.collection;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-01
 * tags: java, loop, for, forEach, while, do while
 */
class LoopTest {

    @Test
    public void testFor1() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                continue;
            }
            if (i > 7) {
                break;
            }
            list.add(i);
        }
        assertThat(list).hasSize(4);
        assertThat(list.get(0)).isEqualTo(1);
        assertThat(list.get(1)).isEqualTo(3);
        assertThat(list.get(2)).isEqualTo(5);
        assertThat(list.get(3)).isEqualTo(7);
    }

    @Test
    public void testForEvery() {
        List<Integer> list = new ArrayList<>();
        for (int i : Arrays.asList(1, 3, 5, 7)) {
            list.add(i);
        }
        assertThat(list).hasSize(4);
        assertThat(list.get(0)).isEqualTo(1);
        assertThat(list.get(1)).isEqualTo(3);
        assertThat(list.get(2)).isEqualTo(5);
        assertThat(list.get(3)).isEqualTo(7);
    }

    @Test
    public void testForEach() {
        List<Integer> list = new ArrayList<>();
        Arrays.asList(1, 3, 5, 7).forEach(e -> list.add(e));
        assertThat(list).hasSize(4);
        assertThat(list.get(0)).isEqualTo(1);
        assertThat(list.get(1)).isEqualTo(3);
        assertThat(list.get(2)).isEqualTo(5);
        assertThat(list.get(3)).isEqualTo(7);
    }

    @Test
    public void testForIterator() {
        List<Integer> list = new ArrayList<>();
        List<Integer> integers = Arrays.asList(1, 3, 5, 7);
        for (Iterator<Integer> iterator = integers.iterator(); iterator.hasNext();) {
            list.add(iterator.next());
        }
        assertThat(list).hasSize(4);
        assertThat(list.get(0)).isEqualTo(1);
        assertThat(list.get(1)).isEqualTo(3);
        assertThat(list.get(2)).isEqualTo(5);
        assertThat(list.get(3)).isEqualTo(7);
    }

    @Test
    public void testWhile() {
        List<Integer> list = new ArrayList<>();
        int i = 1;
        while (i <= 100) {
            if (i > 7) {
                break;
            }
            if (i % 2 == 1) {
                list.add(i);
            }
            i++;
        }
        assertThat(list).hasSize(4);
        assertThat(list.get(0)).isEqualTo(1);
        assertThat(list.get(1)).isEqualTo(3);
        assertThat(list.get(2)).isEqualTo(5);
        assertThat(list.get(3)).isEqualTo(7);
    }

    @Test
    public void testdoWhile() {
        List<Integer> list = new ArrayList<>();
        int i = 1;
        do {
            if (i > 7) {
                break;
            }
            if (i % 2 == 1) {
                list.add(i);
            }
            i++;
        } while (i <= 100);
        assertThat(list).hasSize(4);
        assertThat(list.get(0)).isEqualTo(1);
        assertThat(list.get(1)).isEqualTo(3);
        assertThat(list.get(2)).isEqualTo(5);
        assertThat(list.get(3)).isEqualTo(7);
    }
}
