package com.example.concurrency;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-01 tags: java, concurrent, thread, block queue
 */
class BlockingQueueTest {
    @Test
    public void test() throws InterruptedException {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        for (Integer i = 0; i < 5; i++) {
            queue.add(i);
        }
        assertThat(queue).hasSize(5).containsExactly(0, 1, 2, 3, 4);
    }
}
