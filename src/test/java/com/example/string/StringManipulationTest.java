package com.example.string;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-01
 * tags: java, string
 */
class StringManipulationTest {

    @Test
    public void testSubString() {
        Assertions.assertThat("0123456789".substring(5)).isEqualTo("56789");
        Assertions.assertThat("0123456789".substring(5, 6)).isEqualTo("5");
        String s0123456789 = "0123456789";
        Assertions.assertThat(s0123456789.substring(5, s0123456789.length())).isEqualTo("56789");
    }

    @Test
    public void testTrim() {
        Assertions.assertThat(" hoge ".trim()).isEqualTo("hoge");
        Assertions.assertThat(" hoge \t".trim()).isEqualTo("hoge");
        Assertions.assertThat(" hoge \n".trim()).isEqualTo("hoge");
    }

    @Test
    public void testStrip() {
        Assertions.assertThat(" hoge ".strip()).isEqualTo("hoge");
        Assertions.assertThat(" hoge \t".strip()).isEqualTo("hoge");
        Assertions.assertThat(" hoge \n".strip()).isEqualTo("hoge");
    }
}
