package com.example.designpatterns.creational;

import static org.assertj.core.api.Assertions.assertThat;

import java.nio.charset.Charset;
import java.text.NumberFormat;
import java.util.Calendar;
import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-15 tags: java, design patterns, creational, factory method
 */
class FactoryMethodTest {

    public static interface Car {
        String getInfo();
    }

    public static class SportCar implements Car {
        @Override
        public String getInfo() {
            return "SportCar";
        }
    }

    public static class SuvCar implements Car {
        @Override
        public String getInfo() {
            return "SuvCar";
        }
    }

    public static interface CarFactory {
        Car create();
    }

    public static class SuvCarFactory implements CarFactory {

        @Override
        public Car create() {
            return new SuvCar();
        }
    }

    public static class SportCarFactory implements CarFactory {

        @Override
        public Car create() {
            return new SportCar();
        }
    }

    @Test
    public void test() {
        Calendar.getInstance();
        NumberFormat.getInstance();
        Charset.forName("UTF-8");

        assertThat(new SportCarFactory().create().getInfo()).isEqualTo("SportCar");
        assertThat(new SuvCarFactory().create().getInfo()).isEqualTo("SuvCar");
    }
}
