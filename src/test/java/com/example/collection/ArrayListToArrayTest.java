package com.example.collection;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-01
 * tags: java, collection, ArrayList, retainAll
 */
class ArrayListToArrayTest {

    @Test
    public void testUseToArray() {
        List<Integer> list = Arrays.asList(1, 3, 5);
        Integer[] arr = new Integer[list.size()];
        list.toArray(arr);
        assertThat(arr).hasSize(3);
        assertThat(arr[0]).isEqualTo(1);
        assertThat(arr[1]).isEqualTo(3);
        assertThat(arr[2]).isEqualTo(5);
    }

    @Test
    public void testUseStream() {
        List<Integer> list = Arrays.asList(1, 3, 5);
        int[] arr = list.stream().mapToInt(i -> i).toArray();
        assertThat(arr).hasSize(3);
        assertThat(arr[0]).isEqualTo(1);
        assertThat(arr[1]).isEqualTo(3);
        assertThat(arr[2]).isEqualTo(5);
    }

    @Test
    public void testUseLoop() {
        List<Integer> list = Arrays.asList(1, 3, 5);
        Integer[] arr = new Integer[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        list.toArray(arr);
        assertThat(arr).hasSize(3);
        assertThat(arr[0]).isEqualTo(1);
        assertThat(arr[1]).isEqualTo(3);
        assertThat(arr[2]).isEqualTo(5);
    }
}
