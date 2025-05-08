package com.example.collection;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-01
 * tags: java, collection, ArrayList, Set
 */
class ArrayListToSet {

    @Test
    public void test() {
        List<Integer> list = Arrays.asList(1, 4, -10, 3, null, 4, null);
        Set<Integer> set1 = new HashSet<>(list);
        assertThat(set1).hasSize(5).containsExactlyInAnyOrder(null, -10, 1, 3, 4);

        Set<Integer> set2 = list.stream().collect(Collectors.toSet());
        assertThat(set2).hasSize(5).containsExactlyInAnyOrder(null, -10, 1, 3, 4);

        Set<Integer> set3 = new HashSet<>();
        for (Integer i : list) {
            set3.add(i);
        }
        assertThat(set3).hasSize(5).containsExactlyInAnyOrder(null, -10, 1, 3, 4);
    }
}
