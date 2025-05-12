package com.example.concurrency;

import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-01 tags: java, concurrent, thread, ExecutorService
 */
class ThreadAndRunable {

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("I am a thread from Thread. My name = " + this.getName());
        }
    }

    static class MyRunable implements Runnable {
        @Override
        public void run() {
            System.out.println("I am a thread from Runable. My name = " + this.getClass());
        }
    }

    @Test
    public void test() {
        new MyThread().start();
        new Thread(new MyRunable()).start();
        new Thread() {
            public void run() {
                System.out.println("Thread running from anonymous class");
            }
        }.start();
        new Thread(new Runnable() {
            public void run() {
                System.out.println("Thread running from anonymous Runnable");
            }
        }).start();
    }
}
