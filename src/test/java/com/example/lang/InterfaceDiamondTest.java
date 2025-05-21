package com.example.lang;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-01
 * tags: java, string
 */
class InterfaceDiamondTest {

    interface A {

        public void method1();
    }

    interface B extends A {

        public void method2();
    }

    interface C extends A {

        public void method3();
    }


    class D implements B, C {

        @Override
        public void method1() {
            
            System.out.println();
        }

        @Override
        public void method3() {
        }

        @Override
        public void method2() {}
    }


    @Test
    public void testStrip() {
        Assertions.assertThat(" hoge ".strip()).isEqualTo("hoge");
        Assertions.assertThat(" hoge \t".strip()).isEqualTo("hoge");
        Assertions.assertThat(" hoge \n".strip()).isEqualTo("hoge");
    }
}
