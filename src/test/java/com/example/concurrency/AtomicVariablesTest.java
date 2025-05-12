package com.example.concurrency;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-11 tags: java, concurrent, thread, atomic variable
 */
class AtomicVariablesTest {

    static class ProcessingThread implements Runnable {
        // If primitive is used, the result can be varied
        private AtomicInteger count = new AtomicInteger();

        @Override
        public void run() {
            for (int i = 0; i < 2; i++) {
                processSomething(i);
                count.incrementAndGet();
            }
        }

        public int getCount() {
            return count.get();
        }

        private void processSomething(int i) {
            try {
                Thread.sleep(i * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test() throws InterruptedException {
        ProcessingThread pt = new ProcessingThread();
        Thread t1 = new Thread(pt, "t1");
        t1.start();
        Thread t2 = new Thread(pt, "t2");
        t2.start();
        t1.join();
        t2.join();
        assertThat(pt.getCount()).isEqualTo(4);
    }
}
