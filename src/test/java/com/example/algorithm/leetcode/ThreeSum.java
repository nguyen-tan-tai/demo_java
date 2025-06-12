package com.example.algorithm.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import org.junit.jupiter.api.Test;

/**
 * date: 2025-06-08
 * tags: java, algorithm, array, two pointers, sorting
 */
class ThreeSum {

    static List<List<Integer>> findTriplets(int[] arr) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int j = 0; j < arr.length; j++) {
            for (int k = j + 1; k < arr.length; k++) {
                int val = -1 * (arr[j] + arr[k]);
                if (map.containsKey(val)) {
                    for (int i : map.get(val)) {
                        ans.add(Arrays.asList(i, j, k));
                    }
                }
            }
            map.putIfAbsent(arr[j], new ArrayList<>());
            map.get(arr[j]).add(j);
        }
        return ans;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i : nums) {
            m.put(i, m.getOrDefault(i, 0) + 1);
        }
        List<Entry<Integer, Integer>> uniqueList = new ArrayList<>(m.entrySet());
        int l = uniqueList.size();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < l; i++) {
            Entry<Integer, Integer> eI = uniqueList.get(i);
            if (eI.getKey() == 0 && eI.getValue() >= 3) {
                result.add(Arrays.asList(0, 0, 0));
            }
            for (int j = i + 1; j < l; j++) {
                Entry<Integer, Integer> eJ = uniqueList.get(j);
                if (eI.getKey() + 2 * eJ.getKey() == 0 && eJ.getValue() >= 2) {
                    result.add(Arrays.asList(eI.getKey(), eJ.getKey(), eJ.getKey()));
                }
                if (2 * eI.getKey() + eJ.getKey() == 0 && eI.getValue() >= 2) {
                    result.add(Arrays.asList(eI.getKey(), eI.getKey(), eJ.getKey()));
                }
                for (int k = j + 1; k < l; k++) {
                    Entry<Integer, Integer> eK = uniqueList.get(k);
                    if (eI.getKey() + eJ.getKey() + eK.getKey() == 0) {
                        result.add(Arrays.asList(eI.getKey(), eJ.getKey(), eK.getKey()));
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i : nums) {
            m.put(i, m.getOrDefault(i, 0) + 1);
        }
        List<Entry<Integer, Integer>> uniqueList = new ArrayList<>(m.entrySet());
        int l = uniqueList.size();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < l; i++) {
            Entry<Integer, Integer> eI = uniqueList.get(i);
            // 3 zeros
            if (eI.getKey() == 0 && eI.getValue() >= 3) {
                result.add(Arrays.asList(0, 0, 0));
                m.put(eI.getKey(), m.get(eI.getValue()) - 3);
            }
            for (int j = i + 1; j < l; j++) {
                Entry<Integer, Integer> eJ = uniqueList.get(j);
                if (eI.getKey() + 2 * eJ.getKey() == 0 && eI.getValue() >= 1 && eJ.getValue() >= 2) {
                    result.add(Arrays.asList(eI.getKey(), eJ.getKey(), eJ.getKey()));
                    m.put(eI.getKey(), m.get(eI.getValue()) - 1);
                    m.put(eJ.getKey(), m.get(eJ.getValue()) - 2);
                }
                if (2 * eI.getKey() + eJ.getKey() == 0 && eI.getValue() >= 2 && eJ.getValue() >= 1) {
                    result.add(Arrays.asList(eI.getKey(), eI.getKey(), eJ.getKey()));
                    m.put(eI.getKey(), m.get(eI.getValue()) - 2);
                    m.put(eJ.getKey(), m.get(eJ.getValue()) - 1);
                }
                for (int k = j + 1; k < l; k++) {
                    Entry<Integer, Integer> eK = uniqueList.get(k);
                    if (eI.getKey() + eJ.getKey() + eK.getKey() == 0
                            && eI.getValue() > 0 && eJ.getValue() > 0 && eK.getValue() > 0) {
                        result.add(Arrays.asList(eI.getKey(), eJ.getKey(), eK.getKey()));
                        m.put(eI.getKey(), m.get(eI.getValue()) - 1);
                        m.put(eJ.getKey(), m.get(eJ.getValue()) - 1);
                        m.put(eK.getKey(), m.get(eK.getValue()) - 1);
                    }
                }
            }
        }
        System.out.println(uniqueList);
        return result;
    }

    @Test
    public void test() {
        assertThat(findTriplets(new int[] { -1, 0, 1, 2, -1, -4 })).isEqualTo(Arrays.asList(Arrays.asList(-1, 0, 1), Arrays.asList(-1, -1, 2)));
//        assertThat(threeSum(new int[] { -1, 0, 1, 2, -1, -4 })).isEqualTo(Arrays.asList(Arrays.asList(-1, 0, 1), Arrays.asList(-1, -1, 2)));
//        assertThat(threeSum(new int[] { 1, 2, -3 })).isEqualTo(Arrays.asList(Arrays.asList(1, 2, -3)));
    }
}
