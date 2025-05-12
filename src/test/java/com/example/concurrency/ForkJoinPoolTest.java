package com.example.concurrency;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-01 tags: java, concurrent, thread, fork join pool
 */
class ForkJoinPoolTest {
    static class SumTask extends RecursiveTask<Long> {
        private static final long serialVersionUID = 1L;

        private List<Integer> list;

        public SumTask(List<Integer> list) {
            this.list = list;
        }

        @Override
        protected Long compute() {
            int size = list.size();
            if (size == 0) {
                return 0L;
            }
            if (size == 1) {
                return (long) list.get(0);
            }
            SumTask a1 = new SumTask(list.subList(0, size / 2));
            a1.fork();
            SumTask a2 = new SumTask(list.subList(size / 2, size));
            a2.fork();
            return a1.join() + a2.join();
        }
    }

    @Test
    public void test() {
        ForkJoinPool actionPool = ForkJoinPool.commonPool();
        Long result = actionPool.invoke(new SumTask(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));
        assertThat(result).isEqualTo(45);
        actionPool.shutdown();
    }
}
