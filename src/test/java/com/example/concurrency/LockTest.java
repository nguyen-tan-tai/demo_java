package com.example.concurrency;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-01 tags: java, concurrent, thread, lock
 */
class LockTest {

    static class Counter {
        private int count = 0;
        private Lock lock = new ReentrantLock();

        public void increment() {
            lock.lock();
            try {
                count++;
            } finally {
                lock.unlock();
            }
        }

        public int getCount() {
            lock.lock();
            try {
                return count;
            } finally {
                lock.unlock();
            }
        }
    }

    @Test
    public void test() throws InterruptedException, ExecutionException {
        for (int i = 0; i < 100; i++) {

            Counter counter = new Counter();
            ExecutorService executorService1 = Executors.newFixedThreadPool(2);
            Future<?> f0 = executorService1.submit(new Runnable() {
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        counter.increment();
                    }
                }
            });
            Future<?> f1 = executorService1.submit(new Runnable() {
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        counter.increment();
                    }
                }
            });
            f0.get();
            f1.get();
            assertThat(counter.getCount()).isEqualTo(20000);
        }
    }
}
