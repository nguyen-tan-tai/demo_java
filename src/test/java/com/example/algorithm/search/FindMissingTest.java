package com.example.algorithm.search;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

/**
 * date: 2025-06-01
 * tags: java, algorithm, search
 */
class FindMissingItemTest {

    public List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        Map<Integer, Long> freqA = arr.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        Map<Integer, Long> freqB = brr.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        Set<Integer> missing = new HashSet<>();
        for (Entry<Integer, Long> e : freqB.entrySet()) {
            Integer key = e.getKey();
            if (!freqA.containsKey(key) || !freqA.get(key).equals(freqB.get(key))) {
                missing.add(key);
            }
        }
        return missing.stream().sorted().collect(Collectors.toList());
    }

    @Test
    public void test() {
        assertThat(missingNumbers(Arrays.asList(203, 204, 205, 206, 207, 208, 203, 204, 205, 206),
                Arrays.asList(203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204)))
                .isEqualTo(Arrays.asList(204, 205, 206));
    }
}
