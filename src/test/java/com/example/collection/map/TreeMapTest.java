package com.example.collection.map;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-19
 * tags: java, collection, TreeMap
 * note: A tree map takes ordering to the next level by providing complete control over how the keys should be sorted. On the flip side, it offers worse general performance than the other two alternatives.
 */
class TreeMapTest {

    @Test
    public void test() {
        Map<String, Integer> map = new TreeMap<>();
        map.put("dog", 128);
        map.put("cat", 255);
        map.put("chicken", 1024);
        assertThat(map).hasSize(3);
        assertThat(map.keySet().toString()).isEqualTo("[cat, chicken, dog]");
        assertThat(map.get("dog")).isEqualTo(128);
        assertThat(map.get("cat")).isEqualTo(255);
        assertThat(map.get("chicken")).isEqualTo(1024);

        Map<String, Integer> descMap = new TreeMap<>(Comparator.reverseOrder());
        descMap.put("a", 128);
        descMap.put("c", 255);
        descMap.put("g", 4096);
        descMap.put("b", 1024);
        assertThat(descMap).hasSize(4);
        assertThat(descMap.keySet().toString()).isEqualTo("[g, c, b, a]");
    }
}
