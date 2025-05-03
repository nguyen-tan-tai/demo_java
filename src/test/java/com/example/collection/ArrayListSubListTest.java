package com.example.collection;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-01
 * tags: java, collection, ArrayList, subList
 */
class ArrayListSubListTest {

    @Test
    public void test() {
        List<Integer> oddList = Arrays.asList(1, 3, 5, 7, 9, 11, 13);
        List<Integer> list0_2 = oddList.subList(0, 2);
        assertThat(list0_2).hasSize(2);
        assertThat(list0_2.get(0)).isEqualTo(1);
        assertThat(list0_2.get(1)).isEqualTo(3);
        // assertThat(list0_2.get(2)).isEqualTo(5); //index = 2 is Exclusive

        List<Integer> list4_6 = oddList.subList(4, oddList.size());
        assertThat(list4_6).hasSize(3);
        assertThat(list4_6.get(0)).isEqualTo(9);
        assertThat(list4_6.get(1)).isEqualTo(11);
        assertThat(list4_6.get(2)).isEqualTo(13);
    }
}
