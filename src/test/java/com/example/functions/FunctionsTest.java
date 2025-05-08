package com.example.functions;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-01
 * tags: java, function, Supplier
 */
class FunctionsTest {

    @Test
    public void suppliersTest() {
        Supplier<Lily> s = Lily::new;
        Lily lily = s.get();
        assertThat(lily.getName()).isEqualTo("lily");
    }

    @Test
    public void unaryOperatorTest() {
        UnaryOperator<String> stripFilter = (str) -> {
            return str.strip();
        };
        assertThat(stripFilter.apply(" ho ge ")).isEqualTo("ho ge");
    }

    public static class Lily {

        public Lily() {}

        public String getName() {
            return "lily";
        }
    }
}
