package com.example.concurrency;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-01 tags: java, concurrent, thread, ExecutorService
 */
class ExecutorServiceTest {
    static class TimePrinter implements Runnable {
        @Override
        public void run() {
            System.out.println(LocalDateTime.now());
        }
    }

    static class PowerCalcualtor implements Callable<Integer> {

        private int value;

        public PowerCalcualtor(int value) {
            this.value = value;
        }

        @Override
        public Integer call() throws Exception {
            return (int) Math.pow(this.value, 2);
        }
    }

    @Test
    public void test() throws InterruptedException, ExecutionException {
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        Future<?> f0 = executorService1.submit(new TimePrinter());
        f0.get();
        assertThat(f0.isDone()).isTrue();

        ExecutorService executorService2 = Executors.newFixedThreadPool(2);
        Future<Integer> f1 = executorService2.submit(new PowerCalcualtor(2));
        Future<Integer> f2 = executorService2.submit(new PowerCalcualtor(3));
        assertThat(f1.get() + f2.get()).isEqualTo(13);
        executorService2.shutdown();
    }
}
