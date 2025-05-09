package com.example.designpatterns.creational;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;
import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-08
 * tags: java, design patterns, creational, singleton
 */
class SingletonTest {

    public static class Singleton {

        private static Singleton instance;

        private String name;

        private Singleton(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public static synchronized Singleton getInstance() {
            if (instance == null) {
                instance = new Singleton(UUID.randomUUID().toString());
            }
            return instance;
        }
    }

    @Test
    public void test() {
        for (int i = 0; i < 100; i++) {
            assertThat(Singleton.getInstance() == Singleton.getInstance()).isTrue();
            assertThat(Singleton.getInstance().getName().equals(Singleton.getInstance().getName())).isTrue();
        }
    }
}
