package com.example.collection.list;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

/**
 * date: 2025-05-01
 * tags: java, collection, partitioningBy
 */
class CollectorsPartitioningByTest {

    @Test
    public void testPartitioningBy() {
        Employee e1 = new Employee(1L, "John", 34);
        Employee e2 = new Employee(2L, "Tim", 32);
        Employee e3 = new Employee(3L, "Andrew", 33);
        Employee e4 = new Employee(4L, "Peter", 31);
        Employee e5 = new Employee(5L, "Nathan", 22);
        Employee e6 = new Employee(6L, "George", 23);
        List<Employee> employees = Arrays.asList(e1, e2, e3, e4, e5, e6);

        Map<Boolean, List<Employee>> employeesByAge = employees.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 30));
        // Alternative syntax
        employees.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 30, Collectors.toList()));

        List<Employee> youngEmployees = employeesByAge.get(false).stream().sorted((a, b) -> Integer.compare(a.getAge(), b.getAge())).collect(Collectors.toList());
        assertThat(youngEmployees).hasSize(2);
        assertThat(youngEmployees.get(0).getId()).isEqualTo(5L);
        assertThat(youngEmployees.get(0).getAge()).isEqualTo(22);

        assertThat(youngEmployees.get(1).getId()).isEqualTo(6L);
        assertThat(youngEmployees.get(1).getAge()).isEqualTo(23);

        List<Employee> oldEmployees = employeesByAge.get(true).stream().sorted((a, b) -> Integer.compare(a.getAge(), b.getAge())).collect(Collectors.toList());
        assertThat(oldEmployees).hasSize(4);
        assertThat(oldEmployees.get(0).getId()).isEqualTo(4L);
        assertThat(oldEmployees.get(0).getAge()).isEqualTo(31);

        assertThat(oldEmployees.get(1).getId()).isEqualTo(2L);
        assertThat(oldEmployees.get(1).getAge()).isEqualTo(32);

        assertThat(oldEmployees.get(2).getId()).isEqualTo(3L);
        assertThat(oldEmployees.get(2).getAge()).isEqualTo(33);

        assertThat(oldEmployees.get(3).getId()).isEqualTo(1L);
        assertThat(oldEmployees.get(3).getAge()).isEqualTo(34);
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
}
