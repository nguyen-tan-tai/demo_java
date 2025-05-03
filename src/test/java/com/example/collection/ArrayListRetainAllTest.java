package com.example.collection;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-01
 * tags: java, collection, ArrayList, retainAll
 */
class ArrayListRetainAllTest {

    @Test
    public void test() {
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(1, 3, 5, 7, 9, 11, 13));
        list.retainAll(Arrays.asList(1, 3, 11, 13, 15));
        assertThat(list).hasSize(4);
        assertThat(list.get(0)).isEqualTo(1);
        assertThat(list.get(1)).isEqualTo(3);
        assertThat(list.get(2)).isEqualTo(11);
        assertThat(list.get(3)).isEqualTo(13);
    }
}
