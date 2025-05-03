package com.example.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-01
 * tags: java, Comparator, Comparable
 */
class ComparableComparatorTest {

    @Test
    public void testComparator() {
        Employee e1 = new Employee(1L, "John", 30);
        Employee e2 = new Employee(2L, "Tim", 40);
        Employee e3 = new Employee(3L, "Andrew", 33);
        Employee e4 = new Employee(4L, "Andrew", 33);
        Employee e5 = new Employee(5L, "Andrew", 35);
        List<Employee> employees = Arrays.asList(e1, e2, e4, e3, e5);
        Collections.sort(employees, new Comparator<Employee>() {

            @Override
            public int compare(Employee e1, Employee e2) {
                if (e1.getAge() != e2.getAge()) {
                    return Integer.compare(e2.getAge(), e1.getAge());
                }
                if (e1.getName().equals(e2.getName())) {
                    return Long.compare(e1.getId(), e2.getId());
                }
                return e1.getName().compareToIgnoreCase(e2.getName());
            }
        });
        Assertions.assertThat(employees).hasSize(5);
        Assertions.assertThat(employees.get(0).getId()).isEqualTo(2L);
        Assertions.assertThat(employees.get(0).getName()).isEqualTo("Tim");
        Assertions.assertThat(employees.get(0).getAge()).isEqualTo(40);

        Assertions.assertThat(employees.get(1).getId()).isEqualTo(5L);
        Assertions.assertThat(employees.get(1).getName()).isEqualTo("Andrew");
        Assertions.assertThat(employees.get(1).getAge()).isEqualTo(35);

        Assertions.assertThat(employees.get(2).getId()).isEqualTo(3L);
        Assertions.assertThat(employees.get(2).getName()).isEqualTo("Andrew");
        Assertions.assertThat(employees.get(2).getAge()).isEqualTo(33);

        Assertions.assertThat(employees.get(3).getId()).isEqualTo(4L);
        Assertions.assertThat(employees.get(3).getName()).isEqualTo("Andrew");
        Assertions.assertThat(employees.get(3).getAge()).isEqualTo(33);

        Assertions.assertThat(employees.get(4).getId()).isEqualTo(1L);
        Assertions.assertThat(employees.get(4).getName()).isEqualTo("John");
        Assertions.assertThat(employees.get(4).getAge()).isEqualTo(30);
    }

    class Employee {

        public Employee(long id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        private long id;
        private String name;
        private int age;

        public long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }


    @Test
    public void testComparable() {
        ComparableEmployee e1 = new ComparableEmployee(1L, "John", 30);
        ComparableEmployee e2 = new ComparableEmployee(2L, "Tim", 40);
        ComparableEmployee e3 = new ComparableEmployee(3L, "Andrew", 33);
        ComparableEmployee e4 = new ComparableEmployee(4L, "Andrew", 33);
        ComparableEmployee e5 = new ComparableEmployee(5L, "Andrew", 35);
        List<ComparableEmployee> employees = Arrays.asList(e1, e2, e4, e3, e5);
        Collections.sort(employees);

        Assertions.assertThat(employees).hasSize(5);
        Assertions.assertThat(employees.get(0).getId()).isEqualTo(2L);
        Assertions.assertThat(employees.get(0).getName()).isEqualTo("Tim");
        Assertions.assertThat(employees.get(0).getAge()).isEqualTo(40);

        Assertions.assertThat(employees.get(1).getId()).isEqualTo(5L);
        Assertions.assertThat(employees.get(1).getName()).isEqualTo("Andrew");
        Assertions.assertThat(employees.get(1).getAge()).isEqualTo(35);

        Assertions.assertThat(employees.get(2).getId()).isEqualTo(3L);
        Assertions.assertThat(employees.get(2).getName()).isEqualTo("Andrew");
        Assertions.assertThat(employees.get(2).getAge()).isEqualTo(33);

        Assertions.assertThat(employees.get(3).getId()).isEqualTo(4L);
        Assertions.assertThat(employees.get(3).getName()).isEqualTo("Andrew");
        Assertions.assertThat(employees.get(3).getAge()).isEqualTo(33);

        Assertions.assertThat(employees.get(4).getId()).isEqualTo(1L);
        Assertions.assertThat(employees.get(4).getName()).isEqualTo("John");
        Assertions.assertThat(employees.get(4).getAge()).isEqualTo(30);
    }

    class ComparableEmployee extends Employee implements Comparable<Employee> {

        public ComparableEmployee(long id, String name, int age) {
            super(id, name, age);
        }

        @Override
        public int compareTo(Employee e2) {
            if (this.getAge() != e2.getAge()) {
                return Integer.compare(e2.getAge(), this.getAge());
            }
            if (this.getName().equals(e2.getName())) {
                return Long.compare(this.getId(), e2.getId());
            }
            return this.getName().compareToIgnoreCase(e2.getName());
        }
    }

}
