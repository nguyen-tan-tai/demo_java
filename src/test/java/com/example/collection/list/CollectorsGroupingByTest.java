package com.example.collection.list;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-01
 * tags: java, collection, groupingBy, Comparable
 */
class CollectorsGroupingByTest {

    @Test
    public void testGroupBy() {
        Employee e1 = new Employee(1L, "John", 105);
        Employee e2 = new Employee(2L, "Tim", 33);
        Employee e3 = new Employee(3L, "Andrew", 33);
        Employee e4 = new Employee(4L, "Peter", 38);
        Employee e5 = new Employee(5L, "Nathan", 22);
        Employee e6 = new Employee(6L, "George", 23);
        List<Employee> employees = Arrays.asList(e1, e2, e3, e4, e5, e6);

        Map<String, List<Employee>> employeesByAgeRange = employees.stream().collect(Collectors.groupingBy(Employee::getAgeRange));
        // Alternative syntax
        employees.stream().collect(Collectors.groupingBy(e -> e.getAgeRange(), Collectors.toList()));
        employees.stream().collect(Collectors.groupingBy(e -> e.getAgeRange(), HashMap::new, Collectors.toList()));

        List<String> ageGroups = employeesByAgeRange.keySet().stream().sorted().collect(Collectors.toList());
        assertThat(ageGroups).hasSize(3);
        assertThat(ageGroups.get(0)).isEqualTo("100-109");
        List<Employee> employeeGroup100_199 = employeesByAgeRange.get("100-109");
        assertThat(employeeGroup100_199).hasSize(1);
        assertThat(employeeGroup100_199.get(0).getId()).isEqualTo(1L);
        assertThat(employeeGroup100_199.get(0).getAge()).isEqualTo(105);

        assertThat(ageGroups.get(1)).isEqualTo("20-29");
        List<Employee> employeeGroup20_29 = employeesByAgeRange.get("20-29").stream().sorted().collect(Collectors.toList());
        assertThat(employeeGroup20_29).hasSize(2);
        assertThat(employeeGroup20_29.get(0).getId()).isEqualTo(6L);
        assertThat(employeeGroup20_29.get(0).getAge()).isEqualTo(23);

        assertThat(employeeGroup20_29.get(1).getId()).isEqualTo(5L);
        assertThat(employeeGroup20_29.get(1).getAge()).isEqualTo(22);

        assertThat(ageGroups.get(2)).isEqualTo("30-39");
        List<Employee> employeeGroup30_39 = employeesByAgeRange.get("30-39").stream().sorted().collect(Collectors.toList());
        assertThat(employeeGroup30_39).hasSize(3);
        assertThat(employeeGroup30_39.get(0).getId()).isEqualTo(4L);
        assertThat(employeeGroup30_39.get(0).getAge()).isEqualTo(38);

        assertThat(employeeGroup30_39.get(1).getId()).isEqualTo(3L);
        assertThat(employeeGroup30_39.get(1).getAge()).isEqualTo(33);

        assertThat(employeeGroup30_39.get(2).getId()).isEqualTo(2L);
        assertThat(employeeGroup30_39.get(2).getAge()).isEqualTo(33);
    }

    static class Employee implements Comparable<Employee> {

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

        public String getAgeRange() {
            int base = Double.valueOf(Math.floor(this.age / 10d)).intValue() * 10;
            return base + "-" + (base + 9);
        }
    }
}
