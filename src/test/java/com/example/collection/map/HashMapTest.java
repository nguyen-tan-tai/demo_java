package com.example.collection.map;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-19
 * tags: java, collection, HashMap
 * note: A hash map is good as a general-purpose map implementation that provides rapid storage and retrieval operations. However, it falls short because of its chaotic and unorderly arrangement of entries. This causes it to perform poorly in scenarios where there is a lot of iteration as the entire capacity of the underlying array affects traversal other than just the number of entries.
 */
class HashMapTest {

    class Employee {

        public Employee(int id) {
            this.id = id;
        }

        private int id;


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    @Test
    public void test() {
        Map<String, Integer> map = new HashMap<>();
        map.put("dog", 128);
        map.put("cat", 255);
        map.put("chicken", 1024);
        assertThat(map).hasSize(3).containsKeys("dog", "cat", "chicken");
        assertThat(map.get("dog")).isEqualTo(128);
        assertThat(map.get("cat")).isEqualTo(255);
        assertThat(map.get("chicken")).isEqualTo(1024);

        Map<Employee, Integer> employeeMap = new HashMap<>();
        Employee e1 = new Employee(1000);
        Employee e2 = new Employee(1000);
        employeeMap.put(e1, 128);
        employeeMap.put(e2, 256);
        assertThat(employeeMap).containsKeys(e1, e2);
        assertThat(employeeMap.get(e1)).isEqualTo(128);
        assertThat(employeeMap.get(e2)).isEqualTo(256);

        HashMap<Book, Integer> bookMap = new HashMap<>();
        bookMap.put(new Book(1000), 128);
        bookMap.put(new Book(1000), 256);
        assertThat(bookMap).hasSize(1);
        assertThat(bookMap).containsKeys(new Book(1000));
        assertThat(bookMap).containsValue(256);
    }

    class Book {

        public Book(int id) {
            this.id = id;
        }

        private int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object other) {
            if (other == this) {
                return true;
            }
            if (!(other instanceof Book)) {
                return false;
            }
            Book otherBook = (Book) other;
            return this.id == otherBook.getId();
        }

        @Override
        public int hashCode() {
            return this.id;
        }
    }
}
