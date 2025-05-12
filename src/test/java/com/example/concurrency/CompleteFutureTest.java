package com.example.concurrency;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-01 tags: java, concurrent, thread, completable future
 */
class CompleteFutureTest {

    @Test
    public void test() throws InterruptedException, ExecutionException {
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> 10 / 2);
        assertThat(cf1.get()).isEqualTo(5);

        CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(() -> 10 / 0).exceptionally(ex -> 0);
        assertThat(cf2.get()).isEqualTo(0);
    }
}
