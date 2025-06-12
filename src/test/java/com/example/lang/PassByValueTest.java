package com.example.lang;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * date: 2025-06-06
 * tags: java, lang, pass by
 */
class PassByValueTest {

    public Integer deduct(Integer i) {
        return i - 1;
    }

    public class Carrier {
        public Carrier(int capacity) {
            this.capacity = capacity;
        }

        public int capacity;
    }

    public void increaseCarrier(Carrier c, int add) {
        // c is new variable that point to the origin object
        // changing property of c causes the origin object to be changed also
        c.capacity += add;
    }

    public void destroyCarrier(Carrier c) {
        // c is another reference of origin object, not the original object itself
        // set to null is meaning less, because local variable will be deleted by GC after method is executed
        c = null;
    }

    @Test
    public void test() {
        Integer yahoo = Integer.valueOf(1000);
        assertThat(deduct(yahoo)).isEqualTo(999);
        assertThat(yahoo).isEqualTo(1000);

        Carrier carrier = new Carrier(2000);
        assertThat(carrier.capacity).isEqualTo(2000);
        increaseCarrier(carrier, 10);
        assertThat(carrier.capacity).isEqualTo(2010);
        destroyCarrier(carrier);
        assertThat(carrier.capacity).isEqualTo(2010);
    }
}
