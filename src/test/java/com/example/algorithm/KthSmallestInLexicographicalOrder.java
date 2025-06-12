package com.example.algorithm;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

/**
 * date: 2025-06-09
 * tags: java, algorithm, K-th Smallest in Lexicographical Order
 */
class KthSmallestInLexicographicalOrder {

    public int findKthNumber(int n, int k) {
        Queue<String> queue = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
        for (int i = 1; i <= n; i++) {
            queue.add(Integer.toString(i));
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return Integer.valueOf(queue.peek());
    }

    private int upperLimit;

    public int findKthNumber2(int n, int k) {
        IntStream.range(1, n + 1).boxed().map(e -> Integer.toString(e)).sorted().forEach(e -> System.out.println(e));
        this.upperLimit = n;
        long current = 1;
        k--;
        while (k > 0) {
            int count = getCount(current);
            System.out.println("k=" + k + "  count=" + count);
            if (k >= count) {
                k -= count;
                current++;
            } else {
                k--;
                current *= 10;
            }
        }
        return (int) current;
    }

    public int getCount(long current) {
        long next = current + 1;
        long count = 0;
        while (current <= upperLimit) {
            count += Math.min(upperLimit - current + 1, next - current);
            next *= 10;
            current *= 10;
        }
        return (int) count;
    }

    public int findKthNumber3(int n, int k) {
        int[] arr = Arrays.stream(Integer.toString(k).split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(Arrays.toString(arr));
        return 0;
    }

    @Test
    public void test() {
        assertThat(findKthNumber2(13, 2)).isEqualTo(10);
//        assertThat(findKthNumber3(5000, 1000)).isEqualTo(1899);
    }
}
