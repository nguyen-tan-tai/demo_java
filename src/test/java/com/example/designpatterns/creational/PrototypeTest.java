package com.example.designpatterns.creational;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;
import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-15<br>
 * tags: java, design patterns, creational, prototype
 */
class PrototypeTest {

    abstract class Car {

        private String uuid;

        private String model;

        public Car(String model) {
            this.uuid = UUID.randomUUID().toString();
            this.model = model;
        }

        public Car(Car originCar) {
            if (originCar != null) {
                this.model = originCar.model;
            }
        }

        public abstract Car clone();

        @Override
        public boolean equals(Object another) {
            if (!(another instanceof Car)) {
                return false;
            }
            Car anotherCar = (Car) another;
            return anotherCar.uuid == this.uuid;
        }
    }

    class SportCar extends Car {
        public SportCar(String model) {
            super(model);
        }

        public SportCar(SportCar originCar) {
            super(originCar);
        }

        @Override
        public Car clone() {
            return new SportCar(this);
        }

    }

    @Test
    public void test() {
        Car t3 = new SportCar("T3");
        Car copyT3 = t3.clone();
        assertThat(t3.equals(copyT3)).isEqualTo(false);
        assertThat(t3.model.equals(copyT3.model)).isEqualTo(true);
    }
}
