package com.example.bitmanipulation;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-21
 * tags: java, bit manipulation, Bitwise Operators
 */
class BitwiseOperatorsTest {

    @Test
    public void testBitwiseAnd() {
        assertThat(0b00000000 & 0b00000000).isEqualTo(0);
        assertThat(0b00000000 & 0b00000001).isEqualTo(0);
        assertThat(0b00000001 & 0b00000001).isEqualTo(1);
        assertThat(0b00000000 & 0b00000000).isEqualTo(0);

        assertThat(Integer.toBinaryString(0b10101010 & 0b01010101)).isEqualTo("0");
        assertThat(Integer.toBinaryString(0b11111111 & 0b01010101)).isEqualTo("1010101");
        assertThat(Integer.toBinaryString(0b00000000 & 0b01010101)).isEqualTo("0");
    }

    @Test
    public void testBitwiseOr() {
        assertThat(0b00000001 | 0b00000000).isEqualTo(1);
        assertThat(0b00000000 | 0b00000001).isEqualTo(1);
        assertThat(0b00000001 | 0b00000001).isEqualTo(1);
        assertThat(0b00000000 | 0b00000000).isEqualTo(0);

        assertThat(Integer.toBinaryString(0b10101010 | 0b01010101)).isEqualTo("11111111");
        assertThat(Integer.toBinaryString(0b11111111 | 0b01010101)).isEqualTo("11111111");
        assertThat(Integer.toBinaryString(0b00000000 | 0b01010101)).isEqualTo("1010101");
    }

    @Test
    public void testBitwiseXor() {
        assertThat(0b00000001 ^ 0b00000000).isEqualTo(1);
        assertThat(0b00000000 ^ 0b00000001).isEqualTo(1);
        assertThat(0b00000001 ^ 0b00000001).isEqualTo(0);
        assertThat(0b00000000 ^ 0b00000000).isEqualTo(0);

        assertThat(Integer.toBinaryString(0b10101010 ^ 0b01010101)).isEqualTo("11111111");
        assertThat(Integer.toBinaryString(0b11111111 ^ 0b01010101)).isEqualTo("10101010");
        assertThat(Integer.toBinaryString(0b00000000 ^ 0b01010101)).isEqualTo("1010101");
        assertThat(Integer.toBinaryString(0b11111111 ^ 0b11111111)).isEqualTo("0");
        assertThat(Integer.toBinaryString(0b00000000 ^ 0b00000000)).isEqualTo("0");
    }

    @Test
    public void testBitwiseComplement() {
        assertThat(~5).isEqualTo(-6);
        assertThat(~-6).isEqualTo(5);
        assertThat(~1).isEqualTo(-2);
        assertThat(~0).isEqualTo(-1);
        assertThat(~-1).isEqualTo(0);
        assertThat(~-2).isEqualTo(1);
        assertThat(~1000).isEqualTo(-1001);
        assertThat(~-1001).isEqualTo(1000);
        assertThat(~-1000).isEqualTo(999);
    }

    @Test
    public void testSignedLeftShift() {
        assertThat(Integer.toBinaryString(0b00000001 << 1)).isEqualTo("10");
        assertThat(Integer.toBinaryString(0b00000001 << 2)).isEqualTo("100");
        assertThat(Integer.toBinaryString(0b00000101 << 3)).isEqualTo("101000");
        assertThat(Integer.toBinaryString(0b01010101 << 4)).isEqualTo("10101010000");
    }

    @Test
    public void testSignedRightShift() {
        assertThat(Integer.toBinaryString(0b00000001 >> 1)).isEqualTo("0");
        assertThat(Integer.toBinaryString(0b00000101 >> 2)).isEqualTo("1");
        assertThat(Integer.toBinaryString(0b00100101 >> 3)).isEqualTo("100");
        assertThat(Integer.toBinaryString(0b11010101 >> 4)).isEqualTo("1101");
    }

    @Test
    public void testUnsignedRightShift() {
        assertThat(Integer.toBinaryString(8 >>> 2))
                .isEqualTo("10");// 2
        assertThat(Integer.toBinaryString(-8 >>> 2))
                .isEqualTo("111111111111111111111111111110");// 1073741822
    }
}
