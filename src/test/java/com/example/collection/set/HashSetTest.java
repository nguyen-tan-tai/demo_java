package com.example.collection.set;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-21
 * tags: java, collection, HashSet
 */
class HashSetTest {

    @Test
    public void test() {
        Set<Integer> set = new HashSet<>();
        set.addAll(Arrays.asList(1, 4, 100, 1, 5, 100));
        assertThat(set).hasSize(4).containsExactly(1, 4, 100, 5);

        Set<Employee> employeeSet = new HashSet<>();
        employeeSet.add(new Employee(1000));
        employeeSet.add(new Employee(1000));
        assertThat(employeeSet).hasSize(2);

        Set<Book> bookSet = new HashSet<>();
        bookSet.add(new Book(1000));
        bookSet.add(new Book(1000));
        assertThat(bookSet).hasSize(1);
        assertThat(bookSet.contains(new Book(1000))).isTrue();
    }

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
