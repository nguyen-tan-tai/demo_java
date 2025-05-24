package com.example.bitmanipulation;

import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-21
 * tags: java, bit manipulation, Arithmetic Operators
 */
class ArithmeticOperatorsTest {

    static int sum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }

    @Test
    public void testSum() {

    }
}
