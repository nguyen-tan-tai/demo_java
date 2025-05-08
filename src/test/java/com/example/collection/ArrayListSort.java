package com.example.collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-01
 * tags: java, collection, ArrayList, sort
 */
class ArrayListSort {

    @Test
    public void test() {
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(1, 4, -10, 3, 5, 100));

        Collections.sort(list);
        assertThat(list).hasSize(6).containsExactly(-10, 1, 3, 4, 5, 100);

        list.sort(Comparator.reverseOrder());
        assertThat(list).hasSize(6).containsExactly(100, 5, 4, 3, 1, -10);

        List<Integer> newList = Arrays.asList(1, 4, -10, 3, 5, 100).stream().sorted().collect(Collectors.toList());
        assertThat(newList).hasSize(6).containsExactly(-10, 1, 3, 4, 5, 100);

        List<Integer> newListReverse = Arrays.asList(100, 5, 4, 3, 1, -10).stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        assertThat(newListReverse).hasSize(6).containsExactly(100, 5, 4, 3, 1, -10);

        // Override compare or using custom comparator for order null value
        try {
            Arrays.asList(100, null).stream().sorted().collect(Collectors.toList());
            fail();
        } catch (NullPointerException e) {
            // ignore
        } catch (Exception e) {
            fail(e);
        }
        List<Integer> listWithNull = Arrays.asList(100, 5, null, -10).stream().sorted(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 == null) {
                    return -1;
                }
                if (o2 == null) {
                    return 1;
                }
                return Integer.compare(o1, o2);
            }
        }).collect(Collectors.toList());
        assertThat(listWithNull).hasSize(4).containsExactly(null, -10, 5, 100);
    }
}
